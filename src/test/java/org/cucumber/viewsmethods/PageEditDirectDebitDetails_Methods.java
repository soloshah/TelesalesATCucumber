package org.cucumber.viewsmethods;

import uk.nhs.nhsbsa.config.env.TestBase;
import org.openqa.selenium.By;

public class PageEditDirectDebitDetails_Methods extends TestBase {
	
	public boolean isDueDayErrorPresent() {

		String errorText = null;
		String locator = null;
		
		errorText = "Due day cannot be within 12 working days of today";
		locator = "//*[@id='container']/div/div[1]/div/form/div[1]/div[3]/div[5][contains(text(),'"+ errorText + "')]";
	//	TestLogger.Info("QQ " + super.isElementVisible(By.xpath(locator)));
		return super.isElementVisible(By.xpath(locator));
		
	}

}
