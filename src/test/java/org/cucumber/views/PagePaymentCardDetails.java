package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePaymentCardDetails {
	
	@FindBy(xpath = "//a[@id='newApplication']")
	private WebElement ButtonNewApplication;
	
	@FindBy(xpath = "//*[@id='backlink']")
	private WebElement ButtonBack;

	@FindBy(xpath = "//*[@id='container']/form/ul/li")  
	private WebElement RefNumber;

	public void ClickBack() {
		ButtonBack.click();
	}

	public void ClickNewApplication() {
		ButtonNewApplication.click();
	}

	/**
	 * gets the ref number produced? currently a capita ref number, should
	 * change when card providers switch
	 * 
	 * @return
	 */
	public String GetRefNumber() {
		String refNumber = RefNumber.getText();
		
		String NewrefNumber = refNumber.replace("Capita Ref Number", "");
		
		return NewrefNumber;
	}

}
