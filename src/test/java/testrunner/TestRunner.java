package testrunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import hooks.hook;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefination", "hooks"},
    		tags = "@ParallelSafe and not @ignore",
    		plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setBrowser(@Optional("chrome") String browser) {
        hook.setBrowser(browser);
        System.out.println("Browser set to: " + browser);
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
