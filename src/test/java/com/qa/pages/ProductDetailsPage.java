package com.qa.pages;

import com.qa.base.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends MenuPage {

    public ProductDetailsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private WebElement SLBackpackTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    private WebElement SLBackpackDescription;

    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    private WebElement backToProductButton;

    @AndroidFindBy(accessibility = "test-Price")
    private WebElement SLBProductPrice;

    public String getSLBackpackTitle() {
        String SLBTitle = getText(SLBackpackTitle);
        System.out.println("Title is: " + SLBTitle);
        return SLBTitle;
    }

    public String getSLBackpackDescription() {
        String SLBDescription = getText(SLBackpackDescription);
        System.out.println("Product Description is: " + SLBDescription);
        return SLBDescription;
    }

    public String getSLBPrice() {
        String SLBPrice = getText(SLBProductPrice);
        System.out.println("Product Price is: " + SLBPrice);
        return SLBPrice;
    }

    public ProductsPage clickBackToProduct() {
        System.out.println("Navigate to Product Page");
        clickElement(backToProductButton);
        return new ProductsPage();
    }
}
