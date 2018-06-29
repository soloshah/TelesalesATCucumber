package org.cucumber.viewsmethods;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;
import org.cucumber.utils.TestLogger;
import org.cucumber.views.TelesalesBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PageCheckDetails_Methods implements BaseTest {
	
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
	
	TestBase testBase = new TestBase();
	
	public void ClickAmendDetails() {
		telesalesBasePage.ButtonBack.click();
	}

	public void ClickCancel() {
		telesalesBasePage.ButtonCancel.click();
	}
	
	 public boolean isCorrectSurname(String CorrectCost){
			//*[@id="container"]/form/table/tbody/tr[3]/td[1]/span
			 String locator = "//*[@id='container']/form/table/tbody/tr[3]/td[1]/span/text()[contains(.,'" + CorrectCost + "')]/..";
			 TestLogger.Info("Q" + testBase.isElementPresent(By.xpath(locator)));
			 return testBase.isElementPresent(By.xpath(locator));
		        
		    }
		
		 public boolean isCorrectCertNumber(String CorrectCost){
			//*[@id="container"]/form/table/tbody/tr[2]/td[3]/span
			 String locator = "//*[@id='container']/form/table/tbody/tr[2]/td[3]/span/text()[contains(.,'" + CorrectCost + "')]/..";
			 TestLogger.Info("Q" + testBase.isElementPresent(By.xpath(locator)));
			 return testBase.isElementPresent(By.xpath(locator));
		        
		    }
		 
		 public boolean isCorrectPaymentType(String CorrectCost){
			//*[@id="container"]/form/table/tbody/tr[8]/td[3]/span
				 String locator = "//*[@id='container']/form/table/tbody/tr[8]/td[3]/span/text()[contains(.,'" + CorrectCost + "')]/..";
				 TestLogger.Info("Q" + testBase.isElementPresent(By.xpath(locator)));
				 return testBase.isElementPresent(By.xpath(locator));
			        
			    }
		 
		 public boolean isCorrectPaymentAmount(String CorrectCost){
			//*[@id="container"]/form/table/tbody/tr[5]/td[3]/span
				 String locator = "//*[@id='container']/form/table/tbody/tr[5]/td[3]/span/text()[contains(.,'" + CorrectCost + "')]/..";
				 TestLogger.Info("Q" + testBase.isElementPresent(By.xpath(locator)));
				 return testBase.isElementPresent(By.xpath(locator));
			        
			    }	 
		 
		 public boolean isCorrectNotes(String CorrectCost){
			//*[@id="container"]/form/table/tbody/tr[14]/td[2]/span
					 String locator = "//*[@id='container']/form/table/tbody/tr[14]/td[2]/span/text()[contains(.,'" + CorrectCost + "')]/..";
					 TestLogger.Info("Q" + testBase.isElementPresent(By.xpath(locator)));
					 return testBase.isElementPresent(By.xpath(locator));
				        
		 		}
		 

}
