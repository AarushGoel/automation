import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;


public class base {

    public  static AppiumDriverLocalService  service;
    public static AndroidDriver driver;


    public static void startServer() throws IOException {

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();




    }

    public static void stopServer(){

        service.stop();

    }


    private boolean isServerBusy(int port){

        boolean isRunning = false;

        ServerSocket socket;
        try {
            socket= new ServerSocket(port);
            socket.close();


        }catch (IOException e){

            isRunning=true;
        }finally {
            socket =null;
        }

        return isRunning;
    }


    public static AndroidDriver capablities(String appname) throws IOException {


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/group.properties");

        Properties pro = new Properties();
        pro.load(fis);


        File apk = new File(new File("src"), pro.getProperty(appname));


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, pro.getProperty("device"));
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        return  driver;
    }

    public static void getScreenShot() throws IOException {

    File fo=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(fo,new File(System.getProperty("user.dir")+"\\scr1.png"));
    System.out.println("Screenshot captured");
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\myemulator.bat");
        Thread.sleep(20000);
    }

}
