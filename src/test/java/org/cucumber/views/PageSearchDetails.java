package org.cucumber.views;

import static org.junit.Assert.assertTrue;
import org.cucumber.ppctelesales.model.Search;
import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSearchDetails {
	
	@FindBy(xpath = "//input[@name='searchCertificateNumber']")
	private WebElement InputCertificateNumber;

	@FindBy(xpath = "//input[@name='searchDDRef']")
	private WebElement InputDirectDebitReference;

	@FindBy(xpath = "//input[@name='surname']")
	private WebElement InputSurname;

	@FindBy(xpath = "//input[@name='dob']")
	private WebElement InputDob;

	@FindBy(xpath = "//input[@name='postcode']")
	private WebElement InputPostcode;
	
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement ButtonSubmit;

	@FindBy(xpath = "//a[@id='cancellink']")
	private WebElement ButtonCancel;
	
	@FindBy(xpath = "//*[@id='emailAddressField']")
	private WebElement InputEmailAddress;

	@FindBy(xpath = "//*[@id='nhsnumberField']")
	private WebElement InputNhsNumber;

	/**
	 * sends the search criteria to each relevant field on the search details
	 * page
	 * 
	 * @param search
	 */
	public void PopulateSearchCriteria(Search search) {

		InputCertificateNumber.clear();
		InputCertificateNumber.sendKeys(search.CertificateNumber);

		InputDirectDebitReference.clear();
		InputDirectDebitReference.sendKeys(search.DirectDebitReference);

		InputSurname.clear();
		InputSurname.sendKeys(search.Surname);

		InputDob.clear();
		InputDob.sendKeys(search.Dob);

		InputPostcode.clear();
		InputPostcode.sendKeys(search.Postcode);
		
		InputEmailAddress.clear();
		InputEmailAddress.sendKeys(search.EmailAddress);

		InputNhsNumber.clear();
		InputNhsNumber.sendKeys(search.NhsNumber);
		
	}

	/**
	 * clicks the submit button on the search details page
	 */
	public void ClickSubmit() {
		TestLogger.Info("Clicking submit button");
		ButtonSubmit.click();
	}

	/**
	 * clicks the cancel button on the search details page
	 */
	public void CancelSearch() {
		TestLogger.Info("Clicking cancel button");
		ButtonCancel.click();
	}
	
//    public boolean isCorrectPage(String expectedUrl){
//        
//    	String currentUrl = driver.getCurrentUrl();
//	 	assertTrue("Not correct Page", currentUrl.contains(expectedUrl));
//	 	Wait(1);	 	
//        return true;
//        
//    }
//    
//	/**
//	 * checks if an error message is present
//	 * 
//	 * @param errorMessage
//	 * @return
//	 */
//	public Boolean CheckSearchErrorIsPresent(String errorMessage) {
//
//		TestLogger.Check("looking for error message " + errorMessage);
//
//		return super.isElementPresent(By
//				.xpath("//ul[@id='pageErrors']//*[contains(text(), '"
//						+ errorMessage + "')]"));
//	}

}
