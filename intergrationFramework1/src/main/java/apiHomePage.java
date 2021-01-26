import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class apiHomePage {

     apiHomePage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Graphics']")
    private WebElement Graphics;

    public WebElement getGraphics(){
        System.out.println("Graphic Element Is Return");
        return Graphics;
    }
}
