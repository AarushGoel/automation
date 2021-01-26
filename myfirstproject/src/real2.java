import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class real2 {




    public static void main(String args[]) throws MalformedURLException {




        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability("appPackage","com.amazon.mp3");
        cap.setCapability("appActivity","com.amazon.mp3.activity.MusicHomeActivity");

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // xpath = //tagname[@attriute='value']









    }




}
