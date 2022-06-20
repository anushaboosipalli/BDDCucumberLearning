package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/ContactUs.feature"},
        glue = {"stepDefinitions"},
        publish = true
)
public class TestRunner {


}

