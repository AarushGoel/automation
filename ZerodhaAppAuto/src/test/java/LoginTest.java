import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pageobjects.homepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {

public static  AndroidDriver driver;

    @BeforeSuite
    public void Logintest() throws IOException, InterruptedException {
        base.startServer();
        driver=base.capabilities();

        homepage hp = new homepage(driver);

        hp.getLoginKite().click();

        TouchAction action = new TouchAction(driver);


        Actions actions =new Actions(driver);

        FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\group.properties");

        Properties pro = new Properties();

        pro.load(file);

        actions.sendKeys(pro.getProperty("username")).perform();
        actions.sendKeys(Keys.ENTER).perform();

        actions.sendKeys(pro.getProperty("password")).perform();
        actions.sendKeys(Keys.ENTER).perform();


        actions.sendKeys(pro.getProperty("pin")).perform();

    Thread.sleep(2000);


    }



}
