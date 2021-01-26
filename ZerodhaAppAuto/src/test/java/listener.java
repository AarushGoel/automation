import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {



    }

    @Override
    public void onTestSuccess(ITestResult result) {

        try {
            base.getScreenShot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }
}
