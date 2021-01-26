import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class startingPage {

    public startingPage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Login to Kite']")
    public WebElement Login;

    @AndroidFindBy(xpath = "//*[@content-desc='Open a new account']")
    public WebElement OpenAccount;

}
