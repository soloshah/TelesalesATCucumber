package uk.nhs.nhsbsa.steps;

import org.cucumber.ppctelesales.helper.TelesalesDataHelper;
import org.cucumber.views.PagePaymentCardDetails;
import org.cucumber.views.PageSearchDetails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.EnvConfig;
import uk.nhs.nhsbsa.helpers.GenericData;
import uk.nhs.nhsbsa.pages.MainPage;

public class MainPageSteps implements BaseTest
{
	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
	
    PageSearchDetails pageSearchDetails = PageFactory.initElements(driver, PageSearchDetails.class);
    PagePaymentCardDetails pagePaymentCardDetails = PageFactory.initElements(driver, PagePaymentCardDetails.class);
    
    uk.nhs.nhsbsa.config.env.TestBase TestBase;
    
	private PredefinedStepDefinitions predefinedSteps = new PredefinedStepDefinitions();
	
	   @Given("^I open the homepage$")
	    public void openHomepage() {
	    	
	    	String run_env = EnvConfig.getTestEnvironment();
		  	System.out.println("run env: " + run_env);
		  	
		  	switch (run_env){ 
		     case "sys":
		    	 driver.get(GenericData.HOMEPAGE_LINK_SYS);
			  	 driver.findElement(By.id("fusername")).sendKeys("shabh");
			  	 driver.findElement(By.id("fpassword")).sendKeys("Telesales7");
			  	 driver.findElement(By.xpath("html/body/div[2]/div/form/table/tbody/tr[3]/td/input")).click();
		        break;
		    case "cloud":
		    	driver.get(GenericData.HOMEPAGE_LINK_CLOUD);
	 	        break;
		     default: System.out.println("unknown button...");
		    }
		  	
	    }
	    
	    
	    
	    @Given("^I enter \"(.*)\" and \"(.*)\"$")
	    public void enterusernamepassword(String username, String pwd) {
	    	
	    	driver.findElement(By.id("fusername")).sendKeys(username);
	    	
	    	driver.findElement(By.id("fpassword")).sendKeys(pwd);
	    	
	    }
	    
	    
	    
	    
	    
	    @Given("^I enter '(.+)' and '(.+)'$")
	    public void enterusernamepwd(String username, String pwd) {
	    	
	    	driver.findElement(By.id("fusername")).sendKeys(username);
	    	
	    	driver.findElement(By.id("fpassword")).sendKeys(pwd);
	    	
	    }
	    
    @Given("^I click the button \"(.*)\"$")
    public void clickButton(String btnName) throws InterruptedException {
    	
    	try {
    		
    		switch (btnName){ 
     	     case "login":
     	    	driver.findElement(By.xpath("html/body/div[2]/div/form/table/tbody/tr[3]/td/input")).click();
     	        break;
     	    case "submit":
      	    	driver.findElement(By.id("submit")).click();
      	        break;
     	    case "back":
     	    	pagePaymentCardDetails.ClickBack();
     	    	break;
     	     case "logout":
     	    	driver.findElement(By.xpath(".//*[@id='content']/div/a/i")).click();
     	        break;
     	     default: System.out.println("unknown button...");
     	    }
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    @Then("^I enter '(.+)' cert num$")
    public void enterusernamepwd(String certnum) {
    	
    	driver.findElement(By.className("searchCertificateNumber")).sendKeys(certnum);
    	
    }
    
    
    
//  	@When("^I send search details and click submit$")
//    public void enterSearchDetails() {  		
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
//        pageSearchDetails.ClickSubmit();
//  	}
    
    
//  	@Then("^I will get error message as '(.+)' with '(.+)'$")
//	public void get_error_message(String error_Message, String id)
//	{
//  		String err_msg = null;
//  		
//  		err_msg = driver.findElement(By.xpath(id)).getText();
//  		Assert.assertEquals(error_Message, err_msg);
//
//	}
//  	
    
  	
  	
  	
    
    
    
    
	
	@Given("^I am on the nhsbsa homepage$")
	public void i_am_on_the_nhsbsa_homepage() throws Throwable {
		driver.get(GenericData.HOMEPAGE_LINK_SYS);
		mainPage.verifyPageLoaded();
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
	    mainPage.searchFor(arg1);
	}

	@Then("^I should see the search results page with \"([^\"]*)\" displayed$")
	public void i_should_see_the_search_results_page_with_displayed(String arg1) throws Throwable {
	    mainPage.assertSearchPageResults(arg1);
	}
	
	@When("^I search nhsbsa site for \"([^\"]*)\"$")
	public void i_search_nhsbsa_site_for(String arg1) throws Throwable {
		predefinedSteps.enter_text(arg1, "id", "edit-aggregated-field");
		predefinedSteps.click("id", "edit-submit-search");
	}

	@Then("^I should see the nhsbsa search results page with \"([^\"]*)\" displayed$")
	public void i_should_see_the_nhsbsa_search_results_page_with_displayed(String arg1) throws Throwable {
		assertionObj.checkElementText("class", arg1, "search-listing-tags", true);
	}
}
