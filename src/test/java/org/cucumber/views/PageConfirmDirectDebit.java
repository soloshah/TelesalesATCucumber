package org.cucumber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageConfirmDirectDebit {
	
	@FindBy(xpath = "//input[@id='buttonControl']")
	private WebElement ButtonContinueI;

	@FindBy(xpath = "//*[@id='container']/form/table/tbody/tr[4]/td[2]/span")
	private WebElement CertNumber;

	/*
	 * public void isCertificateIssued(String expectedSortCode){
	 * 
	 * DriverManager.Driver().findElement(By.xpath("")).getAttribute("text"); }
	 */
	
	public String getCertificateNumber(){

		String locator = "//*[@id='container']/form/table/tbody/tr[4]/td[2]/span";	 	
	 	
	 	String CertificateNumber = CertNumber.findElement(By.xpath(locator)).getText();
	 	
        return CertificateNumber;
    }
	
	public void ClickContinue() {
		ButtonContinueI.click();
	}

}
