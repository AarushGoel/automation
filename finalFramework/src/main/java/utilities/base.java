package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {


    private static AndroidDriver driver;

    private static AppiumDriverLocalService service;



    public static void startServer() throws IOException {

        Runtime.getRuntime().exec("taskkill /F /IM node.exe");

        service =AppiumDriverLocalService.buildDefaultService();

        service.start();

    }
    public static void stopServer(){

        service.stop();
    }

    private static void startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\startEmulator.bat");

        Thread.sleep(20000);



    }

    public static void stopEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");



    }


    public static AndroidDriver capabilities() throws IOException, InterruptedException {


        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/utilities/group.properties");

        Properties pro =new Properties();
        pro.load(fis);


        String devicename=System.getProperty("devicename");
        String appname=System.getProperty("appname");


        if(devicename.contains("virtualdevice")){

            startEmulator();

        }


        File apk=new File(new File("src"),pro.getProperty(appname));



        DesiredCapabilities capabilities =new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,pro.getProperty(devicename));
        capabilities.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void screenshot(String name) throws IOException {

         File fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);



        SimpleDateFormat formatter = new SimpleDateFormat("ddMyyyyhhmmss");

        name=name+formatter.format(new Date());



        FileUtils.copyFile(fs,new File(System.getProperty("user.dir")+"/Reports/"+name+".png"));

    }

}
