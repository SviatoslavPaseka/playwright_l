package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepOnePage {
    private final Page page;

    private final Locator firstNameField;
    private final Locator lastNameField;
    private final Locator postalCodeField;
    private final Locator cancelButton;
    private final Locator continueButton;
    private final Locator errorMessage;
    private final Locator closeErrorMessageButton;


    public CheckoutStepOnePage(Page page) {
        this.page = page;
        this.firstNameField = page.locator("//input[@id='first-name']");
        this.lastNameField = page.locator("//input[@id='last-name']");
        this.postalCodeField = page.locator("//input[@id='postal-code']");
        this.cancelButton = page.locator("//button[@id='cancel']");
        this.continueButton = page.locator("//input[@id='continue']");
        this.errorMessage = page.locator("//h3[@data-test='error']");
        this.closeErrorMessageButton = page.locator("//h3[@data-test='error']/button");
    }

    public void inputCheckoutInformation(String firstname, String lastname, String postalCode){
        firstNameField.fill(firstname);
        lastNameField.fill(lastname);
        postalCodeField.fill(postalCode);
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
    public String getTextFromErrorMessage(){
        return errorMessage.textContent();
    }

    public void clickOnCloseErrorMessage(){
        closeErrorMessageButton.click();
    }
}