package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"pretty","html:reports/cucumber.html","json:reports/cucumber.json"}
		
		,features="src/test/resources/features"
		,glue={"stepDefinitions"}
	//,tags ="@DeletePlace"
		,monochrome = true
		,dryRun = false

)

public class TestRunner {
	
}