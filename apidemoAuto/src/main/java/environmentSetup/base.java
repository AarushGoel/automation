package environmentSetup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

  public static AndroidDriver capabilities(String apkname) throws IOException {


      FileInputStream fis = new FileInputStream((String)System.getProperty("user.dir") + "\\src\\main\\java\\environmentSetup\\global.properties");


      Properties prop = new Properties();
      prop.load(fis);

      File appname =new File(new File("src"),prop.getProperty(apkname));


      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("devicename"));
      capabilities.setCapability(MobileCapabilityType.APP, appname.getAbsolutePath());
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

      AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      return driver;



  }
}
