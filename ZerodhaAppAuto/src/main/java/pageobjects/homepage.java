package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class homepage {


    public homepage(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Login to Kite']")
    private WebElement LoginKite;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='User ID']")
    private WebElement UserID;



    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement Password;




    public WebElement getLoginKite(){

        return LoginKite;
    }



    public WebElement getUserID(){

        return UserID;
    }


    public WebElement getPassword(){

        return Password;
    }


}
