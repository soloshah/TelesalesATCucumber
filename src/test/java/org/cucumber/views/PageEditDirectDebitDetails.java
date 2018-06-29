package org.cucumber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;	

public class PageEditDirectDebitDetails {
	
	@FindBy(xpath = "//input[@id='submit']")
	public WebElement ButtonSubmitI;
    
	@FindBy(xpath = "//*[@id='container']/div/div[1]/div/form/div[1]/div[2]/div/p/input")
	private WebElement InputDueDay;
    
    public void ClickSubmit(){
        ButtonSubmitI.click();
    }
    
    public void setDueDay(String dueDay){
		InputDueDay.clear();
		InputDueDay.sendKeys(dueDay);
    }
    
    public int getDueDay(){
		String existingDueDay = InputDueDay.getAttribute("ng-init");
		String newDueDay = existingDueDay.replace("dueDay=", "");
		int dueDay = 0;
		
		try {
			dueDay = Integer.parseInt(newDueDay);
		} catch (NumberFormatException e) {
			assertTrue("Converting the due date to an integer failed (value is " + existingDueDay + ")", true);
		}
		
		return dueDay;
    }
    
//	public boolean isDueDayErrorPresent() {
//
//		String errorText = null;
//		String locator = null;
//		
//		errorText = "Due day cannot be within 10 working days of today";
//		locator = "//*[@id='container']/div/div[1]/div/form/div[1]/div[3]/div[5][contains(text(),'"+ errorText + "')]";
//	//	TestLogger.Info("QQ " + super.isElementVisible(By.xpath(locator)));
//		return super.isElementVisible(By.xpath(locator));
//		
//	}

}
