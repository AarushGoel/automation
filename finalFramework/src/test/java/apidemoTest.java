import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.fragmentPage;
import pageobjects.homePage;
import pageobjects.perferncePage;
import utilities.base;

import java.io.IOException;

public class apidemoTest {


    @BeforeTest
    public void beforeTest() throws IOException {

        base.startServer();
    }


    @AfterTest
    public void afterTest() throws IOException, InterruptedException {

        base.stopServer();
        base.stopEmulator();
    }




    @Test(dataProvider = "Textdata",dataProviderClass = testData.class)
    public void apiDemoTest(String data) throws IOException, InterruptedException {


        AndroidDriver driver = base.capabilities();

        homePage hp= new homePage(driver);

        hp.Preference.click();

        perferncePage pp= new perferncePage(driver);
        Thread.sleep(5000);
        pp.Fragment.click();

        fragmentPage fp =new fragmentPage(driver);

        fp.getCheckBox().get(0).click();
        fp.getLayout().get(1).click();
        fp.getTextBox().sendKeys(data);
        fp.getOK().click();






    }
}
