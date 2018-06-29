package org.cucumber.viewsmethods;

import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.utils.Database;
import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

import org.cucumber.views.PageCertificateDetails;
import org.cucumber.views.TelesalesBasePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;

public class PageCertificateDetails_Methods extends TestBase {
	
	PageCertificateDetails pageCertificateDetails = PageFactory.initElements(driver, PageCertificateDetails.class);
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
	
	TestBase testBase = new TestBase();
	
	
//	public boolean isElementPresent(By by) {
//
//		try {
//
//			TestLogger.Info("looking for element " + by);
//
//			driver.findElement(by);
//
//			return true;
//
//		} catch (NoSuchElementException ex) {
//
//			TestLogger.Error("could not find element " + by, ex);
//
//			return false;
//		}
//	}
//	
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
    
    
	
	public void SetCertificateStart(Certificate certificate) {
		pageCertificateDetails.InputCertificateStart.clear();
		pageCertificateDetails.InputCertificateStart.sendKeys(certificate.CertificateStart);
	}

	public void SetCertificateNotes(Certificate certificate) {
		pageCertificateDetails.InputCertificateNotes.clear();
		pageCertificateDetails.InputCertificateNotes.sendKeys(certificate.CertificateNotes);
	}
	
	public void ClickBack() {
		telesalesBasePage.ButtonBack.click();
	}

	public void ClickSubmit() {
		telesalesBasePage.ButtonSubmit.click();
	}

	public void ClickCancel() {
		telesalesBasePage.ButtonCancel.click();
	}
	
	 public boolean isCorrectCertNumber(String certNumber){
		 
		 //String locator = "//*[@id='certNumber']/text()[contains(.,'" + certNumber + "')]/..";
		 //return isElementPresent(By.xpath(locator));
		 
		 String certNum = driver.findElement(By.id(".//*[@id='certNumber']")).getText();
	  		System.out.println("cert no:" + certNum);

	  		assertEquals("Failed to find Certificate Number", certNumber,certNum); 
	  		
	  		return true;
	  		
	        
	    }
	 
