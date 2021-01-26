package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class fragmentPage {

public  fragmentPage(AndroidDriver driver){

    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}

    @AndroidFindBy(id="android:id/checkbox")
    private List<WebElement> CheckBox;

    @AndroidFindBy(className ="android.widget.RelativeLayout")
    private List<WebElement> Layout;


    @AndroidFindBy(id="android:id/edit")
    private   WebElement TextBox;


    @AndroidFindBy(id="android:id/button1")
    private   WebElement OK;


    public List<WebElement> getCheckBox() {
        return CheckBox;
    }

    public List<WebElement> getLayout() {
        return Layout;
    }

    public WebElement getTextBox() {
        return TextBox;
    }

    public WebElement getOK() {
        return OK;
    }


}
