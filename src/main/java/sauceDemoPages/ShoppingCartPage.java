package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import sauceDemoPages.enums.ItemLinks;


public class ShoppingCartPage {
    private final Page page;

    private final Locator continueShoppingButton;
    private final Locator checkoutButton;
    private final String productName;
    private final String productDescr;
    private final String productPrice;
    private final String removeButton;
    private final String productQuantity;

    public ShoppingCartPage(Page page) {
        this.page = page;
        this.continueShoppingButton = page.locator("id:continue-shopping");
        this.checkoutButton = page.locator("//button[@id='checkout']");
        this.productName = "//a[@id='%s']";
        this.productDescr = productName + "/following-sibling::div[@class='inventory_item_desc']";
        this.productPrice = productName + "/following-sibling::div/div";
        this.removeButton = productName + "/following-sibling::div/button";
        this.productQuantity = productName + "/ancestor::div[1]/preceding-sibling::div";
    }

    public String getProductNameText(ItemLinks itemLinks){
        return page.locator(String.format(productName, itemLinks.getaId())).textContent();
    }

    public Double getProductPrice(ItemLinks itemLinks){
        return Double.parseDouble(page.locator(String.format(productPrice, itemLinks.getaId()))
                                                .textContent().replaceAll("[$]", ""));
    }

    public void clickOnRemoveButtonByProductName(ItemLinks itemLinks){
        page.locator(String.format(removeButton, itemLinks.getaId())).click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

}
