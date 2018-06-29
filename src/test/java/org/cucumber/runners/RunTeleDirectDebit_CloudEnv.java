package org.cucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import gherkin.formatter.AnsiFormats;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        //plugin =  {"pretty", "html:target/cucumber","json:target/jsonReports/ExampleTest.json"},
        format =  {"pretty", "html:target/cucumber","json:target/jsonReports/ExampleTest.json"},
        glue = {"org.cucumber"},
        features = {"src/test/resources/features/Cloud/"},
        tags ={"@TeleDirectDebit_Cloud"}
)

public class RunTeleDirectDebit_CloudEnv {

}
