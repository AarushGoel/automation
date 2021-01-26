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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    private static AppiumDriverLocalService server;
    private static AndroidDriver driver;

    public void startServer() throws IOException, InterruptedException {
    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        server =AppiumDriverLocalService.buildDefaultService();

        server.start();
        Thread.sleep(10);

    }

    public  void stopServer(){

        server.stop();

    }

    public void startemu() throws InterruptedException, IOException {

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/startemu.bat");
        Thread.sleep(10);
    }
    public static void  screenshort() throws IOException {
        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr,new File(System.getProperty("user.dir")+"\\01.png"));

    }
    public AndroidDriver capabilities() throws IOException {


        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/group.properties");

        Properties pro =new Properties();
        pro.load(fis);

        DesiredCapabilities cap =new DesiredCapabilities();

        File fs =new File(new File("src"),pro.getProperty("app"));

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,pro.getProperty("device"));
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");


        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return  driver;


    }
}
