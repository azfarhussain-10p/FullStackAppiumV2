package sessionThree;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import sessionTwo.CreateDriverSession;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializerDriver("Android");
        longClickGestureByID(driver);
    }

    public static void longClickGestureByID(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    /**
     * The reliability of coordinates varies between devices; what works on one may not on another. If you opt to use coordinates, it's advisable to avoid hardcoding
     * them and opt for relative coordinates instead. This involves obtaining the screen's width and height using Selenium's dimension method and then calculating
     * X and Y coordinates relative to these dimensions. For instance, if the screen width is 100 and you want to click at X = 50, you divide the width by two.
     * This approach ensures clicking at the middle, regardless of the device's resolution, as long as the application adjusts element location accordingly.
     * Hence, it's recommended to use relative percentages instead of hardcoded coordinates.
     */
    public static void longClickGestureByCoordinates(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000
        ));
    }

    public static void dragAndDropGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
        ));
    }

    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(9000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 301,
                "top", 801,
                "width", 600,
                "height", 299,
                "percent", 0.75
        ));
    }

    public static void swipeGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100,
                "top", 200,
                "width", 600,
                "height", 600,
                "direction", "up",
                "percent", 0.75
        ));
    }
}
