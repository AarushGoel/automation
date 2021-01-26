import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ecommerce_t1_1 {


    public static void main(String[] args) throws MalformedURLException {


        File fs=new File(new File("src"),"General-Store.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,5);


        AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aarush");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"))").click();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        WebElement we= driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

        TouchAction touch=new TouchAction(driver);


        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(we))).perform();










    }
}
