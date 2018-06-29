package org.cucumber.views;

import org.cucumber.ppctelesales.model.Applicant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAddressSearch {

	@FindBy(xpath = "//*[@id='buttonControl']/div/a[1]")
	public WebElement ButtonClearForm;

	@FindBy(xpath = "//*[@id='buttonControl']/div/input")
	public WebElement ButtonSubmit;

	@FindBy(xpath = "//*[@id='buttonControl']/div/a[2]")
	public WebElement ButtonCancel;

    @FindBy(xpath = "//*[@id='container']/form/table/tbody/tr[6]/td[2]/input")  
    private WebElement InputPostcode;

	@FindBy(xpath = "//*[@id='container']/form/table/tbody/tr[3]/td[1]/span/b/a")
	private WebElement LinkAddress1;
	
	@FindBy(xpath = "//*[@id='container']/form/table/tbody/tr[4]/td[1]/span/b/a")
	private WebElement LinkAddress2;                               
	
	public void SetPostcode(Applicant applicant) {
		InputPostcode.clear();
		InputPostcode.sendKeys(applicant.PostCode);
	}

	// PLACEHOLDER
//	public boolean IsErrorPresent() {
//
//		String errorText = "No addresses were found for the specified search criteria";
//		String locator = "//*[@id='container']/form/p/b/span";
//		TestLogger.Info("TEST " + super.isElementVisible(By.xpath(locator)));  
//		return super.isElementVisible(By.xpath(locator));
//		
//	}
//
//	public boolean IsPresent(String findText) {
//		
//		//*[@id="container"]/form/table/tbody/tr[12]/td[1]/span/b/a			
//		String locator = "//*[@id='container']/form/table/tbody/tr/td/span/b/a[@class = 'linkcolors'][contains(text(),'"+ findText + "')]";
//		
//		TestLogger.Info("TEST " + super.isElementVisible(By.xpath(locator)));
//		return super.isElementVisible(By.xpath(locator));
//		
//	}
	
	public void ClickAddress1(int rowNum) {
		
		switch(rowNum) {
		case 1:
			LinkAddress1.click();
			break;
		case 2:
			LinkAddress2.click();
			break;
		default:
			LinkAddress1.click();
		}
		
	}	 		 
	
    public void ClickClearForm(){
    	ButtonClearForm.click();
    }
    
    public void ClickSubmit(){
        ButtonSubmit.click();
    }
    public void ClickCancel(){
    	ButtonCancel.click();
    }
    
}
