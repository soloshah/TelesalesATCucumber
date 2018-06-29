package uk.nhs.nhsbsa.steps.hooks;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
	@Before("@smoke")
	public void beforeScenario1(Scenario scenario) throws IOException
	{
		System.out.println("***** START of Scenario: " + scenario.getName() + " *****");
		System.out.println("Test setup - insert any test setup here");
	}

	@After("@smoke")
	public void tearDown1(Scenario scenario) throws Exception
	{
		System.out.println("***** END of Scenario: " + scenario.getName() + " *****");
		System.out.println("Test teardown - insert any post test activities here");
	}

}
