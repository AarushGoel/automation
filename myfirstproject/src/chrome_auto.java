import com.sun.source.tree.AssertTree;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class chrome_auto {


    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://cricbuzz.com/");
    driver.getCurrentUrl();

        driver.findElementByXPath("//*[@id=\'top\']/div/div[3]/div[2]/a").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();

        JavascriptExecutor jse =(JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0,480)","");


    Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));










    }
}
