package com.qa.tests;

import com.qa.base.AppFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;

public class LoginTestV2 extends AppFactory {
    LoginPage loginPage;
    ProductPage productPage;
    InputStream inputStream;
    JSONObject loginUser;

    @BeforeClass
    public void setupDataStream() throws IOException {
        try {
            String dataFileName = "data/loginUsers.json";
            inputStream = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener jsonTokener = new JSONTokener(Objects.requireNonNull(inputStream));
            loginUser = new JSONObject(jsonTokener);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @BeforeMethod
    public void setup(Method method) {
        loginPage = new LoginPage();
        System.out.println("\n" + "********** Starting Test: " + method.getName() + " **********" + "\n");
    }

    @Test(dataProvider = "userCredentials")
    @Description("This test aims to validate various login scenarios, encompassing both negative and positive cases," +
            " such as a valid username with an invalid password, an invalid username with a valid password, and a " +
            "valid username with a valid password.")
    public void verifyLogin(String userName, String password) {
        // Enter the username and password
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);

        // Click the login button
        productPage = loginPage.clickLoginButton();
        // Validate based on the username and password combination
        if (userName.equals(loginUser.getJSONObject("invalidUser").getString("userName")) &&
                password.equals(loginUser.getJSONObject("invalidUser").getString("password")) ||
                userName.equals(loginUser.getJSONObject("invalidPassword").getString("userName")) &&
                        password.equals(loginUser.getJSONObject("invalidPassword").getString("password"))) {
            // Perform validation for invalid userName and valid password and valid userName and invalid password
            String actualErrorMessage = loginPage.getErrorMessage();
            String expectedErrorMessage = stringHashMap.get("error_invalid_userName_and_password");
            System.out.println("Actual Error Message is - " + actualErrorMessage + "\n" + "Expected Error Message is - " + expectedErrorMessage);
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        } else {
            // Perform validation for valid userName and valid password
            String actualProductTitle = productPage.getTitle();
            String expectedProductTitle = stringHashMap.get("product_title");
            System.out.println("Actual Product page title is - " + actualProductTitle + "\n" + "Expected Product page title is - " + expectedProductTitle);
            Assert.assertEquals(actualProductTitle, expectedProductTitle);
        }
    }

    @DataProvider(name = "userCredentials")
    public Object[][] getUserCredentials() {
        Object[][] data = new Object[3][2];

        // Data for verifyInvalidUserName test
        data[0][0] = loginUser.getJSONObject("invalidUser").getString("userName");
        data[0][1] = loginUser.getJSONObject("invalidUser").getString("password");

        // Data for verifyInvalidPassword test
        data[1][0] = loginUser.getJSONObject("invalidPassword").getString("userName");
        data[1][1] = loginUser.getJSONObject("invalidPassword").getString("password");

        // Data for verifyValidLogin test
        data[2][0] = loginUser.getJSONObject("validUserAndPassword").getString("userName");
        data[2][1] = loginUser.getJSONObject("validUserAndPassword").getString("password");

        return data;
    }
}
