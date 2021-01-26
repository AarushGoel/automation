import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class base {




    public static AndroidDriver capabilites() throws IOException, InterruptedException {




        FileInputStream fis= new FileInputStream((String)System.getProperty("user.dir")+"\\src\\main\\java\\group.properties");


        Properties pro=new Properties();

        pro.load(fis);

        DesiredCapabilities cap= new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,pro.get("deviceName"));
        cap.setCapability("appPackage",pro.get("appPakage"));
        cap.setCapability("appActivity",pro.get("appActivity"));

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

//for login purpose
        //cap.setCapability("unicodeKeyboard", false);
        //cap.setCapability("resetKeyboard", false);

        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        return driver;






    }


}
