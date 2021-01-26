import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class practics {


    public static void main(String args[]) throws MalformedURLException {

        File fs=new File(new File("src"),"General-Store.apk");

        DesiredCapabilities cap =new DesiredCapabilities();



        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElementById("").click();
        driver.findElementByXPath("//tagname[@attribute='value']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"\")).scrollIntoView(text(\"\"))");
        ((AndroidElement)driver.findElementsByClassName("").get(1)).click();


        TouchAction action= new TouchAction(driver);
        WebElement we =driver.findElementById("");

        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(we))).perform();

        action.longPress(LongPressOptions.longPressOptions()).release().perform();

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.get("");

        driver.getContextHandles();
        driver.context("");
    driver.navigate().back();


















    }


}
