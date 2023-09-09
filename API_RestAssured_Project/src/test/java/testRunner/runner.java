package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/"
							},
				glue= {"stepDefs"},
				monochrome=true,
				plugin = {"pretty","html:target/html_report/report.html"})

public class runner extends AbstractTestNGCucumberTests {

}
