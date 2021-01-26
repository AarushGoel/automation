import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc3_1 {


    public static void main(String[] args) throws MalformedURLException {


    File fs= new File(new File("src"),"General-Store.apk");


    DesiredCapabilities cap= new DesiredCapabilities();


    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
    cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,5);


    AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
    driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Priya");
    driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Air Jordan 9 Retro\"))");



    int products=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
    int temp=driver.findElementsById("com.androidsample.generalstore:id/productAddCart").size();

    System.out.println(products);
    System.out.println(temp);
    for(int i=0;i<products;i++){

        String productname=((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productName").get(i)).getText();

        if(productname.equals("Air Jordan 9 Retro") && products >= temp) {
            ((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i)).click();


            System.out.println(((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i)).getText());
            //float price=Float.valueOf(((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i)).getText().replace("$","")).floatValue();
            //System.out.println(price);
            break;


        }else if(productname.equals("Air Jordan 9 Retro") && products < temp) {
            ((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i+1)).click();
            //float price=Float.valueOf(((AndroidElement) driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i)).getText()).floatValue();
            //System.out.println(price);

            break;

        }
        }

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


    TouchAction touch =new TouchAction(driver);

    WebElement we =driver.findElementByXPath("//android.widget.TextView[@text='Please read our terms of conditions']");

    touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we)).withDuration(Duration.ofSeconds(2))).release().perform();



    driver.findElementById("android:id/button1").click();

    we=driver.findElementByXPath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");

    touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(we))).perform();

    }












    }



