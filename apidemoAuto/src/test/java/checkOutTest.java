import environmentSetup.base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageobject.Checkoutpage;
import pageobject.HomePage;
import pageobject.Products;

import java.io.IOException;
import java.time.Duration;


public class checkOutTest {

    @Test
    public void prerequirements() throws IOException, InterruptedException {

        AndroidDriver driver = base.capabilities("generalstore");


        HomePage homePage = new HomePage(driver);
        homePage.Country.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();

        homePage.Name.sendKeys("Riya");

        driver.hideKeyboard();

        homePage.Female.click();

        homePage.Shop.click();


        Products products = new Products(driver);

        products.AddCart.get(0).click();
        products.AddCart.get(1).click();

        products.Cart.click();


        Checkoutpage checkoutpage = new Checkoutpage(driver);

        String prod1price = checkoutpage.Price.get(0).getText();
        String prod2price = checkoutpage.Price.get(1).getText();
        String totalpricepro = checkoutpage.TotalPrice.getText();

        double pr1 = getAmount(prod1price);
        double pr2 = getAmount(prod2price);
        double total = getAmount(totalpricepro);

        System.out.println("First Product Price : " + pr1);
        System.out.println("Second Product Price : " + pr2);
        System.out.println("Total Product Price : " + total);

        Assert.assertEquals(pr1 + pr2, total);

        checkoutpage.EmailCheckBox.click();

        TouchAction action = new TouchAction(driver);

        WebElement we = checkoutpage.Terms;


        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(we)).withDuration(Duration.ofSeconds(2))).release().perform();

        checkoutpage.TermsClose.click();
        checkoutpage.VisitWebsite.click();

        Thread.sleep(2000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.get("https://cricbuzz.com/");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));


    }


    public double getAmount(String price) {
        price = price.substring(1);

        return Double.parseDouble(price);
    }

}
