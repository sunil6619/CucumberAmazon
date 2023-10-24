package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import org.junit.runner.RunWith;







@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/LoginFeature.feature"},
		//to run all features 
//		features = ".//Features/",
		glue="StepDefinition",
		dryRun = false, 	
		monochrome = true,
		tags="@Sanity",//scenarios under sanity will be executed
//		plugin= {"pretty","junit:target/cucumber-reports/reports_xml.xml","html:target/cucumber-reports/reports1.html",
//				"json:target/cucumber-reports/reports_json.json"}
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)

//plugin= {"pretty","html:target/cucumber-reports/reports1.html"}
//{"pretty","json:target/cucumber-reports/reports_json.json"}

// for Testng cucumber integration
//public class Run extends AbstractTestNGCucumberTests {
///*This class will be empty*/
//}

public class Run {
/*This class will be empty*/
}
