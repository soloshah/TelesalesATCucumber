package org.cucumber.viewsmethods;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.views.PageEditExemption;
import org.cucumber.views.TelesalesBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import uk.nhs.nhsbsa.config.env.BaseTest;
import uk.nhs.nhsbsa.config.env.TestBase;

public class PageEditExemption_Methods implements BaseTest {
	
	PageEditExemption pageEditExemption = PageFactory.initElements(driver, PageEditExemption.class);
	TelesalesBasePage telesalesBasePage = PageFactory.initElements(driver, TelesalesBasePage.class);
   
    public void PopulateEditExemption(Mother mother){
    
    	pageEditExemption.InputAddressLine1.clear();
    	pageEditExemption.InputAddressLine1.sendKeys(mother.Add1);
    
    	pageEditExemption.InputAddressLine2.clear();
    	pageEditExemption.InputAddressLine2.sendKeys(mother.Add2);
    
    	pageEditExemption.InputTown.clear();
    	pageEditExemption.InputTown.sendKeys(mother.Town);
    
    	pageEditExemption.InputAddressLine4.clear();
    	pageEditExemption.InputAddressLine4.sendKeys(mother.Add4);
    
    	pageEditExemption.InputPostcode.clear();
    	pageEditExemption.InputPostcode.sendKeys(mother.PostCode);
        
    	pageEditExemption.InputSurname.clear();
    	pageEditExemption.InputSurname.sendKeys(mother.Surname);
        
    	pageEditExemption.InputForename.clear();
    	pageEditExemption.InputForename.sendKeys(mother.Forename);
        
    	pageEditExemption.InputDob.clear();
    	pageEditExemption.InputDob.sendKeys(mother.Dob);
        
    	pageEditExemption.InputTelephoneNumber.sendKeys(mother.TelephoneNumber);
    	
    	pageEditExemption.InputEmailAddress.clear();
    	pageEditExemption.InputEmailAddress.sendKeys(mother.EmailAddress);
    	
    	pageEditExemption.InputDueDate.clear();
    	pageEditExemption.InputDueDate.sendKeys(mother.DueDate);
    	
    	pageEditExemption.InputNhsNumber.clear();
    	pageEditExemption.InputNhsNumber.sendKeys(mother.NhsNumber);
        
    	pageEditExemption.InputNotes.sendKeys(mother.Notes);
        
    }
}
