package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features"}
					,glue= {"stepdefinitions"}
//					,tags= "@manju"
					,plugin= {"pretty","html:target/cucumber-html-report"}
					,monochrome= true
				)
public class TestRunner{
	
}
