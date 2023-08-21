package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator userNameField;
    private final Locator passwordField;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameField = page.locator("//input[@id='user-name']");
        this.passwordField = page.locator("//input[@id='password']");
        this.loginButton =  page.locator("//input[@id='login-button']");
    }

    public LoginPage navigate(){
        page.navigate("https://www.saucedemo.com/");
        return this;
    }

    public void login(String username, String password){
        userNameField.fill(username);
        passwordField.fill(password);
        loginButton.click();
    }
}