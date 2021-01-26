import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class stocklist {

    public  stocklist(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Watchlist 4\n" +
            "Tab 4 of 5']")
    public WebElement Watchlist4;


    //driver.findElementByXPath("//android.view.View[@content-desc='Portfolio, tab']").click();
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Portfolio, tab']")
    public WebElement Protfolio;
}
