package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class changelist {



    public changelist(AndroidDriver driver){


        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(className = "android.view.View")
    private List<WebElement> Save;

    public WebElement getSave(){

        return Save.get(2);
    }


    @AndroidFindBy(className = "android.view.View")
    private List<WebElement> StockList;

    public WebElement getStock1(){

        return StockList.get(13);
    }
}
