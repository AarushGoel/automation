import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class slideTest {


    @Test(dataProvider = "normal")
    public void firsttest(String a,String c) throws IOException, InterruptedException {

        System.out.println(a+c);
        base b = new base();

        b.startemu();
        b.startServer();
        AndroidDriver driver=b.capabilities();

        page1 p =new page1(driver);

        TouchAction action = new TouchAction(driver);

        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(p.getAnimation()))).perform();

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(p.getSeeking())).withDuration(Duration.ofSeconds(5))).release().perform();

        AndroidElement element =p.getSeeker();
        element.setValue("200");


    }

    @DataProvider(name = "normal")
    public Object[][] getData(){

        Object[][] objs =new Object[1][2];

        objs[0][0]="Aarush is best";
        objs[0][1]="Goel is best";

        return objs;


    }




}
