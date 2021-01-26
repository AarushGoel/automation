import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ecommerce_final {
    private static final double DELTA = 1e-15;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        File fs= new File(new File("src"),"General-Store.apk");
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,5);

        AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();


        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Riya");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();


        ((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0)).click();
        ((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1)).click();

        /*driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Converse All Star\"))");

        ((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0)).click();
        ((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1)).click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"PG 3\"))");

        ((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0)).click();
*/
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


        String amt1=((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0)).getText();


        String amt2=((AndroidElement)driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1)).getText();

        amt1=amt1.substring(1);

        amt2=amt2.substring(1);

        double a1 = getAmount(amt1);
        double a2 = getAmount(amt2);

        double sum=a1+a2;

        String actualT =driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();

        actualT=actualT.substring(1);
        double actualTotal=getAmount(actualT);

        System.out.println(sum);
        System.out.println(actualTotal);


        Assert.assertEquals(sum,actualTotal,DELTA);




        TouchAction action =new TouchAction(driver);

    driver.findElementByXPath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']").click();

    WebElement we= driver.findElementById("com.androidsample.generalstore:id/termsButton");

    action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we)).withDuration(Duration.ofSeconds(2))).release().perform();
    driver.findElementById("android:id/button1").click();

    driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

    Thread.sleep(2000);
    Set<String> cont= driver.getContextHandles();

    for(String contextname:cont){

        System.out.println(contextname);
        }
    driver.context("WEBVIEW_com.androidsample.generalstore");

        Thread.sleep(3000);
        //driver.findElementByCssSelector("input[id='input']").sendKeys("https://cricbuzz.com/");

        //driver.findElementByCssSelector("input[id='input']").sendKeys(Keys.ENTER);

        driver.get("https://cricbuzz.com/");
        System.out.println(driver.getCurrentUrl());

        driver.findElementByXPath("//*[@id=\'top\']/div/div[3]/div[2]/a").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();

        JavascriptExecutor jse =(JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0,480)","");


        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));


    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.context("NATIVE_APP");




















    }


    public  static double getAmount(String s) {
        return  Double.parseDouble(s);

    }
    }



