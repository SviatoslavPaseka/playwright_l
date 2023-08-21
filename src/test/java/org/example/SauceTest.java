package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import sauceDemoPages.*;
import sauceDemoPages.enums.ItemLinks;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalTime;

public class SauceTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;
    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser(){
        browser.close();
    }

    @BeforeEach
    public void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }
    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void loginTest() {
        defaultLogin();
        makeScreenshot();
    }

    private void defaultLogin() {
        new LoginPage(page).navigate().login("standard_user", "secret_sauce");
        Assertions.assertTrue(page.locator("//div[@class='app_logo']").isVisible(), "[INVENTORY PAGE] is not opened");
    }

    private void makeScreenshot() {
        URL location = MethodHandles.lookup().lookupClass().getProtectionDomain().getCodeSource().getLocation();
        String path = location.getFile().replace("test-classes/", "") +
                "screenshots/screenshot-" + LocalTime.now().toString() + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
    }

    @Test
    void loginNotHeadlessTest() throws InterruptedException {
        defaultLogin();
        makeScreenshot();
        page.locator("//button[@id='react-burger-menu-btn']").click();
        page.locator("//a[@id='logout_sidebar_link']").click();
    }

    @Test
    void getAllProductsNameDescrPrice(){
        defaultLogin();
        InventoryPage inventoryPage =  new InventoryPage(page);

    }

    @Test
    void addToCartTest() {
        defaultLogin();
        InventoryPage inventoryPage =  new InventoryPage(page);
        SauceCommonPage commonPage = new SauceCommonPage(page);
        inventoryPage.clickAddToCartButton(ItemLinks.I2);
        commonPage.openShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        System.out.println( shoppingCartPage.getProductPrice(ItemLinks.I2));
    }

    @Test
    void checkoutTest() {
        defaultLogin();
        InventoryPage inventoryPage =  new InventoryPage(page);
        SauceCommonPage commonPage = new SauceCommonPage(page);
        inventoryPage.clickAddToCartButton(ItemLinks.I2);
        Double priceOfProduct = inventoryPage.getProductPrice(ItemLinks.I2);
        commonPage.openShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        Assertions.assertEquals(priceOfProduct, shoppingCartPage.getProductPrice(ItemLinks.I2));
        shoppingCartPage.clickCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(page);
        checkoutStepOnePage.inputCheckoutInformation("asdasd", "asdasd", "123123");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(page);
        Assertions.assertEquals(priceOfProduct, checkoutStepTwoPage.getItemTotalPrice());
        Assertions.assertEquals(priceOfProduct, Math.round((checkoutStepTwoPage.getTotalCartPrice() - checkoutStepTwoPage.getTaxValue()) * 100)/100.0);
    }
}