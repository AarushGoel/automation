import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class loginTest {


    @Test
    public void login() throws IOException, InterruptedException {

        AndroidDriver driver = base.capabilites();

        startingPage sp = new startingPage(driver);


        sp.Login.click();



        System.out.println(driver.getContext());

        //System.out.println(driver.findElementByXPath("//android.widget.EditText[@text='User ID']").toString());


        loginPage lp = new loginPage(driver);


        Actions action =new Actions(driver);



   System.out.println(driver.findElementByXPath("//android.widget.EditText[@text='User ID']").isEnabled());
   driver.findElementByXPath("//android.widget.EditText[@text='User ID']").sendKeys("XD4345");


        /*
        //action.sendKeys("").perform();

        //action.sendKeys(Keys.ENTER).perform();


        action.sendKeys("").perform();

        //lp.Crenditials.get(0).sendKeys("");
        //lp.Password.sendKeys("");
        lp.LoginButton.click();

        action.sendKeys("").perform();


        //driver.findElementByXPath("//android.view.View[@content-desc='Portfolio, tab']").click();
        stocklist sl = new stocklist(driver);

        sl.Watchlist4.click();
        Thread.sleep(2000);
        sl.Protfolio.click();
*/

    }
}
