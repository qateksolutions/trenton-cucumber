package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/mortgagecalculator.feature",
        glue = {"step_definitions"},
        plugin = {"pretty", "summary", "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
}
