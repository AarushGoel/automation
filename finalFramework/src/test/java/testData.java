import org.testng.annotations.DataProvider;

public class testData {


    @DataProvider(name="Textdata")
    public Object[][] testingdata(){

        Object[][] obj =new Object[][]{

                {"hello"},{"aarush&*&^"}
        };
        return obj;
    }
}
