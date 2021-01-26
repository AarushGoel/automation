import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.watchlist;

import java.io.IOException;
import java.time.Duration;

public class watchlistTest {

    @Test
    public void test() throws IOException, InterruptedException {

        AndroidDriver driver = LoginTest.driver;

        watchlist wl =new watchlist(driver);

        WebElement we1= wl.getStock1();

        TouchAction action = new TouchAction(driver);


        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we1)).withDuration(Duration.ofSeconds(2))).release().perform();

       //utilities.scroll(driver,"SFL");

      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\"android.view.View\").instance(13))");

        action.longPress(PointOption.point(100,1750)).moveTo(PointOption.point(100,580)).release().perform();


    }


}
