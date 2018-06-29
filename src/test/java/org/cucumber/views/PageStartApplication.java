package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.viewsmethods.PageApplicantDetails_Methods;

public class PageStartApplication {
	
	 	@FindBy(xpath = "//*[@id='center']/div[2]/div/a[1]/span")
	 	public WebElement RegisterButton; 
	    
	    @FindBy(xpath = "//*[@id='center']/div[2]/div/a[2]/span")
	    public WebElement LoginButton;
	        
	    
	    public void ClickRegisterButton(){
	    	RegisterButton.click();
	    }
	    
	    public void ClickLoginButton(){
	    	LoginButton.click();
	    }

}