	 public boolean isCorrectCertStatus(String certStatus){
		 
		 String locator = ".//*[@id='certDetails']/div/div[2]/div[3]/p";
		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectDDRef(String DDRef){
		 String locator = "//*[@id='directDebitDetails']/div/div[2]/div[1]/p/text()[contains(.,'" + DDRef + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectDDDueDay(String DDDueDay){
		 String locator = "//*[@id='directDebitDetails']/div/div[2]/div[2]/p/text()[contains(.,'" + DDDueDay + "')]/..";
		 
		 String t = driver.findElement(By.xpath(locator)).getText();
		 TestLogger.Info("************** DD Due Date:" + t);
		 
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectPaymentType(String PaymentType){
		 String locator = "//*[@id='ppcPayments']/tbody/tr/td[2]/text()[contains(.,'" + PaymentType + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }  

	 public boolean isCorrectPaymentAmount(String PaymentAmount){
		 String locator = "//*[@id='ppcPayments']/tbody/tr/td[3]/text()[contains(.,'" + PaymentAmount + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }

	 public boolean isCorrectPaymentStatus(String PaymentStatus){
		 String locator = "//*[@id='ppcPayments']/tbody/tr/td[4]/text()[contains(.,'" + PaymentStatus + "')]/..";
		 //TestLogger.Info("Q" + super.isElementPresent(By.xpath(locator)));
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectCost(String CorrectCost){
		//*[@id="certificateTotalCost"]     
		 String locator = "//*[@id='certificateTotalCost']/text()[contains(.,'" + CorrectCost + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectCertCost(String CorrectCost){
		//*[@id="ppc12months"]
		 String locator = "//*[@id='ppc12months']/text()[contains(.,'" + CorrectCost + "')]/..";
		 //TestLogger.Info("Q" + super.isElementPresent(By.xpath(locator)));
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isPreviousExpiryDateCorrect(String CorrectCost){
		//*[@id="container"]/form/div[4]/div[2]
		 String locator = "//*[@id='container']/form/div[4]/div[2]/text()[contains(.,'" + CorrectCost + "')]/..";
		 //TestLogger.Info("Q" + super.isElementPresent(By.xpath(locator)));
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectTotal(String CorrectTotal){
		 //*[@id="container"]/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]
		 String locator = "//*[@id='container']/form/div[1]/div[1]/div[2]/div[3]/div/div[2]/span[1]/text()[contains(.,'" + CorrectTotal + "')]/..";
		 //TestLogger.Info("Q" + super.isElementPresent(By.xpath(locator)));
	 
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isTotalEmpty(){
		 //*[@id="container"]/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]
		 String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]";
		 String element = driver.findElement(By.xpath(locator)).getText();
		 //TestLogger.Info("Q" + element);
		 Assert.assertTrue("Failed to validate an empty branch",element.isEmpty());
		 
		 return true;
	        
	    }	 
	 
	 public boolean isCorrectOutstandingBalance(String OutstandingBalance){
		//*[@id="container"]/form/div[1]/div[1]/div[3]/div[3]/div/div[3]/span
		 String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[3]/span/text()[contains(.,'" + OutstandingBalance + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }

	 public boolean isCorrectSurname(String Surname){
		//*[@id="holderSurname"]
		 String locator = "//*[@id='holderSurname']/text()[contains(.,'" + Surname + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }

	 public boolean isCorrectAddressLine1(String AddressLine1){
		//*[@id="contactDetails"]/div/div[2]/ng-form/fieldset/div[4]/p
		 String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[4]/p/text()[contains(.,'" + AddressLine1 + "')]/..";
		 return isElementPresent(By.xpath(locator));
	        
	    }
	 
	 public boolean isCorrectEmail(String email){
		//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div/p[@class = 'ng-binding']/text()
		 String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div/p[@class = 'ng-binding']/text()/..";
		 TestLogger.Info("Q" + isElementPresent(By.xpath(locator)));		 
		 return isElementPresent(By.xpath(locator));
	 	} 

	 public boolean isEmailEmpty(){	 
		 //*[@id="contactDetails"]/div/div[2]/ng-form/fieldset/div[9]/p
		 String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[contains(.,'Email')]/p";
		 String element = driver.findElement(By.xpath(locator)).getText();
		 TestLogger.Info("Q" + element);
		 Assert.assertTrue("Failed to validate an empty Email",element.isEmpty());
		 
		 return true;
	 }
	    
	 public boolean isCorrectNotes(String notes){
		 //when no notes i.e. it says No notes available for this certificate case    //*[@id="container"]/form/div[1]/div[2]/div[2]/div[2]/div
		// when notes //*[@id="container"]/form/div[1]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td
		 
		 String locator = "";
		 
		 if (notes.contains("No notes available for this certificate case")) {
			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/text()[contains(.,'" + notes + "')]/..";
		 } else {
			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td/text()[contains(.,'" + notes + "')]/..";
		 }
		 
		 //TestLogger.Info("QQ" + super.isElementPresent(By.xpath(locator)));
		 return isElementPresent(By.xpath(locator));    
		//*[@id="container"]/form/div[1]/div[2]/div[2]/div[2]/div
	    }  

     public void deletePayment(java.sql.Connection ppcConn, String certNumber, double payAmount){
    	 
    	 int payCount = 0;
          
          try {
				payCount = Database.getPaymentCount(ppcConn,certNumber,payAmount);
			} catch (Exception e1) {
				assertTrue("Failed to delete the payments " + e1, false);
			}
          
          if (payCount > 0) {
         	 
         	 try {
         		 Database.deletePayment(ppcConn,certNumber,payAmount);
         	 } catch (Exception e) {
         		 assertTrue("Failed to delete the payments " + e, false);
         	 }
          }
     }
     
 	public static void deleteEmail(java.sql.Connection ppcConn, String certNumber, String email) throws Exception {
	 
 		int emailCount = 0;
 		
        try {
				emailCount = Database.getEmailCount(ppcConn,certNumber,email);
			} catch (Exception e1) {
				assertTrue("Failed to delete the email " + e1, false);
			}
        
        if (emailCount > 0) {
       	 
       	 try {
       		 Database.deleteEmail(ppcConn,certNumber,email);
       	 } catch (Exception e) {
       		 assertTrue("Failed to delete the email " + e, false);
       	 }
        }
 		
 	}
 	

}
