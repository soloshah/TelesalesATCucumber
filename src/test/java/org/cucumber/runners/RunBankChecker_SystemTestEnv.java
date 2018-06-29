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
        features = {"src/test/resources/features/SystemTest/"},
        tags ={"@BankChecker_Sys"}
)

public class RunBankChecker_SystemTestEnv {

}


/* 
 	View run configurations
	Select Maven Build >> New
	Set Base directory ${workspace_loc:/cucumber-template}

	Set Goals verify -Dcucumber.options="src/test/resources/features/ --tags @smoke --no-dry-run" replacing the folder and tags as requires
	Apply and Run

  mvn verify -Dcucumber.options="src/test/resources/features/ --tags @mydemo --no-dry-run" 
  
 */