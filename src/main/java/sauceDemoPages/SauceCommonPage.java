package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SauceCommonPage {
    private final Page page;

    private final Locator shoppingCartLink;

    private final Locator shoppingCartBadge;

    private final Locator burgerButton;

    public SauceCommonPage(Page page) {
        this.page = page;
        this.shoppingCartLink = page.locator("css=a.shopping_cart_link");
        this.shoppingCartBadge = page.locator("css=span.shopping_cart_badge");
        this.burgerButton = page.locator("id=react-burger-menu-btn");
    }
    public void clickOnBurgerButton(){
        burgerButton.click();
    }

    public void openShoppingCart(){
        shoppingCartLink.click();
    }
}