package uk.nhs.nhsbsa.steps.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import uk.nhs.nhsbsa.config.env.BaseTest;

public class ScreenShotHelper implements BaseTest
{
	@After
	public static void embedScreenshot(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			try
			{
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
			catch (WebDriverException wde)
			{
				System.err.println(wde.getMessage());
			}
			catch (ClassCastException cce)
			{
				cce.printStackTrace();
			}
		}
	}

}
