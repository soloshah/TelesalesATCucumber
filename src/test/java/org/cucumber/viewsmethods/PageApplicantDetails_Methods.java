package org.cucumber.viewsmethods;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.views.PageApplicantDetails;
import org.cucumber.views.PageApplicantUpdatedDetails;
import org.cucumber.views.TelesalesBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

public class PageApplicantDetails_Methods implements BaseTest {
	
	PageApplicantDetails pageApplicantDetails = PageFactory.initElements(driver, PageApplicantDetails.class);
	PageApplicantUpdatedDetails pageApplicantUpdatedDetails = PageFactory.initElements(driver, PageApplicantUpdatedDetails.class);
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);

    public void SetApplicantTitle(Applicant applicant){
    
    if (null != applicant.Title)switch (applicant.Title) {
        case Other:
            SetOtherTitle(applicant.OtherTitle);
            break;
        case NotSet:
            //log this
            break;
        default:
            driver.findElement(By.xpath("//input[@title='" + applicant.Title + "']")).click();
            break;
    	}
    }
    
    private void SetOtherTitle(String title){
    
    driver.findElement(By.xpath("//input[@value='Other']"))
            .click();
    
    driver.findElement(By.xpath("//select[@name='othertitle']/option[text()='" + title + "']"))
            .click();
    }
    
    public void PopulateAddressDetails(Applicant applicant){
    
    	pageApplicantDetails.InputAddressLine1.clear();
    	pageApplicantDetails.InputAddressLine1.sendKeys(applicant.Add1);
    
    	pageApplicantDetails.InputAddressLine2.clear();
    	pageApplicantDetails.InputAddressLine2.sendKeys(applicant.Add2);
    
    	pageApplicantDetails.InputAddressLine3.clear();
    	pageApplicantDetails.InputAddressLine3.sendKeys(applicant.Add3);
    
    	pageApplicantDetails.InputAddressLine4.clear();
    	pageApplicantDetails.InputAddressLine4.sendKeys(applicant.Add4);
    
    	pageApplicantDetails.InputPostcode.clear();
    	pageApplicantDetails.InputPostcode.sendKeys(applicant.PostCode);
    }
    
    public void PopulatePersonalDetails(Applicant applicant){
        
    	SetApplicantTitle(applicant);
        
    	pageApplicantDetails.InputSurname.sendKeys(applicant.Surname);
        
    	pageApplicantDetails.InputForename.sendKeys(applicant.Forename);
        
    	pageApplicantDetails.InputDob.clear();
    	pageApplicantDetails.InputDob.sendKeys(applicant.Dob);
        
    	pageApplicantDetails.InputTelephoneNumber.sendKeys(applicant.TelephoneNumber);
        
    	pageApplicantDetails.InputNhsNumber.sendKeys(applicant.NhsNumber);
        
    	pageApplicantDetails.InputNotes.sendKeys(applicant.Notes);
        
        SetPaymentType(applicant.PaymentType);
    }
    
    
    
    
    
    
public void PopulateUpdatedPersonalDetails(Applicant applicant){
        
//    	SetApplicantTitle(applicant);
        
//    	pageApplicantUpdatedDetails.InputSurname.clear();
//    	pageApplicantUpdatedDetails.InputSurname.sendKeys(applicant.Surname);

		pageApplicantUpdatedDetails.InputNotes.clear();
		pageApplicantUpdatedDetails.InputNotes.sendKeys(applicant.Notes);	
	
//        
//    	pageApplicantDetails.InputForename.sendKeys(applicant.Forename);
//        
//    	pageApplicantDetails.InputDob.clear();
//    	pageApplicantDetails.InputDob.sendKeys(applicant.Dob);
//        
//    	pageApplicantDetails.InputTelephoneNumber.sendKeys(applicant.TelephoneNumber);
//        
//    	pageApplicantDetails.InputNhsNumber.sendKeys(applicant.NhsNumber);
//        
//    	pageApplicantDetails.InputNotes.sendKeys(applicant.Notes);
//        
//        SetPaymentType(applicant.PaymentType);
    }


    
    public void PopulateEditApplicant(Applicant applicant){
    	
       	pageApplicantDetails.InputNotes.sendKeys(applicant.Notes);
    	
    }
    
    public void SetPaymentType(Applicant.paymentType payType){
        
        String type;
        
        switch (payType){
            case CreditDebitCard:
                type = "card";
                break;
            case DirectDebit:
                type = "directdebit";
                break;
            case Cheque:
                type = "cheque";
                break;
            default:
                type = "card";
                break;
        }
        
        driver.findElement(By.xpath("//input[@name='payType'][@title='" + type + "']")).click();
    }
    
    /* Copied methods to TelesalesBasePage */
    
//    public void ClickSubmit(){
//    	telesalesBasePage.ButtonSubmit.click();
//    }
//
//    public void ClickBack(){
//    	telesalesBasePage.ButtonBack.click();
//	}
//
//    public void ClickCancel(){
//    	telesalesBasePage.ButtonCancel.click();
//	}  
	
}
