import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    private static AppiumDriverLocalService server;

    private static AndroidDriver driver;
    public static void startServer() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        server =AppiumDriverLocalService.buildDefaultService();
        server.start();
        Thread.sleep(10000);

    }

    public static void stopServer(){

        server.stop();
    }


    public static void getScreenShot(String name) throws IOException {

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);



        SimpleDateFormat formatter = new SimpleDateFormat("ddMyyyyhhmmss");

        name=name+formatter.format(new Date());

        FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\Repotrs\\screnshoot"+name+".png"));

    }


    public static AndroidDriver  capabilities() throws IOException {

        FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\group.properties");

        Properties pro = new Properties();

        pro.load(file);



        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,pro.getProperty("device"));

        cap.setCapability("appPackage",pro.getProperty("appPakage"));
        cap.setCapability("appActivity",pro.getProperty("appActivity"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }



}
