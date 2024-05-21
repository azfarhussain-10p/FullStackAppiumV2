package com.qa.pages;

import com.qa.base.AppDriver;
import com.qa.base.AppFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AppFactory {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userNameTextbox;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement passwordTextbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    private WebElement errorTextMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    private WebElement loginButton;

    public LoginPage enterUserName(String userName) {
        System.out.println("Login with: " + userName);
        sendKeys(userNameTextbox, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        System.out.println("Password is: " + password);
        sendKeys(passwordTextbox, password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        System.out.println("Clicking on Login Button");
        clickElement(loginButton);
        return new ProductsPage();
    }

    public ProductsPage login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        String errorMessage = getText(errorTextMessage);
        System.out.println("Error Text is: " + errorMessage);
        return errorMessage;
    }
}
