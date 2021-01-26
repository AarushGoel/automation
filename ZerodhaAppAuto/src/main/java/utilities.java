import io.appium.java_client.android.AndroidDriver;

public class utilities {


public static void scroll(AndroidDriver driver,String name){
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"))");

    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceid(\"android.widget.ScrollView\")).scrollIntoView(content-desc(\""+"SFL NSE"+"\")");
}
}
