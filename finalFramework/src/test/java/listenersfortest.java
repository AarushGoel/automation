import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.base;

import java.io.IOException;

public class listenersfortest implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            base.screenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }
}
