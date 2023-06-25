package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ("C:/Users/Boban/Desktop/Learning Automation/CucumberSelenium/Features/"),
        glue = "stepDefinitions",
        tags = " ",
        plugin = {"pretty",
                    "json:target/MyReports/report.json",
                    "junit:target/MyReports/report.xml"
        },
        publish = true
)

public class TestRunner {
}
