package org.cucumber.views;

import org.cucumber.ppctelesales.model.Search;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSearchResults {
	
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

	@FindBy(xpath = "//*[@id='submitLink']") 
	private WebElement ButtonNewApplication;

	@FindBy(xpath = "//*[@id='container']/table/tbody/tr[1]/td[1]/a/strong")
	private WebElement LinkCertNumber1;                               

	@FindBy(xpath = "//*[@id='container']/table/tbody/tr[2]/td[1]/a/strong")
	private WebElement LinkCertNumber2;                                     

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
	}

	/**
	 * clicks the submit button on the search details page
	 */
	public void ClickSubmit() {
		//TestLogger.Info("Clicking submit button");
		ButtonSubmit.click();
	}
	
	public void ClickNewApplication() {
		ButtonNewApplication.click();
	}
	
	public void ClickCertNumber(int rowNum) {
		
		switch(rowNum) {
		case 1:
			LinkCertNumber1.click();
			break;
		case 2:
			LinkCertNumber2.click();
			break;
		default:
			LinkCertNumber1.click();
		}
		
	}
    
	/**
	 * clicks the cancel button on the search details page
	 */
	public void CancelSearch() {
		//TestLogger.Info("Clicking cancel button");
		ButtonCancel.click();
	}
	
//	/**
//	 * checks you are on the page you expect to be on
//	 */	
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
//	 * checks you have the correct certificate number - must be the 1st entry on the list
//	 */
//	public boolean isCorrectCertificate(String certNumber) {
//
//		String locator = "//*[@id='container']/table/tbody/tr/td[1]/a/strong[contains(.,'" + certNumber + "')]";
//		assertTrue("Failed to find Certificate Number",super.isElementPresent(By.xpath(locator)));
//
//		return true;
//
//	}
//	
//	/**
//	 * checks you have the correct DD Ref number
//	 */
//	public boolean isCorrectDDRef(String DDRef) {
//
//		String locator = "//*[@id='container']/table/tbody/tr/td[1]/a/strong[contains(.,'" + DDRef + "')]";
//		assertTrue("Failed to find Certificate Number",super.isElementPresent(By.xpath(locator)));
//
//		return true;
//		
//	}
//	
//	/**
//	 * counts how many certificates are found
//	 */
//	public int countCertificatesFound() {
//
//		String locator = "//*[@id='container']/table/tbody/tr";
//		
//		int totalCertificates =  driver.findElements(By.xpath(locator)).size();
//		
//		return totalCertificates;
//
//	}
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
//		String locator = "//*[@id='container']/form/span/b";
//
//		return super.isElementPresent(By.xpath("//*[@id='container']//*[contains(text(),'mpt')]"));
//		
//	}

}
