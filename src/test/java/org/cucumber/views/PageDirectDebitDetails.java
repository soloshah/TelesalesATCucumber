package org.cucumber.views;


import org.cucumber.ppctelesales.model.Account;
import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.utils.TestLogger;
import org.cucumber.views.PageDirectDebitDetails.AccountError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDirectDebitDetails {
	
	public String bankNameID = "//input[@name='bankName']";

	@FindBy(xpath = "//input[@id='sortcodeInput']")
	public WebElement InputSortCode;

	@FindBy(xpath = "//input[@name='accountNumber']")
	public WebElement InputAccountNumber;

	@FindBy(xpath = "//input[@id='certStartDate']")
	private WebElement InputCertificateStart;

	@FindBy(xpath = "//textarea[@id=noteInput]")
	private WebElement InputNotes;

	@FindBy(xpath = "//a[@id='skipPaymentButtonConfirm']")
	private WebElement ButtonSkipPayment;

	@FindBy(xpath = "//input[@name='accountForename']")
	public WebElement InputAccountHolderInitial;

	@FindBy(xpath = "//input[@name='accountSurname']")
	public WebElement InputAccountHolderSurname;

	@FindBy(xpath = "//input[@name='thirdParty']")
	public WebElement InputThirdParty;

	@FindBy(xpath = "//input[@id='submit']")
	private WebElement ButtonSubmitI;

	//CL - Added field find for the Bank Name field that appears from Bank Checker.	
	@FindBy(xpath = "//input[@name='bankName']")
	public WebElement BankNameText;
	
	@FindBy(xpath = "//input[@name='bankAddress']")
	public WebElement BankAddress;
		
	public void ClearAccountDetails() {

		InputSortCode.clear();
		InputAccountNumber.clear();
	}
	
	public enum AccountError {
		NoSortCode, SortCodeNotRecognised, NoAccountNumber, InvalidAccountNumber, AccountDoesNotAcceptDirectDebits, SortCodeNotNumbers, SortCode5Digits, AccountNumberShort, AccountNumberNotNumeric
	}
	
//	public void IsAccountErrorPresent(AccountError error) {
//
//		String errorText = null;
//		String locator = null;
//		
//		switch (error) {
//		case NoSortCode:
//			errorText = "Sort code is required";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCode5Digits:
//			errorText = "Sort code must have at least 5 digits";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCodeNotNumbers:
//			errorText = "Sort code must be a number";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCodeNotRecognised:
//			errorText = "Sort code was not recognised";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case NoAccountNumber:
//			errorText = "Account Number is required";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case AccountNumberNotNumeric:
//			errorText = "Account Number must be a number";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[4][contains(text(),'"+ errorText + "')]";
//			break;			
//		case AccountNumberShort:
//			errorText = "Account Number must have at least 6 digits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[2][contains(text(),'"+ errorText + "')]";
//			break;
//			
//		case InvalidAccountNumber:
//			errorText = "Account Number is not valid or does not accept Direct Debits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case AccountDoesNotAcceptDirectDebits:
//			errorText = "Account Number is not valid or does not accept Direct Debits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		}
//
//		//return super.isElementVisible(By.xpath(locator));
//		
//	}

//	public void SendAccountDetails(Account acc) {
//
//		InputSortCode.sendKeys(acc.SortCode);
//		InputAccountNumber.sendKeys(acc.AccountNumber);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException ex) {
//			Logger.getLogger(PageDirectDebitDetails.class.getName()).log(
//					Level.SEVERE, null, ex);
//		}
//		
//
//		// This is in here because if you don't send valid account details
//		// the other controls don't appear (which may be intentional for
//		// certain tests) - note we reduce the implicit wait here to speed
//		// up the time taken for the ElementNotVisibleException to be caught
//		// it then gets set back to the default value in the TestManager
//		// (test manager has already read that from the test config file)
//		
//		String locator = "//*[@id='directDebitForm']/ng-form/ng-form[2]/div[1]/div/div/div[3]/input";
//
//		if (super.isElementVisible(By.xpath(locator))==true){
//			
//			try {
//
//				ReduceTimeout(2);
//
//				InputThirdParty.sendKeys(acc.thirdParty.toString());
//
//			} catch (ElementNotVisibleException ex) {
//
//				TestLogger.Error("third party control didn't appear", ex);
//
//				DefaultTimeout();
//			}
//			
//		}
//			
//	}

	public void SendSortCode(Account acc) {
		InputSortCode.sendKeys(acc.SortCode);
	}

	public void SendAccountNumber(Account acc) {
		InputAccountNumber.sendKeys(acc.AccountNumber);
	}

	public void SetThirdParty(Account.ThirdParty party) {
		InputThirdParty.sendKeys(party.toString());
	}

//	public void SendAccountHolderName(Applicant app) {
//
//		setAccountHolderTitle(app);
//
//		InputAccountHolderInitial.sendKeys(getAccountHolderInitial(app.Forename));
//
//		InputAccountHolderSurname.sendKeys(app.Surname);
//	}

	public void ClearCertificateStartDate() {

		InputCertificateStart.clear();
	}

	public void SendCertificateStartDate(Certificate cert) {

		InputCertificateStart.sendKeys(cert.CertificateStart);
	}

	public void SendNotes() {

		InputNotes.sendKeys("");
	}

	public void ClickSkipPayment() {

		ButtonSkipPayment.click();
	}

	public void SubmitDirectDebitDetails() {
		ButtonSubmitI.click();
	}

	public void ClickSubmit() {
		ButtonSubmitI.click();
	}
	
	public void WaitForMylocator(){
	
    //	wait.until(ExpectedConditions.presenceOfElementLocated(BankAddress));
		
	}

//	private void setAccountHolderTitle(Applicant app) {
//
//		String title;
//
//		if (!"".equals(app.OtherTitle)) {
//			title = app.OtherTitle;
//		} else {
//			title = app.Title.toString();
//		}
//
//		driver.findElement(By.xpath("//select[@name='accountTitleCode']" + "/option[text()='" + title + "']")).click();
//	}

//	private String getAccountHolderInitial(String forename) {
//
//		char initial = forename.charAt(0);
//
//		return String.valueOf(initial);
//	}

//	public enum AccountError {
//		NoSortCode, SortCodeNotRecognised, NoAccountNumber, InvalidAccountNumber, AccountDoesNotAcceptDirectDebits, SortCodeNotNumbers, SortCode5Digits, AccountNumberShort, AccountNumberNotNumeric
//	}

	/**
	 * checks for the presence of the specified account error on the direct
	 * debit page
	 * 
	 * @param error
	 * @return
	 */
//	public boolean IsAccountErrorPresent(AccountError error) {
//
//		String errorText = null;
//		String locator = null;
//		
//		switch (error) {
//		case NoSortCode:
//			errorText = "Sort code is required";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCode5Digits:
//			errorText = "Sort code must have at least 5 digits";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCodeNotNumbers:
//			errorText = "Sort code must be a number";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
//			break;
//		case SortCodeNotRecognised:
//			errorText = "Sort code was not recognised";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case NoAccountNumber:
//			errorText = "Account Number is required";
////			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case AccountNumberNotNumeric:
//			errorText = "Account Number must be a number";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[4][contains(text(),'"+ errorText + "')]";
//			break;			
//		case AccountNumberShort:
//			errorText = "Account Number must have at least 6 digits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[2][contains(text(),'"+ errorText + "')]";
//			break;
//			
//		case InvalidAccountNumber:
//			errorText = "Account Number is not valid or does not accept Direct Debits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		case AccountDoesNotAcceptDirectDebits:
//			errorText = "Account Number is not valid or does not accept Direct Debits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
//			break;
//		}
//
//		return super.isElementVisible(By.xpath(locator));
//		
//	}
//	
//	 public boolean isCorrectAccountCode(String accCode){
//		 
//	        String locator = "//tr[7]/td[1]/table/tbody/tr[2]/td/text()[contains(.,'" + accCode + "')]/..";
//	        
//	        return super.isElementVisible(By.xpath(locator));
//        
//	    }
//
//	 public boolean isServerError(String errorText){
//		 
//	        String locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[6][contains(text(),'"+ errorText + "')]";
//	        
//	        return super.isElementVisible(By.xpath(locator));
//	        
//	    }
//	 
//	 public boolean isCorrectSortCode(String sortCode){
//		 
//		 	Wait(1);	        
//	        String locator = "//tr[7]/td[1]/table/tbody/tr[2]/td/text()[contains(.,'" + sortCode + "')]/..";
//	        return super.isElementVisible(By.id("input.form-control.ng-pristine.ng-untouched.ng-valid"));
//	    }
//
//	 public boolean isCorrectBankName(String bankName){
//	        
//		 	/*CL - Create BName variable for use in the below check,
//		 	  Finds the Bank Name disabled field that appears from the Bank Checker functionality.
//		 	  Retrieves the value from that disabled field using getAttribute("value")
//		 	 */
//		 
//		 	String BName = BankNameText.getAttribute("value");
//		 	
//		 	//Assert equal check that the bank name is passed into the function is the same as retrieved
//		 	assertTrue("Banks are not equal", BName.contains(bankName));
//		 	Wait(1);
//		 	
//	        return true;
//	    }
//	 
//	 public boolean isCorrectBankAddress(String bankName){
//	        	
//		 	/*CL - Create BName variable for use in the below check,
//		 	  Finds the Bank Name disabled field that appears from the Bank Checker functionality.
//		 	  Retrieves the value from that disabled field using getAttribute("value")
//		 	 */
//		 
//		 	String BAddress = BankAddress.getAttribute("value");
//
//		 	//Assert equal check that the bank name that is passed into the function is the same as retrieved
//		 	assertTrue("Banks Addresses are not equal", BAddress.contains(bankName));		 	
//		 	Wait(1);
//		 	
//	        return true;
//	    }
 
//	    public boolean waitForElement(){
//	    	
//	    	WebDriverWait wait = new WebDriverWait(driver, getImpWaitTimeout());
//	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(bankNameID)));
//	    	return true;
//	    }
	    
//	    public boolean isBranchEmpty(){
//	    	
//	    	String BAddress = BankAddress.getAttribute("value");
//	    	
//		 	assertTrue("Banks Addresses is not empty", BAddress.isEmpty());
//		 	Wait(1);
//		 	
//	        return true;
//	        
//	    }

}
