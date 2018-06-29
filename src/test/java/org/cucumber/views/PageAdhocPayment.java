package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAdhocPayment {
	
	@FindBy(xpath = "//*[@id='submit']")   
	public WebElement ButtonSubmit;
	
	@FindBy(xpath = "//*[@id='backlink']")  
	public WebElement ButtonBack;
	
	@FindBy(xpath = "//*[@id='cancellink']") 
	public WebElement ButtonCancel;

   // @FindBy(xpath = "//*[@id='container']/form/div[3]/div[2]/input")     
    //private WebElement InputAdhocPayment;
    
    @FindBy(xpath = "//*[@id='container']/form/div[4]/div[2]/textarea")    
    private WebElement InputNotes;
    
	//public void SetAdhocPayment(String adhocPayment) {
	//	InputAdhocPayment.clear();
	//	InputAdhocPayment.sendKeys(adhocPayment);
	//}
	
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

}
