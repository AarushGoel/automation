import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class scrolling {

    public static void main(String[] args) throws MalformedURLException {

        File fs=new File(new File("src"),"ApiDemos-debug.apk");


        DesiredCapabilities cap= new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Aarushemulator");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        TouchAction touch=new TouchAction(driver);


        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"))");
        //driver.findElementByAndroidUIAutomator("new Uiscrollable(new UiSelector()).scrollIntoView(text(\"\"))");














    }
}
