import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class loginPage {

    public loginPage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public List<MobileElement> Crenditials;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    public WebElement Password;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='LOGIN']")
    public WebElement LoginButton;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
    public WebElement PIN;



}
