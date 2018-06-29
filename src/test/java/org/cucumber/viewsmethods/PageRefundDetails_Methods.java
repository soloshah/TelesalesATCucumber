package org.cucumber.viewsmethods;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Payment;
import org.cucumber.views.PageApplicantDetails;
import org.cucumber.views.PageApplicantUpdatedDetails;
import org.cucumber.views.PageRefundDetails;
import org.cucumber.views.TelesalesBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

public class PageRefundDetails_Methods implements BaseTest {
	
	PageApplicantDetails pageApplicantDetails = PageFactory.initElements(driver, PageApplicantDetails.class);
	PageApplicantUpdatedDetails pageApplicantUpdatedDetails = PageFactory.initElements(driver, PageApplicantUpdatedDetails.class);
	PageRefundDetails pageRefundDetails = PageFactory.initElements(driver, PageRefundDetails.class);
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
	
    
    public void PopulatePaymentAmount(Payment payment){
        
    	pageRefundDetails.InputPaymentAmount.clear();
    	pageRefundDetails.InputPaymentAmount.sendKeys(payment.PaymentAmount);
    
//    	pageApplicantDetails.InputAddressLine2.clear();
//    	pageApplicantDetails.InputAddressLine2.sendKeys(applicant.Add2);
    
    }
}    


