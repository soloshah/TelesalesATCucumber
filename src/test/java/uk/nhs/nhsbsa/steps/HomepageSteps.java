package uk.nhs.nhsbsa.steps;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.EnvConfig;
import uk.nhs.nhsbsa.config.env.TestBase;
import uk.nhs.nhsbsa.helpers.GenericData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.cucumber.ppctelesales.helper.TelesalesDataHelper;
import org.cucumber.ppctelesales.model.Account;
import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.ppctelesales.model.Search;

import org.cucumber.utils.TestLogger;
import org.cucumber.utils.Utilities;
import org.cucumber.views.ExamplePage;
import org.cucumber.views.PageApplicantDetails;
import org.cucumber.views.PageCertificateDetails;
import org.cucumber.views.PageCheckDetails;
import org.cucumber.views.PageConfirmDirectDebit;
import org.cucumber.views.PageDirectDebitConfirmation;
import org.cucumber.views.PageDirectDebitDetails;
import org.cucumber.views.PageDirectDebitDetails.AccountError;
import org.cucumber.views.PageEditDirectDebitDetails;
import org.cucumber.views.PageEditExemption;
import org.cucumber.views.PagePaymentCardDetails;
import org.cucumber.views.PageRefundDetails;
import org.cucumber.views.PageSearchDetails;
import org.cucumber.views.PageSearchResults;
import org.cucumber.views.TelesalesBasePage;
import org.cucumber.viewsmethods.PageApplicantDetails_Methods;
import org.cucumber.viewsmethods.PageCertificateDetails_Methods;
import org.cucumber.viewsmethods.PageConfirmDirectDebit_Methods;
import org.cucumber.viewsmethods.PageDirectDebitConfirmation_Methods;
import org.cucumber.viewsmethods.PageDirectDebitDetails_Methods;
import org.cucumber.viewsmethods.PageEditDirectDebitDetails_Methods;
import org.cucumber.viewsmethods.PageEditExemption_Methods;
import org.cucumber.viewsmethods.PageRefundDetails_Methods;
import org.cucumber.viewsmethods.PageSearchResults_Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageSteps /* extends TestBase */ implements BaseTest {

    ExamplePage examplePage = PageFactory.initElements(driver, ExamplePage.class);
    
    PageSearchDetails pageSearchDetails = PageFactory.initElements(driver, PageSearchDetails.class);
    PageSearchResults pageSearchResults = PageFactory.initElements(driver, PageSearchResults.class);
	PageApplicantDetails pageApplicantDetails = PageFactory.initElements(driver, PageApplicantDetails.class);
	PageEditExemption pageEditExemption = PageFactory.initElements(driver, PageEditExemption.class);
	PageCertificateDetails pageCertificateDetails = PageFactory.initElements(driver, PageCertificateDetails.class);
	PageDirectDebitDetails pageDirectDebitDetails = PageFactory.initElements(driver, PageDirectDebitDetails.class);
	PageDirectDebitConfirmation pageDirectDebitConfirmation = PageFactory.initElements(driver, PageDirectDebitConfirmation.class);
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
	PageConfirmDirectDebit pageConfirmDirectDebit = PageFactory.initElements(driver, PageConfirmDirectDebit.class);
	PageEditDirectDebitDetails pageEditDirectDebitDetails = PageFactory.initElements(driver, PageEditDirectDebitDetails.class);
	PageCheckDetails pageCheckDetails = PageFactory.initElements(driver, PageCheckDetails.class);
	PagePaymentCardDetails pagePaymentCardDetails = PageFactory.initElements(driver, PagePaymentCardDetails.class);
	PageRefundDetails pageRefundDetails = PageFactory.initElements(driver, PageRefundDetails.class);	
	
	PageSearchResults_Methods pageSearchResults_Methods = new PageSearchResults_Methods();
	PageApplicantDetails_Methods pageApplicantDetails_Methods = new PageApplicantDetails_Methods();
	PageEditExemption_Methods pageEditExemption_Methods = new PageEditExemption_Methods();
	PageDirectDebitDetails_Methods pageDirectDebitDetails_Methods = new PageDirectDebitDetails_Methods();
	PageCertificateDetails_Methods pageCertificateDetails_Methods = new PageCertificateDetails_Methods();
	PageDirectDebitConfirmation_Methods pageDirectDebitConfirmation_Methods = new PageDirectDebitConfirmation_Methods();
	PageConfirmDirectDebit_Methods pageConfirmDirectDebit_Methods = new PageConfirmDirectDebit_Methods();
	PageEditDirectDebitDetails_Methods pageEditDirectDebitDetails_Methods = new PageEditDirectDebitDetails_Methods();
	PageRefundDetails_Methods pageRefundDetails_Methods = new PageRefundDetails_Methods();
	
    Search search = new Search();
    
    TestBase testBase = new TestBase();

//	private PageRefundDetails pageRefundDetails;
    
    static TelesalesAdapterSteps ppcts;

    public static String landingPageURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/go.do";
    public static String searchCertNumberURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/search.do?certNumber=10000000003";
    public static String searchCertNumberResultsURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/search.do";
    public static String applicantDetailsURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/newApplication.do";
    public static String directDebitPaymentDetailsURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/ppcTelesalesFormSubmitActionApplicant.do";
    public static String directDebitConfirmationsURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/ppcTelesalesFormSubmitDirectDebit.do";
    public static String confirmDirectDebitURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/confirmDirectDebit.do";
    public static String checkDetailsURL = "http://dev-ppc-telesales00.node.consul:8081/ppc_telesales_webapp/ppcTelesalesFormSubmitActionPayment.do";
    
    
    public static String landingPageURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/sessionTimeout.do";
    public static String searchCertNumberURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/search.do?certNumber=10000000003";
    public static String searchCertNumberResultsURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/ppc_telesales_webapp/search.do";
    public static String applicantDetailsURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/newApplication.do";
    public static String directDebitPaymentDetailsURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/ppcTelesalesFormSubmitActionApplicant.do";
    public static String directDebitConfirmationsURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/ppcTelesalesFormSubmitDirectDebit.do";
    public static String confirmDirectDebitURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/confirmDirectDebit.do";
    public static String checkDetailsURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/ppcTelesalesFormSubmitActionPayment.do";
    public static String editExemptionURL_Sys = "http://fi2.ppa.nhs.uk/PPCSYST/ppc_telesales_webapp/editExemption.do";
    
    
    @Given("^I press the More information link$")
    public void pressMoreInformationLink() {
        examplePage.getMoreInformationLink().click();
    }

//    @Given("^I open the homepage$")
//    public void openHomepage() {
//        driver.get(GenericData.HOMEPAGE_LINK);
//    }
  	
  	
    @Then("^I see windows login authentication")
	public void windows_login_authentication()
	{
  		System.out.println("Windows login authentication pop up");
	}
  	
  	@When("^I click \"(.*)\"$")
    public void click_button(String item) {
  		
  		switch (item){
  	      case "Submit":
  	    	driver.findElement(By.id("submit")).click();
  	        break;
  	      case "Cancel":
  	    	driver.findElement(By.id("cancellink")).click();
  	        break;
  	      case "Cancel Button":
    	    driver.findElement(By.id("cancelLink")).click();
    	    break;
  	      case "Edit Button":
    	    driver.findElement(By.id("editBtn")).click();
    	    break;  
  	      case "Save Button":
    	    driver.findElement(By.id("submitLink")).click();
    	    break;  
  	      case "Reissue Button":
  	    	driver.findElement(By.id("reissueLink")).click();
  	        break;  
  	      case "Renew Button":
  	    	driver.findElement(By.id("renewLink")).click();
  	        break;    	        
 	        
  	     default: System.out.println("unknown button");
  	    }
    }
  	
  	@When("^I click the reissue button on the edit exemption page$")
  	public void clickReissue(){
  		       
		pageEditExemption.ReissueButton.click();
  	}
  	
  	@When("^I click the issue button on the edit exemption page$")
  	public void clickIssue(){
  		       
		pageEditExemption.IssueButton.click();
  	}
  	
  	@Then("^I will get error message as '(.+)' with '(.+)'$")
	public void get_error_message(String error_Message, String id)
	{
  		String err_msg = null;
  		
  		err_msg = driver.findElement(By.xpath(id)).getText();
  		Assert.assertEquals(error_Message, err_msg);

	}
  	
  	@Then("^I verify the url for landing page$")
    public boolean landingPageVerifyUrl(){
        
  		String run_env = EnvConfig.getTestEnvironment();
  		System.out.println("run env: " + run_env);
  		
  		if (run_env == "sys") {
    	String currentUrl = driver.getCurrentUrl();
	 	assertTrue("Failed to show landing page", currentUrl.contains(landingPageURL_Sys));
  		}
  		
  		if (run_env == "cloud") {
  	    	String currentUrl = driver.getCurrentUrl();
  		 	assertTrue("Failed to show landing page", currentUrl.contains(landingPageURL));
  	  	}
  		  		
	 	testBase.Wait(1);	 	
        return true;
    }
  	
  	
  	@When("^I log into the system$")
    public void logIntoSystem() {
        
  		System.out.println("Log into the system successful...");
  	}
  	
  	@When("^I send search details and click submit$")
    public void enterSearchDetails() {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
        pageSearchDetails.ClickSubmit();
  	}
  	
  	
  	@When("^I send cert num '(.+)' and click submit$")
    public void sendCertNum(String certNo) {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterCertNum(certNo));
        pageSearchDetails.ClickSubmit();
  	}
  	 	
  	@When("^I send dd ref '(.+)' and click submit$")
    public void sendDDRef(String ddref) {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterDDRef(ddref));
        pageSearchDetails.ClickSubmit();
  	} 	
  	
  	@When("^I send surname '(.+)' and dob '(.+)' and click submit$")
    public void sendSurnameDOB(String surname, String dob) {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterSurnameAndDOB(surname, dob));
        pageSearchDetails.ClickSubmit();
  	}
  	
  	@When("^I send email address '(.+)' and click submit$")
    public void sendEmailAddress(String emailaddress) {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterEmailAddress(emailaddress));
        pageSearchDetails.ClickSubmit();
  	}
  	
  	@When("^I send nhs number '(.+)' and click submit$")
    public void sendNhsNumber(String nhsnumber) {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterNhsNumber(nhsnumber));
        pageSearchDetails.ClickSubmit();
  	}
  	
  	@When("^I send search with non england postcode details$")
    public void enterSearchNonEnglandPostcodeDetails() throws InterruptedException {
        
        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
        
        //waitForElement("//*[@id='postcodeField']");
		
		Search duffPostcodeSearch = TelesalesDataHelper.getSearch();
        
        duffPostcodeSearch.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.Scotland);
        
        pageSearchDetails.PopulateSearchCriteria(duffPostcodeSearch);
        
        pageSearchDetails.ClickSubmit();
        
        Thread.sleep(10);
        
  	}
  	
  	@And("^I send email address '(.+)' and notes '(.+)'$")
	public void enterEmailAddressNotes(String notes, String emailaddress) {
  			   
  	    pageEditExemption.PopulateEditExemption(TelesalesDataHelper.enterEmailAddressNotes(emailaddress, notes));
  		testBase.Wait(2);

	}
  	  	
  	
  	@When("^I click certificate number '(.+)' on search results page$")
    public void clickCertNumberSearchDetails(String cert_num) throws InterruptedException {
       
  		//pageSearchResults.ClickCertNumber(1);
  		
  		driver.findElement(By.partialLinkText(cert_num)).click();
  		testBase.Wait(3);
  		
  	}
  	
  	
  	@When("^I verify certificate number '(.+)' on search results page$")
    public void verifyCertNumberSearchDetails(String certNumber) {
       
  		String certNum = driver.findElement(By.partialLinkText(certNumber)).getText();
  		System.out.println("cert no:" + certNum);

  		assertEquals("Failed to find Certificate Number", certNumber,certNum); 
  		testBase.Wait(3);
  	}
  	
  	@Then("^I am redirected to \"(.*)\" page with url \"(.*)\"$")
    public void CheckUrl(String link, String urlExpected) 
  	{
  		testBase.Wait(1);
  		String urlActual = null;
  		urlActual = driver.getCurrentUrl();
  		testBase.Wait(1);
  		
  		switch (link){
 	     case "search results":
 	    	testBase.Wait(1);
 	     	Assert.assertEquals(urlExpected, urlActual );
 	        break;
 	     case "applicant details":
 	    	testBase.Wait(1);
 	    	Assert.assertEquals(urlExpected, urlActual );
 	     case "direct debit payment details":
 	    	testBase.Wait(1);
 	    	Assert.assertEquals(urlExpected, urlActual );
 	     default: System.out.println("unknown URL...");
 	    }  
  	}
  	
  	@Then("^I am redirected to \"(.*)\" page$")
    public void CheckPageUrl(String link) 
  	{
  		
	  	String run_env = EnvConfig.getTestEnvironment();
	  	System.out.println("run env: " + run_env);
	  		
  		testBase.Wait(1);
  		String urlActual = null;
  		urlActual = driver.getCurrentUrl();
  		testBase.Wait(1);
    	TestLogger.Info("urlActual is: " + urlActual);
  		
  		switch (link){
 	     case "search results":
 	    	testBase.Wait(1);
 	  		if (run_env == "sys") {
 	     	assertTrue("Failed to show search page", urlActual.contains(searchCertNumberURL_Sys));
 	  		}
 	  		if (run_env == "cloud") {
 	 	     	assertTrue("Failed to show search page", urlActual.contains(searchCertNumberURL));
 	 	  	}
 	        break;
 	     case "search cert number results":
 	    	testBase.Wait(1);
 	  		if (run_env == "sys") {
 	 	     	assertTrue("Failed to show search cert num results page", urlActual.contains(searchCertNumberResultsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + searchCertNumberResultsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show search cert num results page", urlActual.contains(searchCertNumberResultsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + searchCertNumberResultsURL);
 	 	 	  	}
 	        break;
 	     case "applicant details":
 	    	testBase.Wait(1);
 	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(applicantDetailsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + applicantDetailsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(applicantDetailsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + applicantDetailsURL);
 	 	 	  	}
 	    	break;
 	     case "direct debit payment details":
 	    	testBase.Wait(1);	    	
 	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(directDebitPaymentDetailsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(directDebitPaymentDetailsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL);
 	 	 	  	}
 	    	break;
 	    case "credit debit payment details":
 	    	testBase.Wait(1);
 	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(directDebitPaymentDetailsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(directDebitPaymentDetailsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL);
 	 	 	  	}
 	    	break;
 	   case "cheque payment details":
 		  testBase.Wait(1);
	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(directDebitPaymentDetailsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(directDebitPaymentDetailsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + directDebitPaymentDetailsURL);
 	 	 	  	}
	    	break;
 	    case "Direct Debit confirmation":
 	    	testBase.Wait(1);
 	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(directDebitConfirmationsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + directDebitConfirmationsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(directDebitConfirmationsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + directDebitConfirmationsURL);
 	 	 	  	}
 	    	break;
 	   case "confirm Direct Debit":
 		  testBase.Wait(1);
	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(confirmDirectDebitURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + confirmDirectDebitURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(confirmDirectDebitURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + confirmDirectDebitURL);
 	 	 	  	}
	    	break;
 	   case "check details":
 		  testBase.Wait(1);
	    	if (run_env == "sys") {
 	 	     	assertTrue("Failed to show applicant details page", urlActual.contains(checkDetailsURL_Sys));
 	 	     	TestLogger.Info("expectedUrl is: " + checkDetailsURL_Sys);
 	 	  		}
 	 	  		if (run_env == "cloud") {
 	 	 	     	assertTrue("Failed to show applicant details", urlActual.contains(checkDetailsURL));
 	 	 	     TestLogger.Info("expectedUrl is: " + checkDetailsURL);
 	 	 	  	}
	    	break;
 	     default: System.out.println("unknown URL...");
 	    }
  	
  	}
  	
  	
  	@Then("^I check that it is correct certificate as '(.+)' on search results page$")
    public boolean correctCertificate(String cert_number){
  		testBase.Wait(5);
//  		assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number));
  		testBase.Wait(10);	
  		
  		assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number)); 

  		
  		
        return true;
        
    }
  	
  	@Then("^I check that it is correct certificate as '(.+)' on certificate details page$")
    public void correctCertificateDetailsPage(String certNumber){
        
  		//assertTrue("Not the correct certificate number", pageCertificateDetails_Methods.isCorrectCertNumber(cert_number));
  		
  		String locator = "//*[@id='certNumber']/text()[contains(.,'" + certNumber + "')]/..";
		 String certNum = driver.findElement(By.xpath(locator)).getText();
	  	 assertEquals("Failed to find Certificate Number", certNumber,certNum); 
  		testBase.Wait(1);	
        
    }
  	
  	@Then("^I check that it is correct certificate type as '(.+)'$")
    public void correctCertificateType(String cert_type){
        
  		//assertTrue("Not the correct certificate status", pageCertificateDetails_Methods.isCorrectCertStatus(cert_status));
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[2]/p";
		 TestLogger.Info("Correct Cert Type: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate type", driver.findElement(By.xpath(locator)).getText(),cert_type); 
  		
        //return true;
        
    }
  	
  	@Then("^I check that it is correct certificate status as '(.+)'$")
    public void correctCertificateStatus(String cert_status){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = ".//*[@id='certDetails']/div/div[2]/div[3]/p";
		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate status", driver.findElement(By.xpath(locator)).getText(),cert_status); 
  		
        //return true;      
    }
  	
  	@Then("^I check action has been successfully performed as '(.+)'$")
    public void correctAction(String action){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='pageMessages']/li";
		 TestLogger.Info("Correct action: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct action", driver.findElement(By.xpath(locator)).getText(),action); 
  		
        //return true;
		 
    }
  	
  	@Then("^I check that it is correct certificate fulfilment as '(.+)'$")
    public void correctCertificateFulfilment(String cert_fulfilment){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[4]/p";
		 TestLogger.Info("Correct Cert Fulfilment: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate fulfilment", driver.findElement(By.xpath(locator)).getText(),cert_fulfilment); 
  		
        //return true;
        
    }
  	
  	@Then("^I check that it is correct certificate start as '(.+)'$")
    public void correctCertificateStart(String cert_start){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[5]/p";
		 TestLogger.Info("Correct Cert Start: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate start", driver.findElement(By.xpath(locator)).getText(),cert_start); 
  		
        //return true;
        
    }
  	
  	@Then("^I check that it is correct certificate expiry as '(.+)'$")
    public void correctCertificateExpiry(String cert_expiry){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[6]/p";
		 TestLogger.Info("Correct Cert Expiry: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate expiry", driver.findElement(By.xpath(locator)).getText(),cert_expiry); 
  		
        //return true;
        
    }
  	
  	@Then("^I check that it is correct certificate email address as '(.+)'$")
    public void correctEmailAddress(String email_address){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='personalDetails']/div[10]/div[2]/input";
		 TestLogger.Info("Correct Cert Email Address: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate email address", driver.findElement(By.xpath(locator)).getText(),email_address); 
  		
        //return true;
        
    }
  	 	
  	@Then("^I check that it is correct application date as '(.+)'$")
    public void correctApplicationDate(String app_date){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[7]/p";
		 TestLogger.Info("Correct Application Date: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct application date", driver.findElement(By.xpath(locator)).getText(),app_date); 
  		
        //return true;
        
    }
  	
  	@Then("^I check that it is correct hcp identifier as '(.+)'$")
    public void correctHCPIdentifier(String hcp_identifier){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='certDetails']/div/div[2]/div[8]/p";
		 TestLogger.Info("Correct HCP Identifier: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct certificate identifer", driver.findElement(By.xpath(locator)).getText(),hcp_identifier); 
  		
        //return true;
        
    }  
  	 	
  	@Then("^I check that it is correct ddref as '(.+)'$")
    public void correctDDRef(String DDRef){
        
  		//assertTrue("Not the correct DD reference", pageCertificateDetails_Methods.isCorrectDDRef(DDRef));
  		testBase.Wait(1);	
  		
  		
  		 String locator = "//*[@id='directDebitDetails']/div/div[2]/div[1]/p/text()[contains(.,'" + DDRef + "')]/..";
		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct DD reference", driver.findElement(By.xpath(locator)).getText(),DDRef);
        
    }
  	
  	@Then("^I check that it is correct due date as '(.+)'$")
    public void correctDDDueDate(String duedate){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='directDebitDetails']/div/div[2]/div[2]/p";
		 TestLogger.Info("Correct DD Due Date: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct DD Due Date", driver.findElement(By.xpath(locator)).getText(),duedate); 
  		
        //return true;      
    }
  	
  	@Then("^I check that it is correct payment type as '(.+)'$")
    public void correctPaymentType(String paymentType){
  		
  		testBase.Wait(2);
  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[2]/text()[contains(.,'" + paymentType + "')]/..";
  		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Failed to find Certificate Status", driver.findElement(By.xpath(locator)).getText(),paymentType);
		 
  		//assertTrue("Not the correct Payment type", pageCertificateDetails_Methods.isCorrectPaymentType(paymentType));
  		testBase.Wait(1);	 	

    }
  	
  	@Then("^I check that it is correct payment amount as '(.+)'$")
    public void correctPaymentAmount(String paymentAmount){
        
  		//assertTrue("Not the correct Payment amount", pageCertificateDetails_Methods.isCorrectPaymentAmount(paymentAmount));
  		
  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[3]/text()[contains(.,'" + paymentAmount + "')]/..";
 		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct Payment amount", driver.findElement(By.xpath(locator)).getText(),paymentAmount);
		 
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that it is correct payment status as '(.+)'$")
    public void correctPaymentStatus(String paymentStatus){
        
  		//assertTrue("Not the correct Payment Status", pageCertificateDetails_Methods.isCorrectPaymentStatus(paymentStatus));
  		
  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[4]/text()[contains(.,'" + paymentStatus + "')]/..";
  		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct Payment Status", driver.findElement(By.xpath(locator)).getText(),paymentStatus);
		 
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that it is correct cost as '(.+)'$")
    public void correctCost(String cost){
        
  		//assertTrue("Cost is not correct", pageCertificateDetails_Methods.isCorrectCost(cost));
  		
  		String locator = "//*[@id='certificateTotalCost']/text()[contains(.,'" + cost + "')]/..";
 		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Cost is not correct", driver.findElement(By.xpath(locator)).getText(),cost);
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check total is empty$")
    public void totalEmpty(){
        
  		//assertTrue("Total is not correct", pageCertificateDetails_Methods.isTotalEmpty());
  	
  		String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]";
		 String element = driver.findElement(By.xpath(locator)).getText();
		 //TestLogger.Info("Q" + element);
		 Assert.assertTrue("Total is not correct",element.isEmpty());
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that it is correct outstanding balance as '(.+)'$")
    public void correctOutstandingBalance(String outstandingBalance){
        
  		//assertTrue("Outstanding balance is not correct", pageCertificateDetails_Methods.isCorrectOutstandingBalance(outstandingBalance));
  		
  		 String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[3]/span/text()[contains(.,'" + outstandingBalance + "')]/..";
  		assertEquals("Outstanding balance is not correct", driver.findElement(By.xpath(locator)).getText(),outstandingBalance);
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that it is correct total as '(.+)'$")
    public void correctTotal(String total){
        
  		//assertTrue("Surname is not correct", pageCertificateDetails_Methods.isCorrectTotal(total));
  	  		
  		String locator = "//*[@id='container']/form/div[1]/div[1]/div[2]/div[3]/div/div[2]/span[1]/text()[contains(.,'" + total + "')]/..";
  		assertEquals("correct Total is not correct", driver.findElement(By.xpath(locator)).getText(),total);
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that it is correct surname as '(.+)'$")
    public void correctSurname(String surname){
        
  		//assertTrue("Surname is not correct", pageCertificateDetails_Methods.isCorrectSurname(surname));
  		
  		String locator = "//*[@id='holderSurname']/text()[contains(.,'" + surname + "')]/..";
  		assertEquals("Surname is not correct", driver.findElement(By.xpath(locator)).getText(),surname);
  		testBase.Wait(1);	 	

    }
  	
  	@Then("^I check that it is correct address line1 as '(.+)'$")
    public void correctAddressLine1(String addressline1){
        
  		//assertTrue("Address line1 is not correct", pageCertificateDetails_Methods.isCorrectAddressLine1(addressline1));
  		
  		String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[4]/p/text()[contains(.,'" + addressline1 + "')]/..";
  		assertEquals("Address line1 is not correct", driver.findElement(By.xpath(locator)).getText(),addressline1);
  		testBase.Wait(1);	 	
        
    }
  	
  	@Then("^I check that email is empty$")
    public void emailEmpty(){
        
  		//assertTrue("Email should be blank", pageCertificateDetails_Methods.isEmailEmpty());
  		
  		String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[contains(.,'Email')]/p";
  		 String element = driver.findElement(By.xpath(locator)).getText();
  		Assert.assertTrue("Email should be blank",element.isEmpty());
  		testBase.Wait(1);	 	
 
    }
  	 	 	
  	@Then("^I check that it is correct notes as '(.+)'$")
    public void correctNotes(String notes){
        
  		//assertTrue("There should be no notes", pageCertificateDetails_Methods.isCorrectNotes(notes));
  		
  		String locator = "";
		 
		 if (notes.contains("No notes available for this certificate case")) {
			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/text()[contains(.,'" + notes + "')]/..";
		 } else {
			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td/text()[contains(.,'" + notes + "')]/..";
		 }
		 
		 assertEquals("There should be no notes", driver.findElement(By.xpath(locator)).getText(),notes);
  		testBase.Wait(1);	 	
        
    }
  	
  	
  	@Then("^I check that search error is present as '(.+)'$")
    public void searchErrorIsPresent(String err_msg){
        
  		//assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.CheckSearchErrorIsPresent(err_msg));
  		
  		String locator = "//*[@id='container']/form/span/b";
  		 assertEquals("There should be no notes", driver.findElement(By.xpath(locator)).getText(),err_msg);
  		testBase.Wait(1);	 	
        
    }
  	
  	@When("^I should list several entries for this number as '(.+)' and '(.+)'$")
    public void listCountCertificatesFound(String cert_number, int expectedCount) {
        
  		//assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number));
  		testBase.Wait(1);
//        int certCount = pageSearchResults_Methods.countCertificatesFound();
//        assertTrue("Number of entries dont match",certCount == expectedCount);
        
        
        String locator = ".//*[@id='container']/table/tbody/tr";
		int totalCertificates =  driver.findElements(By.xpath(locator)).size();
		System.out.println("total cert no:" + totalCertificates);
		
		assertTrue("Number of entries dont match",totalCertificates == expectedCount);
  	}
  	
  	
  	@When("^I click new application$")
    public void newApplication() {
        
        pageSearchResults.ClickNewApplication();
  	}
  	
  	
  	@When("^I click new application on page certificate details$")
    public void newApplicationonPageCertificateDetails() {
        
  		pageCertificateDetails.ClickNewApplication();
  	}
  	
  	
  	@And("^I send applicant details$")
	public void enterApplicantDetails() throws InterruptedException {
  		
  		Applicant app = TelesalesDataHelper.getApplicant();

      pageApplicantDetails_Methods.PopulateAddressDetails(app);

  		Thread.sleep(1000);
  		
//  		driver.findElement(By.name("notes")).clear();
//  		driver.findElement(By.name("notes")).sendKeys("asdfdsdsf");
  		
  		
  		pageApplicantDetails_Methods.PopulatePersonalDetails(app);
  		
  		Thread.sleep(1000);
	}
  	
  	@And("^I send update applicant details$")
	public void enterUpdateApplicantDetails() throws InterruptedException {
  		
  		Applicant app = TelesalesDataHelper.getApplicant();

//      pageApplicantDetails_Methods.PopulateAddressDetails(app);

  		Thread.sleep(1000);
  		
//  		driver.findElement(By.name("notes")).clear();
  		driver.findElement(By.name("notes")).sendKeys("asdfdsdsf");
  		
  		
  		pageApplicantDetails_Methods.PopulateUpdatedPersonalDetails(app);
  		
  		Thread.sleep(1000);
	}
  	
  	@And("^I send applicant details with title others as '(.+)'$")
	public void enterApplicantDetailsForTitleOthers(String otherTitle) {
  		
  		Applicant app = TelesalesDataHelper.getApplicant();
  		
  		 app.Title = Applicant.title.Other;
         app.OtherTitle = otherTitle;

  		pageApplicantDetails_Methods.PopulateAddressDetails(app);

  		pageApplicantDetails_Methods.PopulatePersonalDetails(app);
	}
  	
  	
  	@And("^I set Direct Debit as payment type$")
	public void DirectDebitPaymentType() {
  		
  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.DirectDebit);
	}
  	
  	@And("^I set Credit Debit card as payment type$")
	public void creditDebitCardPaymentType() {
  		
  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.CreditDebitCard);
	}
  	
  	@And("^I set Cheque as payment type$")
	public void ChequePaymentType() {
  		
  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.Cheque);
	}
  	
  	
  	@Then("^I click applicant details submit$")
	public void ApplicantDetailsSubmit() {
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	@Then("^I click applicant details Natwest Account submit$")
	public void ApplicantDetailsNatwestAccountSubmit() {
  		
  		Account acc = TelesalesDataHelper.getValidNatWestAccount();
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	@Then("^I click applicant details Valid Account submit$")
	public void ApplicantDetailsValidAccountSubmit() {
  		
  		Account acc = TelesalesDataHelper.getValidAccount();
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	@Then("^I click applicant details LLoyds Account submit$")
	public void ApplicantDetailsLLoydsAccountSubmit() {
  		
  		Account acc = TelesalesDataHelper.getValidLLoydsAccount();
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	@Then("^I click applicant details Halifax Account submit$")
	public void ApplicantDetailsHalifaxAccountSubmit() {
  		
  		Account acc = TelesalesDataHelper.getDirectCredit();
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	
  	@Then("^I click applicant details RBS Account submit$")
	public void ApplicantDetailsRBSAccountSubmit() {
  		
  		Account acc = TelesalesDataHelper.getValidRBSAccount();
  		
  		telesalesBasePage.ClickSubmit();  
	}
  	
  	
  	@And("^I send LLoyds account details$")
    public void enterLLoydsAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getValidLLoydsAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
  	
  	
 	@And("^I send valid account details$")
    public void enterValidAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getValidAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
  	
  	
 	@And("^I send RBS account details$")
    public void enterRBSAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getValidRBSAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
  	
  	
 	@And("^I send Natwest account details$")
    public void enterNatwestAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getValidNatWestAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
  	
 	
 	@And("^I send Halifax account details$")
    public void enterHalifaxAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getDirectCredit();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
  	
  	
 
 	@And("^I send no sort code account details$")
    public void enterNoSortCodeAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getNoSortCodeAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I clear account details$")
    public void clearAccountDetails() {
        
  		pageDirectDebitDetails.ClearAccountDetails();
  	}
 	
 	
 	@And("^I send invalid account details$")
    public void enterInvalidAccountDetails() {
  		
  		Account acc = TelesalesDataHelper.getInvalidSortCodeAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send part char sort code account details$")
    public void enterCharSortCodeAccount() {
  		
  		Account acc = TelesalesDataHelper.getCharSortCodeAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send account eight characters details$")
    public void enterAccount8Chars() {
  		
  		Account acc = TelesalesDataHelper.getAccount8Chars();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send account five characters details$")
    public void enterAccount5Chars() {
  		
  		Account acc = TelesalesDataHelper.getAccount5Chars();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send account all characters details$")
    public void enterAccountAllChars() {
  		
  		Account acc = TelesalesDataHelper.getAccountAllChars();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send account does not accept direct debit$")
    public void enterAccountDoesNotAcceptDirectDebit() {
  		
  		Account acc = TelesalesDataHelper.getAccountDoesNotAcceptDirectDebit();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	
 	@And("^I send account as not linked account details$")
    public void enterNotLinkedAccount() {
  		
  		Account acc = TelesalesDataHelper.getNotLinkedAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
 	

 	@And("^I send part completed sort code valid account details$")
    public void enterPartCompletedSortCodeValidAccount() {
  		
  		Account acc = TelesalesDataHelper.getPartCompletedSortCodeValidAccount();
        
  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
  	}
 	
  	
  	@And("^I send account holder name$")
    public void enterAccountHolderName() {
  		
  		Applicant app = TelesalesDataHelper.getApplicant();
        
  		pageDirectDebitDetails_Methods.SendAccountHolderName(app);
  	}
  	
  	
  	@And("^I send certificate start date$")
    public void setCertificateStartDatePlusMinusOneMonth() {
  		
  		Certificate cert = TelesalesDataHelper.getCertificate();
        cert.CertificateStart = Utilities.getPlusMinusOneMonthStartDate(false, true);
        
  		pageDirectDebitDetails.SendCertificateStartDate(cert);
  	}
 
  
  	@And("^I send certificate start date as current date$")
    public void setCertificateStartCurrentDate() {
  		
  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
    	 
    	 //get current date time with Date()
    	 Date date = new Date();
    	 
    	 // Now format the date
    	 String date1= dateFormat.format(date);
    	 
  		
  		Certificate cert = TelesalesDataHelper.getCertificate(date1);
        cert.CertificateStart = Utilities.getCurrentDateStartDate(true);
        
  		pageDirectDebitDetails.SendCertificateStartDate(cert);
  	}
  	
  	
  	@And("^I send certificate start date for twelve months$")
    public void setTweleveMonthsCertificateStartDatePlusMinusOneMonth() {
  		
  		Certificate cert = TelesalesDataHelper.getCertificateTwelveMonths();
        cert.CertificateStart = Utilities.getPlusMinusOneMonthStartDate(false, true);
        
  		pageDirectDebitDetails.SendCertificateStartDate(cert);
  	}
  	
  	@And("^I send certificate current start date for twelve months$")
    public void setTweleveMonthsCertificateStartCurrentDate() {
  		
  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
   	 
	   	//get current date time with Date()
	   	Date date = new Date();
	   	 
	   	// Now format the date
	   	String date1= dateFormat.format(date);
  		
  		Certificate cert = TelesalesDataHelper.getCertificateTwelveMonths(date1);
        cert.CertificateStart = Utilities.getCurrentDateStartDate(true);
        
  		pageDirectDebitDetails.SendCertificateStartDate(cert);
  	}
  	
  	
  	
  	@And("^I send certificate duration for three months$")
    public void setCertificateDurationThreeMonths() {
  		
  		Certificate cert = TelesalesDataHelper.getCertificate();
        cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
        
        pageCertificateDetails.SetCertificateDuration(cert);
       
  	}
  	
  	@And("^I send certificate duration for twelve months$")
    public void setCertificateDurationTweleveMonths() {
  		
  		Certificate cert = TelesalesDataHelper.getCertificate();
        cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
        
        pageCertificateDetails.SetCertificateDuration(cert);
       
  	}
  	
  	
  	@And("^I send certificate duration as current date$")
    public void setCertificateDurationCurrentDateThreeMonths() {
  		
  		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
    	 
    	 //get current date time with Date()
    	 Date date = new Date();
    	 
    	 // Now format the date
    	 String date1= dateFormat.format(date);
    	 
  		
  		Certificate cert = TelesalesDataHelper.getCertificate(date1);
        cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;  
  	}
  	  	
  	@And("^I click card payment call button$")
    public void clickCardPaymentCallButton() {
        
  		pageCheckDetails.ClickCardPaymentCall();
  	}
  	
  	
  	@And("^I click back button for payment card details$")
    public void clickCardPaymentBackButton() {
    
  		testBase.Wait(5);
  		
  		pagePaymentCardDetails.ClickBack();
  	}
  	
  	
  	@And("^I wait for page to load$")
    public void waitForElementDirectDebitDetails() {
        
  		pageDirectDebitDetails_Methods.waitForElement();
  	}
  	
  	
  	@And("^I check correct bank name as \"(.*)\"$")
    public void checkCorrectBankName(String bankNameText) {
  		
  		testBase.Wait(1);
  		pageDirectDebitDetails_Methods.isCorrectBankName(bankNameText);
  	}
  	
  	
  	@And("^I check correct bank address as \"(.*)\"$")
    public void checkCorrectBankAddress(String bankAddressText) {
        
  		pageDirectDebitDetails_Methods.isCorrectBankAddress(bankAddressText);
  	}
  	
  	
  	@Then("^I click submit for direct debit details$")
	public void SubmitDirectDebitDetails() {
  		
  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
	}
  	
  	@Then("^I click submit for credit debit details$")
	public void SubmitCreditDebitDetails() {
  		
  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
	}
  	
  	@Then("^I click submit for certificate details$")
	public void SubmitCertificateDetails() {
  		
  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
	}
  	
  	
  	@Then("^I check correct sort code as '(.+)'$")
	public void checkCorrectSortCode(String sortCode) {
  		
  		assertTrue("Sort Code does not match on the direct debit confirmation screen", pageDirectDebitConfirmation_Methods.isCorrectSortCode(sortCode)); 
	}
  	
  	
  	@Then("^I check correct account number as '(.+)'$")
	public void checkCorrectAccountCode(String accountNumber) {
  		
  		assertTrue("Account Number does not match on the direct debit confirmation screen", pageDirectDebitConfirmation_Methods.isCorrectAccountCode(accountNumber)); 
	}
  	
  	
  	
  	@Then("^I check server error '(.+)'$")
	public void checkServerError(String serverError) {
  		
  		assertTrue("Sort code should have been left blank", pageDirectDebitDetails_Methods.isServerError(serverError));
	}
  	
  	
  	
  	@Then("^I check account error as Sort Code not recognised$")
	public void checkSortCodeNotRecognised() {
  		
  		//assertTrue("Sort code should have been left blank", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.SortCodeNotRecognised));
	}
  	
  	
  	@Then("^I check account error as Sort Code not number$")
	public void checkSortCodeNotNumber() {
  		
  		//assertTrue("Sort code should have been invalid", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.SortCodeNotNumbers));
	}
  	
  	
  	@Then("^I check account error as invalid account number$")
	public void checkInvalidAccountNumber() {
  		
  		//assertTrue("Account code should have been more than 8 characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.InvalidAccountNumber));
	}
  	
  	
  	@Then("^I check account error as not linked and invalid account$")
	public void checkNotLinkedAndInvalidAccount() {
  		
  		//assertTrue("Sort Code/Account should have been valid, but not linked together", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.InvalidAccountNumber));
	}
  	
  	
  	@Then("^I check account error as account number short$")
	public void checkAccountNumberShort() {
  		
  		//assertTrue("Account Number should have been leff than 8 characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountNumberShort));
	}
  	
  	
  	@Then("^I check account error as account number not numeric$")
	public void checkAccountNumberNotNumeric() {
  		
  		//assertTrue("Account code should have been all characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountNumberNotNumeric));
	}
  	
  	
  	@Then("^I check account error as non DD account$")
	public void checkAccountDoesNotAcceptDirectDebits() {
  		
  		//assertTrue("This should have been a non DD account", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountDoesNotAcceptDirectDebits));
	}
  	
  	
  	@When("^I click cancel button$")
    public void cancelButton() {
        
  		telesalesBasePage.ButtonCancel.click(); 
  	}
  	
  	@When("^I click back button$")
    public void backButton() {
        
  		telesalesBasePage.ClickBack(); 
  	}
  	
  	@And("^I click submit button for page Direct Debit details$")
    public void submitDirectDebitDetailsButton() {
        
  		pageDirectDebitDetails.ClickSubmit(); 
  	}
  	
  	@And("^I click submit button for page Direct Debit confirmation$")
    public void submitDirectDebitConfirmationButton() {
        
  		pageDirectDebitConfirmation.ClickSubmit(); 
  	}
  	
  	@And("^I get new certificate number$")
    public void getNewCertificateNumber() {
        
  		//String certNumber = pageConfirmDirectDebit.getCertificateNumber();
  		
  		String locator = "//*[@id='container']/form/table/tbody/tr[4]/td[2]/span";	 	
	 	String CertificateNumber = driver.findElement(By.xpath(locator)).getText();
    	TestLogger.Info("New certificate number is: " + CertificateNumber);
    	//assertTrue("Failed to get a certificate", pageConfirmDirectDebit_Methods.isCertificateIssued("Certificate Number"));
    	
  	}
  	
  	@When("^I click Edit button for due date$")
    public void editButton() {
        
  		pageCertificateDetails.ButtonEditDD.click();
  	}
  	
  	
  	@When("^I edit direct debit due date by '(.+)' days$")
    public void editDueDateDetails(int days) {
        
  		int existingDueDate = pageEditDirectDebitDetails.getDueDay() + days;
        pageEditDirectDebitDetails.setDueDay(Integer.toString(existingDueDate));
        
  	}
  	
  	@When("^I verify Edit button error present$")
    public void checkDueDayErrorPresent() {
  		testBase.Wait(2);
  		 assertTrue("Setting due date to less than 12 days should be not allowed", pageEditDirectDebitDetails_Methods.isDueDayErrorPresent());
  	}
  	
  	@Then("^I verify error message is displayed as '(.+)'$")
    public void checkDueDayError(String duedayerror){
        
  		testBase.Wait(1);	 	
  		
  		 String locator = "//*[@id='container']/div/div/div/form/div[1]/div[3]/div[5]";
		 TestLogger.Info("Correct due day error: " + driver.findElement(By.xpath(locator)).getText());
		 assertEquals("Not the correct due day error", driver.findElement(By.xpath(locator)).getText(),duedayerror); 
  		
        //return true;
		 
    }
  	
  	@When("^I submit new direct debit details$")
    public void clickSubmitDDDetails() {
        
  		pageEditDirectDebitDetails.ButtonSubmitI.click();
  	}
  	
  	@When("^I create a new payment$")
    public void clickNewPayments() {
  		
  		pageCertificateDetails.NewPaymentButton.click();
  		testBase.Wait(1);	 
  		pageCertificateDetails.ButtonNewPaymentCheque.click();
  	}
  	
  	
  	@When("^I send payment amount '(.+)'$")
    public void sendPaymentAmount(String payment_amount) {
       
        pageRefundDetails.PopulatePaymentAmount(TelesalesDataHelper.enterPaymentAmount(payment_amount));
  	}
  	
  	@When("^I click the add payment to issue cheque refund$")
  	public void ClickAddPayment(){
  		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
 		testBase.Wait(2);	
		pageRefundDetails.ButtonAddPayment.click();
  	}
  	
}