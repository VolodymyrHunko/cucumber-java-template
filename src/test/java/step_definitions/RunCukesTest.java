package step_definitions;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions (
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@excel"}
		)
public class RunCukesTest{ }