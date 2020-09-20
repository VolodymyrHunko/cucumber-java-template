package step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;





@RunWith(Cucumber.class)
@CucumberOptions (
		monochrome = false,
		features = "classpath:features",
		glue = {"step_definitions"},
		format = {"pretty", "html:target/cucumber-html-report"}
		,tags = {"@JSON"}
		//,dryRun = true
		)
public class RunCukesTest{ }