package pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public WebElement Country;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/nameField")
    public WebElement Name;


    @AndroidFindBy(id= "com.androidsample.generalstore:id/radioMale")
    public WebElement Male;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/radioFemale")
    public WebElement Female;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement Shop;


}
