package org.cucumber.viewsmethods;

import static org.junit.Assert.assertTrue;
import uk.nhs.nhsbsa.config.env.TestBase;
import org.cucumber.utils.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PageSearchResults_Methods extends TestBase {
	
	TestBase testBase = new TestBase();
	
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
	
	/**
	 * checks you are on the page you expect to be on
	 */	
    public boolean isCorrectPage(String expectedUrl){
        
    	String currentUrl = driver.getCurrentUrl();
	 	assertTrue("Not correct Page", currentUrl.contains(expectedUrl));
	 	Wait(1);	 	
        return true;
        
    }
    
	/**
	 * checks you have the correct certificate number - must be the 1st entry on the list
	 */
	public boolean isCorrectCertificate(String certNumber) {

		String locator = "//*[@id='container']/table/tbody/tr/td[1]/a/strong[contains(.,'" + certNumber + "')]";
		assertTrue("Failed to find Certificate Number",isElementPresent(By.xpath(locator)));

		return true;

	}
	
	/**
	 * checks you have the correct DD Ref number
	 */
	public boolean isCorrectDDRef(String DDRef) {

		String locator = "//*[@id='container']/table/tbody/tr/td[1]/a/strong[contains(.,'" + DDRef + "')]";
		assertTrue("Failed to find Certificate Number",super.isElementPresent(By.xpath(locator)));

		return true;
		
	}
	
	/**
	 * counts how many certificates are found
	 */
	public int countCertificatesFound() {

		String locator = ".//*[@id='container']/table/tbody/tr";
		
		int totalCertificates =  driver.findElements(By.xpath(locator)).size();
		System.out.println("total cert no:" + totalCertificates);
		
		return totalCertificates;

	}
	
	/**
	 * checks if an error message is present
	 * 
	 * @param errorMessage
	 * @return
	 */
	public Boolean CheckSearchErrorIsPresent(String errorMessage) {

		TestLogger.Check("looking for error message " + errorMessage);
		
		String locator = "//*[@id='container']/form/span/b";

		return super.isElementPresent(By.xpath("//*[@id='container']//*[contains(text(),'mpt')]"));
		
	}

}
