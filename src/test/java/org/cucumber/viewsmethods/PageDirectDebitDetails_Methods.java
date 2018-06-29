package org.cucumber.viewsmethods;

import static org.junit.Assert.assertTrue;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;

import org.cucumber.ppctelesales.model.Account;
import org.cucumber.ppctelesales.model.Applicant;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;
import org.cucumber.utils.TestLogger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.cucumber.views.PageDirectDebitDetails;
import org.cucumber.views.PageDirectDebitDetails.AccountError;
import org.openqa.selenium.By;

public class PageDirectDebitDetails_Methods implements BaseTest {
	
	PageDirectDebitDetails pageDirectDebitDetails = PageFactory.initElements(driver, PageDirectDebitDetails.class);
	
	TestBase testBase = new TestBase();
	
	public boolean isElementVisible(By by) {

		TestLogger.Info("looking for element " + by);

		if (driver.findElement(by).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}
    
    public boolean isElementPresent(By by) {

		try {

			TestLogger.Info("looking for element " + by);

			driver.findElement(by);

			return true;

		} catch (NoSuchElementException ex) {

			TestLogger.Error("could not find element " + by, ex);

			return false;
		}
	}
	
	public void SendAccountDetails(Account acc) {

		pageDirectDebitDetails.InputSortCode.sendKeys(acc.SortCode);
		pageDirectDebitDetails.InputAccountNumber.sendKeys(acc.AccountNumber);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Logger.getLogger(PageDirectDebitDetails.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		

		// This is in here because if you don't send valid account details
		// the other controls don't appear (which may be intentional for
		// certain tests) - note we reduce the implicit wait here to speed
		// up the time taken for the ElementNotVisibleException to be caught
		// it then gets set back to the default value in the TestManager
		// (test manager has already read that from the test config file)
		
		String locator = "//*[@id='directDebitForm']/ng-form/ng-form[2]/div[1]/div/div/div[3]/input";

//		if (testBase.isElementVisible(By.xpath(locator))==true){
			
			try {

				//testBase.ReduceTimeout(2);

				pageDirectDebitDetails.InputThirdParty.sendKeys(acc.thirdParty.toString());

			} catch (ElementNotVisibleException ex) {

				TestLogger.Error("third party control didn't appear", ex);

				//testBase.DefaultTimeout();
			}
			
//		}
			
	}
	
//	public enum AccountError {
//		NoSortCode, SortCodeNotRecognised, NoAccountNumber, InvalidAccountNumber, AccountDoesNotAcceptDirectDebits, SortCodeNotNumbers, SortCode5Digits, AccountNumberShort, AccountNumberNotNumeric
//	}
	
	private String getAccountHolderInitial(String forename) {

		char initial = forename.charAt(0);

		return String.valueOf(initial);
	}
	
	private void setAccountHolderTitle(Applicant app) {

		String title;

		if (!"".equals(app.OtherTitle)) {
			title = app.OtherTitle;
		} else {
			title = app.Title.toString();
		}

		driver.findElement(By.xpath("//select[@name='accountTitleCode']" + "/option[text()='" + title + "']")).click();
	}
	
	public void SendAccountHolderName(Applicant app) {

		setAccountHolderTitle(app);

		pageDirectDebitDetails.InputAccountHolderInitial.sendKeys(getAccountHolderInitial(app.Forename));

		pageDirectDebitDetails.InputAccountHolderSurname.sendKeys(app.Surname);
	}
	
	
	public boolean IsAccountErrorPresent(AccountError error) {

		String errorText = null;
		String locator = null;
		
		switch (error) {
		case NoSortCode:
			errorText = "Sort code is required";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
			break;
		case SortCode5Digits:
			errorText = "Sort code must have at least 5 digits";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
			break;
		case SortCodeNotNumbers:
			errorText = "Sort code must be a number";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[4][contains(text(),'"+ errorText + "')]";
			break;
		case SortCodeNotRecognised:
			errorText = "Sort code was not recognised";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[2]/div[5][contains(text(),'"+ errorText + "')]";
			break;
		case NoAccountNumber:
			errorText = "Account Number is required";
//			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
			break;
		case AccountNumberNotNumeric:
			errorText = "Account Number must be a number";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[4][contains(text(),'"+ errorText + "')]";
			break;			
		case AccountNumberShort:
			errorText = "Account Number must have at least 6 digits";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[2][contains(text(),'"+ errorText + "')]";
			break;
			
		case InvalidAccountNumber:
			errorText = "Account Number is not valid or does not accept Direct Debits";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
			break;
		case AccountDoesNotAcceptDirectDebits:
			errorText = "Account Number is not valid or does not accept Direct Debits";
			locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[5][contains(text(),'"+ errorText + "')]";
			break;
		}

		return isElementVisible(By.xpath(locator));
		
	}
	
	 public boolean isCorrectAccountCode(String accCode){
		 
	        String locator = "//tr[7]/td[1]/table/tbody/tr[2]/td/text()[contains(.,'" + accCode + "')]/..";
	        
	        return isElementVisible(By.xpath(locator));
        
	    }

	 public boolean isServerError(String errorText){
		 
	        String locator = "//*[@id='directDebitForm']/ng-form/ng-form[1]/div[5]/div[6][contains(text(),'"+ errorText + "')]";
	        
	        return isElementVisible(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectSortCode(String sortCode){
		 
		 testBase.Wait(1);	        
	        String locator = "//tr[7]/td[1]/table/tbody/tr[2]/td/text()[contains(.,'" + sortCode + "')]/..";
	        return isElementVisible(By.id("input.form-control.ng-pristine.ng-untouched.ng-valid"));
	    }

	 public boolean isCorrectBankName(String bankName){
	        
		 	/*CL - Create BName variable for use in the below check,
		 	  Finds the Bank Name disabled field that appears from the Bank Checker functionality.
		 	  Retrieves the value from that disabled field using getAttribute("value")
		 	 */
		 
		 	String BName = pageDirectDebitDetails.BankNameText.getAttribute("value");
		 	testBase.Wait(1);
		 	//Assert equal check that the bank name is passed into the function is the same as retrieved
		 	assertTrue("Banks are not equal", BName.contains(bankName));
		
		 	testBase.Wait(1);
		 	
	        return true;
	    }
	 
	 public boolean isCorrectBankAddress(String bankName){
	        	
		 	/*CL - Create BName variable for use in the below check,
		 	  Finds the Bank Name disabled field that appears from the Bank Checker functionality.
		 	  Retrieves the value from that disabled field using getAttribute("value")
		 	 */
		 
		 	String BAddress = pageDirectDebitDetails.BankAddress.getAttribute("value");

		 	//Assert equal check that the bank name that is passed into the function is the same as retrieved
		 	assertTrue("Banks Addresses are not equal", BAddress.contains(bankName));		 	
		 	testBase.Wait(1);
		 	
	        return true;
	    }
	 
	    public boolean waitForElement(){
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, testBase.getImpWaitTimeout());
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageDirectDebitDetails.bankNameID)));
	    	return true;
	    }
	    
	    public boolean isBranchEmpty(){
	    	
	    	String BAddress = pageDirectDebitDetails.BankAddress.getAttribute("value");
	    	
		 	assertTrue("Banks Addresses is not empty", BAddress.isEmpty());
		 	testBase.Wait(1);
		 	
	        return true;
	        
	    }


}
