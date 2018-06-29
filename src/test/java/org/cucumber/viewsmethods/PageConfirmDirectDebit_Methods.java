package org.cucumber.viewsmethods;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;
import org.openqa.selenium.By;

public class PageConfirmDirectDebit_Methods implements BaseTest {
	
	TestBase testBase = new TestBase();
	
	public boolean isCertificateIssued(String errorMessage) {

		// String locator = "//td/p[1]/text()[contains(.,'" + errorMessage +
		// "')]/..";
		String locator = "//*[@id='container'][contains(.,'Certificate Details')]/form/table/tbody/tr[4]/td[1]/span/div/b/text()[contains(.,'"
				+ errorMessage + "')]/..";

		return testBase.isElementPresent(By.xpath(locator));

	}

}
