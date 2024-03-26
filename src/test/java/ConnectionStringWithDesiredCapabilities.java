import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @information: The <b>newCommandTimeout</b> is a capability that specifies the maximum amount of time (in seconds)
 * that Appium server should wait for a new command from the client before considering the session idle and potentially
 * terminating it. This capability is important for several reasons. The default value of the newCommandTimeout is 60second
 * @information: The <b>avd</b> and <b>avdLaunchTimeout</b> commands are utilized to automatically initiate the Device/Emulator.
 * These commands prove beneficial when your tests are executing within a CI/CD pipeline.
 * The default timeout of avdLaunchTimeout in Appium 2 is 20,000 milliseconds (20 seconds).
 * @information: The <b>cmdString</b> is used to Kill the Emulator after the Test Run
 */

public class ConnectionStringWithDesiredCapabilities {
    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("newCommandTimeout", 120);
//        capabilities.setCapability("avd", "Pixel_5");
//        capabilities.setCapability("avdLaunchTimeout", 200000);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
        capabilities.setCapability("noReset", false);
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        System.out.println("Session ID:" + driver.getSessionId());
        System.out.println("Opening Appium Server");
    }

    @Test
    public void sampleTest() {
        System.out.print("This is a 1st Sample Test");
    }

   // @AfterTest
    public void teaDown() {
        if (null != driver) {
            driver.quit();
        }
    }

/*
    @AfterTest
    public void teaDown() {
        String cmdString = "adb -s emulator-5554 emu kill";
        if (null != driver) {
            try {
                Runtime.getRuntime().exec("CMD /C " + cmdString);
                driver.quit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
}
