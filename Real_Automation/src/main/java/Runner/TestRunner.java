package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "FeatureFile/Login.feature",
		glue="Browser_Setup",
		dryRun = false,
		monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
		
public class TestRunner extends AbstractTestNGCucumberTests  {


}
