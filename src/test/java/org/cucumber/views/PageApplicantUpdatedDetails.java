package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.viewsmethods.PageApplicantDetails_Methods;

public class PageApplicantUpdatedDetails {
	
	 	@FindBy(xpath = "//input[@name='address1']")
	 	public WebElement InputAddressLine1; 
	    
	    @FindBy(xpath = "//input[@name='address2']")
	    public WebElement InputAddressLine2;
	    
	    @FindBy(xpath = "//input[@name='address3']")
	    public WebElement InputAddressLine3;
	    
	    @FindBy(xpath = "//input[@name='address4']")
	    public WebElement InputAddressLine4;
	    
	    @FindBy(xpath = "//input[@name='postcode']")
	    public WebElement InputPostcode;
	    
	    @FindBy(xpath = "//a[@id='getAddressBtn']")
	    public WebElement ButtonGetAddress;
	    
	    @FindBy(name = "surname']")
	    public WebElement InputSurname;
	    
	    @FindBy(xpath = "//input[@name='forename']")
	    public WebElement InputForename;
	    
	    @FindBy(xpath = "//input[@name='dob']")
	    public WebElement InputDob;
	    
	    @FindBy(xpath = "//input[@name='telephoneNumber']")
	    public WebElement InputTelephoneNumber;
	    
	    @FindBy(xpath = "//input[@name='nhsNumber']")
	    public WebElement InputNhsNumber;
	    
	    @FindBy(xpath = "//textarea[@name='notes']")
	    public WebElement InputNotes;

	    @FindBy(xpath = "//*[@id='personalDetails']/div[1]/div[2]/input")
	    public WebElement Address1Text;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[2]/div[2]/input") 
	    public WebElement Address2Text;

	    @FindBy(xpath = "//*[@id='personalDetails']/div[3]/div[2]/input")
	    public WebElement Address3Text;

	    @FindBy(xpath = "//*[@id='personalDetails']/div[4]/div[2]/input")
	    public WebElement Address4Text;

	    @FindBy(xpath = "//*[@id='personalDetails']/div[5]/div[2]/input") 
	    public WebElement PostcodeText;
    
//	    private void SetApplicantTitle(Applicant applicant){
//	        
//	        if (null != applicant.Title)switch (applicant.Title) {
//	            case Other:
//	                SetOtherTitle(applicant.OtherTitle);
//	                break;
//	            case NotSet:
//	                //log this
//	                break;
//	            default:
//	                driver.findElement(By.
//	                        xpath("//input[@title='" + applicant.Title + "']")).click();
//	                break;
//	        }
//	    }
//	    
//	    private void SetOtherTitle(String title){
//	        
//	        driver.findElement(By.xpath("//input[@value='Other']"))
//	                .click();
//	        
//	        driver.findElement(By.
//	                xpath("//select[@name='othertitle']/option[text()='" + title + "']"))
//	                .click();
//	    }
	    
//	    public void PopulateAddressDetails(Applicant applicant){
//	        
//	        InputAddressLine1.clear();
//	        InputAddressLine1.sendKeys(applicant.Add1);
//	        
//	        InputAddressLine2.clear();
//	        InputAddressLine2.sendKeys(applicant.Add2);
//	        
//	        InputAddressLine3.clear();
//	        InputAddressLine3.sendKeys(applicant.Add3);
//	        
//	        InputAddressLine4.clear();
//	        InputAddressLine4.sendKeys(applicant.Add4);
//	        
//	        InputPostcode.clear();
//	        InputPostcode.sendKeys(applicant.PostCode);
//	    }
	    
	    public void PopulatePersonalDetails(Applicant applicant){
	                
	        InputNotes.sendKeys(applicant.Notes);
	        
	    }
	    
//	    public void SetPaymentType(Applicant.paymentType payType){
//	        
//	        String type;
//	        
//	        switch (payType){
//	            case CreditDebitCard:
//	                type = "card";
//	                break;
//	            case DirectDebit:
//	                type = "directdebit";
//	                break;
//	            case Cheque:
//	                type = "cheque";
//	                break;
//	            default:
//	                type = "card";
//	                break;
//	        }
//	        
//	        driver.findElement(By.xpath("//input[@name='payType'][@title='" + type + "']")).click();
//	    }
	    
		 public boolean isAddress1Correct(String expectedAddress){

			 String add1 = Address1Text.getAttribute("value");
			 if (!add1.isEmpty()) {
				 String address1 = Address1Text.getAttribute("value");
				 assertTrue("Address line 1 is not correct", address1.contains(expectedAddress));
			 }
			 
			 return true;
			 
		 }

		 public boolean isAddress2Correct(String expectedAddress){
			 
			 String add2 = Address2Text.getAttribute("value");
			 if (!add2.isEmpty()) {
				 String address2 = Address2Text.getAttribute("value");
				 assertTrue("Address line 2 is not correct", address2.contains(expectedAddress));
			 }
			 
			 return true;
			 
		 }
		 public boolean isAddress3Correct(String expectedAddress){
			 
			 String add3 = Address3Text.getAttribute("value");
			 if (!add3.isEmpty()) {
				 String address3 = Address3Text.getAttribute("value");
				 assertTrue("Address line 3 is not correct", address3.contains(expectedAddress));
			 }
			 	
			 return true;
			 
		 }
		 public boolean isAddress4Correct(String expectedAddress){

			 String add4 = Address4Text.getAttribute("value");
			 if (!add4.isEmpty()) {
		
				 String address4 = Address4Text.getAttribute("value");
				 assertTrue("Address line 4 is not correct", address4.contains(expectedAddress));
			 }
			 
			 return true;
			 
		 }
		 
		 public boolean isPostcodeCorrect(String expectedPostcode){

			 String postC = PostcodeText.getAttribute("value");
			 if (!postC.isEmpty()) {
		
				 String postcode = PostcodeText.getAttribute("value");
				 assertTrue("Postcode 1 is not correct", postcode.contains(expectedPostcode));
			 }
			 
			 return true;
			 
		 }

	    public void ClickGetAddress(){
	        ButtonGetAddress.click();
	    }
	    
	    /* Copied methods to TelesalesBasePage */
	    
//	    public void ClickSubmit(){
//	    	ButtonSubmit.click();
//	    }
//	    
//	    public void ClickBack(){
//	    	ButtonBack.click();
//	    }
//	    
//	    public void ClickCancel(){
//	    	ButtonCancel.click();
//	    }   

}
