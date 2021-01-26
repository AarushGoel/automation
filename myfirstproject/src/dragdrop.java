import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.reflect.TypeUtilsTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import static io.appium.java_client.touch.offset.ElementOption.element;

public class dragdrop {
    public static void main(String[] args) throws MalformedURLException {

        File fs=new File(new File("src"),"ApiDemos-debug.apk");


        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();


        TouchAction touch =new TouchAction(driver);
        //WebElement source = (WebElement) driver.findElementsByClassName("android.widget.RelativeLayout").get(1);
        //WebElement destination = (WebElement) driver.findElementsByClassName("android.widget.RelativeLayout").get(2);
        WebElement source = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement destination = driver.findElementById("io.appium.android.apis:id/drag_dot_3");

        touch.longPress(element(source)).moveTo(element(destination)).release().perform();

        driver.navigate().back();







    }
}
