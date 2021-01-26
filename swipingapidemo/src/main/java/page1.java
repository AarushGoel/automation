import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class page1 {

page1(AndroidDriver driver){

    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Animation']")
    private WebElement Animation;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Seeking']")
    private WebElement Seeking;


    @AndroidFindBy(id = "io.appium.android.apis:id/seekBar")
    private AndroidElement Seeker;

    public WebElement getAnimation(){

        return Animation;
    }
    public WebElement getSeeking(){

        return Seeking;
    }
    public AndroidElement getSeeker(){

        return Seeker;
    }
}
