import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class basics extends base2{



    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver driver=capibilities();

        // xpath = //tagname[@attriute='value']

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Aarush");
        //driver.findElementByClassName("android.widget.Button")get(1).click();

        driver.findElementById("android:id/button1").click();








    }

}
