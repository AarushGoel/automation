package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class perferncePage {

    public perferncePage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7. Fragment']")
    public WebElement Fragment;
}
