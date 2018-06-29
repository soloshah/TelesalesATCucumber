package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDirectDebitConfirmation {
	
	 @FindBy(xpath = "//input[@id='submitButton']")
	    private WebElement ButtonSubmitI;
	    
//	    public void CheckSortCode(String expectedSortCode){
//	        
//	        driver.findElement(By.xpath("")).getAttribute("text");
//	    }
	    
//	    public boolean CheckAccountNumber(String expectedAccountNumber){
//	        //TODO implement the locators needed for this
//	        return true;
//	    }
	    
	    public void ClickSubmit(){
	        ButtonSubmitI.click();
	    }
	    
//		 public boolean isCorrectSortCode(String sortCode){	
//		 
//			 String locator = "//*[@id='container']/form/table/tbody/tr[2]/td[3]/span/text()[contains(.,'" + sortCode + "')]/..";
//		        return super.isElementPresent(By.xpath(locator));		 
//		        
//		    }
//		 
//		 public boolean isCorrectAccountCode(String accountNumber){
//		        
//		        String locator = "//*[@id='container']/form/table/tbody/tr[3]/td[3]/span/text()[contains(.,'" + accountNumber + "')]/..";
//		        return super.isElementVisible(By.xpath(locator));
//		    }

}
