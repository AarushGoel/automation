import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class base2 {


    public  static AndroidDriver capibilities() throws MalformedURLException {


        File fs= new File("src");
        File fd =new File(fs,"ApiDemos-debug.apk");




        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Aarushemulator");
        cap.setCapability(MobileCapabilityType.APP,fd.getAbsolutePath());


        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

    return driver;



    }


}
