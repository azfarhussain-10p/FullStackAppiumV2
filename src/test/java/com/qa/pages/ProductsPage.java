package com.qa.pages;

import com.qa.base.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends MenuPage {

    public ProductsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private WebElement productHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement SLBackpackTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]")
    private WebElement SLBackpackPrice;

    public String getTitle() {
        String productTitle = getText(productHeader);
        utilities.log().info("Product Page Title is: {}", productTitle);
        return productTitle;
    }

    public String getSLBackpackTitle() {
        String title = getText(SLBackpackTitle);
        utilities.log().info("Title is: {}", title);
        return title;
    }

    public String getSLBackpackPrice() {
        String price = getText(SLBackpackPrice);
        utilities.log().info("Product Price is: {}", price);
        return price;
    }

    public ProductDetailsPage clickSLBackpackTitle() {
        utilities.log().info("Clicking on SLB Title link");
        clickElement(SLBackpackTitle);
        return new ProductDetailsPage();
    }
}
