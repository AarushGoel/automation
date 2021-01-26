import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class apiDemoTest {

    @BeforeSuite
    public void beforeSuit() throws IOException, InterruptedException {

        base.startEmulator();


    }
    @BeforeTest
    public void beforeTesting() throws IOException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        }catch (Exception e){
            System.out.println(e);

        }

        base.startServer();

        }

    @Test
    public void apiDemo() throws IOException {

        AndroidDriver driver = base.capablities("apidemoapp");

        utilities utilities = new utilities(driver);


        apiHomePage apiHomePage=new apiHomePage(driver);
        apiHomePage.getGraphics().click();


        utilities.scrollTo("Poi");

    }

    @AfterTest
    public void afterTesting(){

        base.stopServer();
    }
}

