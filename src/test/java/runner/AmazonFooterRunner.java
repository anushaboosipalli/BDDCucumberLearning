package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/AmazonFooter.feature"},
        glue = {"stepDefinitions"},
        tags = "@Footer",
        plugin = {"pretty",
                "json:Reports/report.json",
                "junit:Reports/reports.xml"
        },
        publish = true

)
public class AmazonFooterRunner {
}
