package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={".//Features/"},
		glue="stepDefiniation",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"},
		tags = "@sanity"
						
		)

public class testRunn {

}
