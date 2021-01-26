
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


public class carLoanTest {


    @BeforeClass
    public void beforeClassCarloan() {

        System.out.println("Before Car loan class");

    }


    @AfterClass
    public void afterClassCarloan() {

        System.out.println("After Car loan class");

    }



    @BeforeTest
    public void beforeTestCarLoan() {

        System.out.println("Before Test Car Loan Execute");


    }



    @AfterTest
    public void AfterTestCarLoan() {

        System.out.println("After Test Car Loan Execute");


    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Before Each Test/Method Car Loan Execute");


    }

    @AfterMethod
    public void afterMethod(){

        System.out.println("After Each Test/Method Car Loan Execute");


    }


    @Test(dataProvider = "getData",groups = {"Signin"})
    public void carLoanLogin(String username,String password) {
        System.out.println("Car Loan Login");

        System.out.println(username);
        System.out.println(password);


    }



    @Test(dependsOnMethods = "carLoanLogin")
    public void carLoanView() {
        System.out.println("Car Loan View");
    }



    @Test(dependsOnMethods = "carLoanView")
    public void carLoanSignout() {
        System.out.println("Car Loan Signout");
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
    public void parameterCar(String par) {

        System.out.println("Car Loan Parameter passed is :"+ par);
    }



    @Test
    public void carFailedTest() {

        Assert.assertTrue(false);
    }
}





