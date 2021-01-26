package pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Products {

    public Products(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    @AndroidFindBy(id= "com.androidsample.generalstore:id/productAddCart")
    public List<WebElement> AddCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement Cart;



}
