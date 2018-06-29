package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.utils.TestLogger;

public class PageEditExemption {
		
	 	@FindBy(xpath = "//*[@id='personalDetails']/div[1]/div[2]/input")
	 	public WebElement InputAddressLine1;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[2]/div[2]/input")
	    public WebElement InputAddressLine2;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[3]/div[2]/input")
	    public WebElement InputTown;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[4]/div[2]/input")
	    public WebElement InputAddressLine4;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[5]/div[2]/input")
	    public WebElement InputPostcode;
	    
	    @FindBy(xpath = "//*[@id='getAddressBtn']")
	    public WebElement ButtonGetAddress;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[6]/div[2]/input")
	    public WebElement InputSurname;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[7]/div[2]/input")
	    public WebElement InputForename;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[8]/div[2]/div/input")
	    public WebElement InputDob;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[9]/div[2]/input")
	    public WebElement InputTelephoneNumber;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[10]/div[2]/input")
	    public WebElement InputEmailAddress;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[11]/div[2]/div/input")
	    public WebElement InputDueDate;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[12]/div[2]/div/input")
	    public WebElement InputNhsNumber;
	    
	    @FindBy(xpath = "//*[@id='personalDetails']/div[13]/div[2]/textarea")
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
	    
		@FindBy(xpath = "//*[@id='reissueLink']")      
		public WebElement ReissueButton;
		
		@FindBy(xpath = "//*[@id='IssueLink']")      
		public WebElement IssueButton;

	    
	    public void PopulateEditExemption(Mother mother){
	        
	        InputNotes.sendKeys(mother.Notes);
	        
	        InputEmailAddress.clear();
	        InputEmailAddress.sendKeys(mother.EmailAddress);
	       	        
	    }
	    
//	    public void PopulatePersonalDetails(Applicant applicant){
//	        
//	    	PageApplicantDetails_Methods.SetApplicantTitle(applicant);
//	        
//	        InputSurname.sendKeys(applicant.Surname);
//	        
//	        InputForename.sendKeys(applicant.Forename);
//	        
//	        InputDob.clear();
//	        InputDob.sendKeys(applicant.Dob);
//	        
//	        InputTelephoneNumber.sendKeys(applicant.TelephoneNumber);
//	        
//	        InputNhsNumber.sendKeys(applicant.NhsNumber);
//	        
//	        InputNotes.sendKeys(applicant.Notes);
//	        
//	        PageApplicantDetails_Methods.SetPaymentType(applicant.PaymentType);
//	    }
	    
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
	    
//		 public boolean isAddress1Correct(String expectedAddress){

//			 String add1 = Address1Text.getAttribute("value");
//			 if (!add1.isEmpty()) {
//				 String address1 = Address1Text.getAttribute("value");
//				 assertTrue("Address line 1 is not correct", address1.contains(expectedAddress));
//			 }
			 
//			 return true;
			 
//		 }

//		 public boolean isAddress2Correct(String expectedAddress){
			 
//			 String add2 = Address2Text.getAttribute("value");
//			 if (!add2.isEmpty()) {
//				 String address2 = Address2Text.getAttribute("value");
//				 assertTrue("Address line 2 is not correct", address2.contains(expectedAddress));
//			 }
			 
//			 return true;
			 
//		 }
//		 public boolean isAddress3Correct(String expectedAddress){
			 
//			 String add3 = Address3Text.getAttribute("value");
//			 if (!add3.isEmpty()) {
//				 String address3 = Address3Text.getAttribute("value");
//				 assertTrue("Address line 3 is not correct", address3.contains(expectedAddress));
//			 }
			 	
//			 return true;
			 
//		 }
//		 public boolean isAddress4Correct(String expectedAddress){

//			 String add4 = Address4Text.getAttribute("value");
//			 if (!add4.isEmpty()) {
		
//				 String address4 = Address4Text.getAttribute("value");
//				 assertTrue("Address line 4 is not correct", address4.contains(expectedAddress));
//			 }
			 
//			 return true;
			 
//		 }
		 
//		 public boolean isPostcodeCorrect(String expectedPostcode){

//			 String postC = PostcodeText.getAttribute("value");
//			 if (!postC.isEmpty()) {
		
//				 String postcode = PostcodeText.getAttribute("value");
//				 assertTrue("Postcode 1 is not correct", postcode.contains(expectedPostcode));
//			 }
			 
//			 return true;
			 
//		}

//	    public void ClickGetAddress(){
//	        ButtonGetAddress.click();
//	    }
	    
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
	    
//	    public void ClickReissue(){
//	    	ReissueButton.click();
//	    }
}	    