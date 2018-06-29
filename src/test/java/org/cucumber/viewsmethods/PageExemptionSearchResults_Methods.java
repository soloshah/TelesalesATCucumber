package org.cucumber.viewsmethods;

import uk.nhs.nhsbsa.config.env.TestBase;
import org.cucumber.views.TelesalesBasePage;
import org.openqa.selenium.support.PageFactory;

public class PageExemptionSearchResults_Methods extends TestBase {
	
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
	
	public void ClickBack() {
		telesalesBasePage.ButtonBack.click();
	}

}
