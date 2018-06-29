package uk.nhs.nhsbsa.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.config.env.TestBase;

import org.cucumber.ppctelesales.helper.TelesalesDataHelper;
import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.ppctelesales.model.Search;
import org.cucumber.utils.Utilities;
import org.cucumber.views.PageApplicantDetails;
import org.cucumber.views.PageCertificateDetails;
import org.cucumber.views.PageSearchDetails;
import org.cucumber.views.PageSearchResults;
import org.cucumber.views.TelesalesBasePage;
import org.cucumber.viewsmethods.PageApplicantDetails_Methods;
import org.cucumber.viewsmethods.PageCertificateDetails_Methods;
import org.openqa.selenium.support.PageFactory;

public class TelesalesAdapterSteps extends TestBase {
	
	PageSearchDetails pageSearchDetails = PageFactory.initElements(driver, PageSearchDetails.class);
	PageSearchResults pageSearchResults = PageFactory.initElements(driver, PageSearchResults.class);
	PageApplicantDetails pageApplicantDetails = PageFactory.initElements(driver, PageApplicantDetails.class);
	PageCertificateDetails pageCertificateDetails = PageFactory.initElements(driver, PageCertificateDetails.class);
	
	 PageApplicantDetails_Methods pageApplicantDetails_Methods = new PageApplicantDetails_Methods(); 
	 PageCertificateDetails_Methods pageCertificateDetails_Methods = new PageCertificateDetails_Methods();
	 
	 TelesalesBasePage telesalesBasePage = new TelesalesBasePage();
	 
	@When("^I enter search details via certificate number as '(.+)'$")
	public void enterCertNumber(String certNumber) {
			
		waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
		pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getValidSearchViaCertNumber(certNumber));

	}
	
	@When("^I enter Non English postcode$")
	public void enterNonEnglishPostcode() {
			
		waitForElement("//*[@id='postcodeField']");
		
		Search duffPostcodeSearch = TelesalesDataHelper.getSearch();
        
        duffPostcodeSearch.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.Scotland);
        
        pageSearchDetails.PopulateSearchCriteria(duffPostcodeSearch);

	}
	
	@When("^I click submit$")
	public void clickSubmitButton() {
        
        pageSearchDetails.ClickSubmit();
        Wait(5);

	}

	//@When("^I complete applicant details proceed to direct debit details$")
	public void CompleteApplicantDetailsProceedToDirectDebitDetails() {

		Applicant app = TelesalesDataHelper.getApplicant();
		Certificate cert = TelesalesDataHelper.getCertificate();

		app.Title = Applicant.title.Other;
		app.OtherTitle = "Lt Cdr";

		cert.CertificateStart = Utilities.getPlusMinusOneMonthStartDate(false, true);
		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;

		SendSearchDetails();

		SendApplicantDetails(app);

		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.DirectDebit);

		telesalesBasePage.ClickSubmit();
	}

	/**
	 * sends search details to first screen you see after logging in - need to
	 * get past this screen before you can create new applications.
	 */
	//@When("^I send search details$")
	public void SendSearchDetails() {
	
		waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");

		pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
		
		telesalesBasePage.ClickSubmit();

		pageSearchResults.ClickNewApplication();
	}
	
	/**
	 * sends valid search details to the search screen via the certificate number
	 */
	@When("^I send valid search details via certificate number as '(.+)'$")
	public void SendValidSearchDetailsViaCertNumber(String certNumber) {
		
//		waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");

		pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getValidSearchViaCertNumber(certNumber));
		
		pageSearchDetails.ClickSubmit();

		//Pages.SearchResults().ClickNewApplication();
	}	
	
	/**
	 * sends valid search details to the search screen via the DDRef number
	 */
	@When("^I send valid search details via DDRef number '(.+)'$")
	public void SendValidSearchDetailsViaDDRefNumber(String ddRef) {
		
		waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");

		pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getValidSearchViaDDref(ddRef));
		
		pageSearchDetails.ClickSubmit();

		//Pages.SearchResults().ClickNewApplication();
	}	

	/**
	 * sends valid search details to the search screen via Surname and DOB
	 */
	@When("^I send valid search details via surname '(.+)' and DOB '(.+)'$")
	public void SendValidSearchDetailsViaSurnameDOB(String surname, String dob) {
		
		waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");

		pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getValidSearchViaSurnameDob(surname, dob));
		
		pageSearchDetails.ClickSubmit();

		//Pages.SearchResults().ClickNewApplication();
	}	
	
	/**
	 * send the applicant's personal details.
	 * 
	 * @param app
	 */
	//@When("^I send applicant details$")
	public void SendApplicantDetails(Applicant app) {

		pageApplicantDetails_Methods.PopulateAddressDetails(app);

		pageApplicantDetails_Methods.PopulatePersonalDetails(app);
	}

	/**
	 * send the certificate details
	 * 
	 * @param cert
	 */
	//@When("^I send certificate details$")
	public void SendCertificateDetails(Certificate cert) {

		pageCertificateDetails.SetCertificateDuration(cert);

		pageCertificateDetails_Methods.SetCertificateStart(cert);

		pageCertificateDetails_Methods.SetCertificateNotes(cert);
	}

}
