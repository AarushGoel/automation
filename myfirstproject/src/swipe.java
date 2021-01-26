import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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

public class swipe {

    public static void main(String[] args) throws MalformedURLException {



        File fs=new File(new File("src"),"ApiDemos-debug.apk");

        DesiredCapabilities cap =new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Aarushemulator");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        TouchAction touch= new TouchAction(driver);

        WebElement we= driver.findElementByAndroidUIAutomator("text(\"Views\")");

        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(we))).perform();

        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();

        driver.findElementByXPath("//*[@content-desc='9']").click();



        WebElement first= driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second= driver.findElementByXPath("//*[@content-desc='45']");

        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(first)).withDuration(Duration.ofSeconds(1))).moveTo(ElementOption.element(second)).release().perform();

























    }



}
