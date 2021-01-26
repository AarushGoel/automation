
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class personalLoanTest{

    @BeforeClass
    public void beforeClassPersonalloan() {

        System.out.println("Before Personal loan class");

    }


    @AfterClass
    public void afterClassPersonalloan() {

        System.out.println("After Personal loan class");

    }



    @BeforeTest
    public void beforeTestPersonalLoan() {

        System.out.println("Before Test Personal Loan Execute");


    }



    @AfterTest
    public void AfterTestPersonalLoan() {

        System.out.println("After Test Personal Loan Execute");


    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Before Each Test/Method Personal Loan Execute");


    }

    @AfterMethod
    public void afterMethod(){

        System.out.println("After Each Test/Method Personal Loan Execute");


    }



    @Test(dataProvider = "getData",groups = {"Signin"})
    public void PersonalLoanLogin(String username,String password) {
        System.out.println("Personal Loan Login");

        System.out.println(username);
        System.out.println(password);


    }


    @Test(dependsOnMethods = "PersonalLoanLogin")
    public void PersonalLoanView() {
        System.out.println("Personal Loan View");
    }



    @Test(dependsOnMethods = "PersonalLoanView")
    public void PersonalLoanSignout() {
        System.out.println("Personal Loan Signout");
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
    public void parameterPersonal(String par) {

        System.out.println("Personal Loan Parameter passed is :"+ par);
    }


    @Test
    public void personalFailedTest() {

        Assert.assertTrue(false);
    }


    @BeforeSuite
    public void beforeSuiteLoan() {

        System.out.println("Before Suite Loan");




    }




    @AfterSuite
    public void afterSuiteLoan() {

        System.out.println("After Suite Loan");




    }

}
