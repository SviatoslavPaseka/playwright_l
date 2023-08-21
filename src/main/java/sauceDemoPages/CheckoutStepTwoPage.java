package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepTwoPage {
    private final Page page;


    private final Locator cancelButton;
    private final Locator finishButton;
    private final Locator itemTotalPrice;

    private final Locator taxPrice;

    private final Locator totalPrice;

    public CheckoutStepTwoPage(Page page) {
        this.page = page;
        this.cancelButton = page.locator("id=cancel");
        this.finishButton = page.locator("id=finish");
        this.itemTotalPrice = page.locator("css=div.summary_subtotal_label");
        this.taxPrice = page.locator("css=div.summary_tax_label");
        this.totalPrice = page.locator("css=div.summary_total_label");
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public Double getItemTotalPrice(){
        return makeDoubleFromString(itemTotalPrice.textContent());
    }

    public Double getTaxValue(){
        return makeDoubleFromString(taxPrice.textContent());
    }
    public Double getTotalCartPrice(){
        return makeDoubleFromString(totalPrice.textContent());
    }

    private Double makeDoubleFromString(String str){
        return Math.round(Double.parseDouble(str.replaceAll("[^\\d.]", "")) * 100) / 100.0;
    }

}