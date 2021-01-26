import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class gesture {

    public static void main(String args[]) throws MalformedURLException {


        File f=new File("src");
        File fd=new File(f,"ApiDemos-debug.apk");

        DesiredCapabilities cap =new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Aarushemulator");
        cap.setCapability(MobileCapabilityType.APP,fd.getAbsolutePath());

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();


        TouchAction t= new TouchAction(driver);

        WebElement we=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");

        t.tap(tapOptions().withElement(element(we))).perform();

        WebElement wq=driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");

        t.tap(tapOptions().withElement(element(wq))).perform();

        System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize());

        wq=driver.findElementByAndroidUIAutomator("text(\"People Names\")");

        t.longPress(LongPressOptions.longPressOptions().withElement(element(wq)).withDuration(Duration.ofSeconds(2))).release().perform();

        System.out.println(driver.findElementById("android:id/title").isDisplayed());











    }
}
