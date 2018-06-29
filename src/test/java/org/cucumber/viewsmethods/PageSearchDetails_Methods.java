package org.cucumber.viewsmethods;

import static org.junit.Assert.assertTrue;

import uk.nhs.nhsbsa.config.env.TestBase;
import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;

public class PageSearchDetails_Methods extends TestBase {
	
    public boolean isCorrectPage(String expectedUrl){
        
    	String currentUrl = driver.getCurrentUrl();
	 	assertTrue("Not correct Page", currentUrl.contains(expectedUrl));
	 	Wait(1);	 	
        return true;
        
    }
    
	/**
	 * checks if an error message is present
	 * 
	 * @param errorMessage
	 * @return
	 */
	public Boolean CheckSearchErrorIsPresent(String errorMessage) {

		TestLogger.Check("looking for error message " + errorMessage);

		return super.isElementPresent(By.xpath("//ul[@id='pageErrors']//*[contains(text(), '"
						+ errorMessage + "')]"));
	}

}
