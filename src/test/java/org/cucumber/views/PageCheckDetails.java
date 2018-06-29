package org.cucumber.views;

import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCheckDetails {
	
	@FindBy(xpath = "//a[@id='paymentCalllink']")
	private WebElement ButtonCardPaymentCall;
	
	@FindBy(xpath = "//*[@id='container']/form/table/tbody/tr[2]/td[3]/span")
	private WebElement CertNumber;
	
	public void ClickCardPaymentCall() {
		ButtonCardPaymentCall.click();
	}
 
	public String getCertificateNumber(){
		//*[@id="container"]/form/table/tbody/tr[2]/td[3]/span  
		String locator = "//*[@id='container']/form/table/tbody/tr[2]/td[3]/span";	 	
		 	
		 String CertificateNumber = CertNumber.findElement(By.xpath(locator)).getText();
		 TestLogger.Info("Q" + CertificateNumber);
	     return CertificateNumber;
	}

}
