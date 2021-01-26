

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class homeLoanTest {
    @BeforeClass
    public void beforeClassHomeloan() {

        System.out.println("Before Home loan class");

    }


    @AfterClass
    public void afterClassHomeloan() {

        System.out.println("After Home loan class");

    }



    @BeforeTest
    public void beforeTestHomeLoan() {

        System.out.println("Before Test Home Loan Execute");


    }



    @AfterTest
    public void AfterTestHomeLoan() {

        System.out.println("After Test Home Loan Execute");


    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Before Each Test/Method Home Loan Execute");


    }

    @AfterMethod
    public void afterMethod(){

        System.out.println("After Each Test/Method Home Loan Execute");


    }



    @Test(dataProvider = "getData",groups = {"Signin"})
    public void HomeLoanLogin(String username,String password) {
        System.out.println("Home Loan Login");

        System.out.println(username);
        System.out.println(password);


    }



    @Test(dependsOnMethods = "HomeLoanLogin")
    public void HomeLoanView() {
        System.out.println("Home Loan View");
    }



    @Test(dependsOnMethods = "HomeLoanView")
    public void HomeLoanSignout() {
        System.out.println("Home Loan Signout");
    }


    @DataProvider
    public Object[] getData() {

        Object data[][]= new Object[3][2];


        data[0][0]= "firstusername";
        data[0][1]="firstuserpassword";

        data[1][0]= "secondusername";
        data[1][1]="seconduserpassword";

        data[2][0]= "thirdusername";
        data[2][1]="thirduserpassword";


        return data;

    }

    @Parameters({"parametername"})
    @Test
    public void parameterHome(String par) {

        System.out.println("Home Loan Parameter passed is :"+ par);
    }


    @Test
    public void HomeFailedTest() {

        Assert.assertTrue(false);
    }


}
