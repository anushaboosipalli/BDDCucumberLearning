package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/AmazonCart.feature"},
        glue = {"stepDefinitions"},
        plugin = {"pretty",
                "json:Reports/report.json",
                "junit:Reports/reports.xml"
        }
)
public class AmazonCartRunner {

}
