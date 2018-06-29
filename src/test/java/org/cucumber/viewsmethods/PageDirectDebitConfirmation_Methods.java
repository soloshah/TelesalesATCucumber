package org.cucumber.viewsmethods;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PageDirectDebitConfirmation_Methods implements BaseTest {
	
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
    
    
    
	public boolean isElementVisible(By by) {

		TestLogger.Info("looking for element " + by);

		if (driver.findElement(by).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}
	
    
	
    public void CheckSortCode(String expectedSortCode){
        
        driver.findElement(By.xpath("")).getAttribute("text");
    }
    
    public boolean CheckAccountNumber(String expectedAccountNumber){
        //TODO implement the locators needed for this
        return true;
    }
    
	 public boolean isCorrectSortCode(String sortCode){	
		 
		 String locator = "//*[@id='container']/form/table/tbody/tr[2]/td[3]/span/text()[contains(.,'" + sortCode + "')]/..";
	        return isElementPresent(By.xpath(locator));	 
	        
	    }
	 
	 public boolean isCorrectAccountCode(String accountNumber){
	        
	        String locator = "//*[@id='container']/form/table/tbody/tr[3]/td[3]/span/text()[contains(.,'" + accountNumber + "')]/..";
	        return isElementVisible(By.xpath(locator));
	    }

}
