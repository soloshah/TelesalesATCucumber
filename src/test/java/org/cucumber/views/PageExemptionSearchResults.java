package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageExemptionSearchResults {

	@FindBy(xpath = "//input[@id='submitLink']")
	private WebElement ButtonNewApplication;

//	public void ClickBack() {
//		super.ButtonBack.click();
//	}

	public void ClickNewApplication() {
		ButtonNewApplication.click();
	}

}
