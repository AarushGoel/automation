import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class realdevice {




    public static void main(String args[]) throws MalformedURLException {

        File fs= new File("src");
        File fd =new File(fs,"ApiDemos-debug.apk");




        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.APP,fd.getAbsolutePath());


        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // xpath = //tagname[@attriute='value']

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Aarush");
        //driver.findElementByClassName("android.widget.Button")get(1).click();

        driver.findElementById("android:id/button1").click();








    }




}
