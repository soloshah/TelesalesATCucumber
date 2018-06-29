package org.cucumber.viewsmethods;

import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

public class PageAddressSearch_Methods implements BaseTest {
	
	TestBase testBase = new TestBase();
	
	public boolean IsErrorPresent() {

		String errorText = "No addresses were found for the specified search criteria";
		String locator = "//*[@id='container']/form/p/b/span";
		TestLogger.Info("TEST " + testBase.isElementVisible(By.xpath(locator)));  
		return testBase.isElementVisible(By.xpath(locator));
		
	}

	public boolean IsPresent(String findText) {
		
		//*[@id="container"]/form/table/tbody/tr[12]/td[1]/span/b/a			
		String locator = "//*[@id='container']/form/table/tbody/tr/td/span/b/a[@class = 'linkcolors'][contains(text(),'"+ findText + "')]";
		
		TestLogger.Info("TEST " + testBase.isElementVisible(By.xpath(locator)));
		return testBase.isElementVisible(By.xpath(locator));
		
	}

}
