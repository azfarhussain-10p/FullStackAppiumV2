package sessionTwo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializerDriver("Android");
        WebElement webElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(webElement.getText());

        webElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(webElement.getText());

        webElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(webElement.getText());

        webElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println(webElement.getText());
    }
}
