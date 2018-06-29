package org.cucumber.views;

import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.ppctelesales.model.Payment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageRefundDetails {
	
	@FindBy(xpath = "//*[@id='submitButton']")  
	public WebElement ButtonSubmit;
	
	@FindBy(xpath = "//*[@id='backlink']")
	public WebElement ButtonBack;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[3]/button[1]")  
	public WebElement ButtonAddPayment;
	  
	@FindBy(xpath = "//*[@id='cancelLink']")  
	public WebElement ButtonCancel;
	
    @FindBy(xpath = "//*[@name='paymentAmount']")     
    public WebElement InputPaymentAmount;
    
    @FindBy(xpath = "//*[@id='container']/form/div[4]/div[2]/textarea")    
    private WebElement InputNotes;
         
    public void PopulatePaymentAmount(Payment payment){
      
    	InputPaymentAmount.sendKeys(payment.PaymentAmount);  
    }
    
    public void SetNotes(String notes) {
		InputNotes.clear();
		InputNotes.sendKeys(notes);
	}	
		
    public void ClickBack(){
    	ButtonBack.click();
    }
    
    public void ClickSubmit(){
        ButtonSubmit.click();
    }
    
    public void ClickCancel(){
    	ButtonCancel.click();
    }
    
    public void ClickAddPayment(){
    	ButtonAddPayment.click();
    }
    
}
