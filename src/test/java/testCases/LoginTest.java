package testCases;

import base.AppFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends AppFactory {

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserCreation() throws InterruptedException {
        System.out.println("This test is used to login with Valid User and Password");
        loginPage.enterValidUserName("standard_user");
        loginPage.enterValidPassword("secret_sauce");
        loginPage.clickLoginButton();
        System.out.println("Login Successfully...");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        AppFactory.quitDriver();
    }
}
