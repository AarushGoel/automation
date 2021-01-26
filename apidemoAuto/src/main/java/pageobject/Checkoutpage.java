package pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkoutpage {


    public  Checkoutpage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    public List<WebElement> Price;


    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement TotalPrice;


    @AndroidFindBy(xpath="//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    public WebElement EmailCheckBox;


    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    public WebElement Terms;

    @AndroidFindBy(id="android:id/button1")
    public WebElement TermsClose;


    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public WebElement VisitWebsite;


}
