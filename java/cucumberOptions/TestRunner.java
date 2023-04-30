package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		plugin= {"pretty","html:reports/cucumber.html","json:reports/cucumber.json"}
		
		,features="src/test/resources/features"
		,glue={"stepDefinitions"}
	//,tags =""
		,monochrome = true
		,dryRun = false

)

public class TestRunner {
	
}