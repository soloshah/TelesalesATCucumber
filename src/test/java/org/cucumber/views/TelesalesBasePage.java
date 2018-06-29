package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelesalesBasePage {
	
	@FindBy(xpath = "//input[@name='Submit']")  
	public WebElement ButtonSubmit;

	@FindBy(xpath = "//[@id='backlink']")
	public WebElement ButtonBack;

	@FindBy(xpath = "//*[@id='cancellink']")  
	public WebElement ButtonCancel;  
	
	@FindBy(xpath = "//*[@id='changeStatus']")
	public WebElement ButtonChangeStatus;
	
	@FindBy(xpath = "//*[@id='directDebitDetails']/div/div[2]/a") 
	public WebElement ButtonEditDD;

	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[2]/div/button")
	public WebElement ButtonNewPayment;
	
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[2]/a/span")  	
	public WebElement ButtonPaymentRefresh;

	@FindBy(xpath = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/span/a")  
	public WebElement ButtonPersonDetailsEdit;

	@FindBy(xpath = "//*[@id='addNote']")     	
	public WebElement ButtonAddNote;
	
	@FindBy(xpath = "//*[@id='newAppLink']")    	
	public WebElement ButtonNewApplication;    
	
	@FindBy(xpath = "//*[@id='renewLink']")     	
	public WebElement ButtonUseDetails;  
	
	@FindBy(xpath = "//*[@id='historyButton']")     
	public WebElement ButtonHistory;    

	@FindBy(xpath = "//*[@id='buttonControl']/div/a[6]")   
	public WebElement ButtonAdhocCardPayment;    

	@FindBy(xpath = "//*[@id='buttonControl']/div/a[7]")      
	public WebElement ButtonCardRefundPayment;
	
	@FindBy(xpath = "//*[@id='submitLink']")      
	public WebElement SubmitButton;
	
	@FindBy(xpath = "//*[@id='reissueLink']")      
	public WebElement ReissueButton;
	
//	@FindBy(xpath = "//*[@id='buttonControl']/div/a[7]")      
//	public WebElement IssueButton;
	
    public void ClickSubmit(){
    	ButtonSubmit.click();
    }

    public void ClickBack(){
    	ButtonBack.click();
	}

    public void ClickCancel(){
    	ButtonCancel.click();
	}  
    
    public void ClickReissue(){
    	ReissueButton.click();
	}  

	/**
	 * 
	 * @return
	 */
//	public boolean waitForLoadingGifToDissappear() {
//		return super.waitForElementToRemove(By.xpath(""));
//	} 

}
