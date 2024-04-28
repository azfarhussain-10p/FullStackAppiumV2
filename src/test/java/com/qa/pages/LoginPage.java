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
    public WebElement userNameTextbox;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passwordTextbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    public WebElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    public WebElement loginButton;

    public void enterValidUserName(String userName) {
        sendKeys(userNameTextbox, userName);
    }

    public void enterValidPassword(String password) {
        sendKeys(passwordTextbox, password);
    }

    public ProductPage clickLoginButton() {
        clickElement(loginButton);
        return new ProductPage();
    }

    public String getErrorMessage() {
        return getAttribute(errorMessage, "text");
    }
}
