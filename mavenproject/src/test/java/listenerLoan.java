import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerLoan implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test is success!!!! Great....");

    }

    @Override
    public void onTestFailure(ITestResult result) {


        System.out.println("Test is Failll!!!! Oppsss....");

    }
}
