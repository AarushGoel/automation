import io.appium.java_client.android.AndroidDriver;

public class utilities {

    AndroidDriver driver;
    public  utilities(AndroidDriver driver){
        this.driver= driver;


    }
    public void scrollTo(String text){

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");


    }
}
