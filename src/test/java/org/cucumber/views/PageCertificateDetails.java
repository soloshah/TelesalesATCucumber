package org.cucumber.views;

import static org.junit.Assert.assertTrue;

import org.cucumber.ppctelesales.model.Certificate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCertificateDetails {

	@FindBy(xpath = "//*[@id='changeStatus']")
	public WebElement ButtonChangeStatus;

	@FindBy(xpath = "//*[@id='newAppLink']")    	
	public WebElement ButtonNewApplication;  
	
	@FindBy(xpath = "//*[@id='directDebitDetails']/div/div[2]/a")	
	public WebElement ButtonEditDD;
	
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[2]/div/button")
	public WebElement ButtonNewPayment;

	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[2]/div[2]/div/button")
	public WebElement NewPaymentButton;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[3]/button[1]")
	public WebElement ButtonAddPayment;
	
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[2]/div[2]/div/ul/li[3]/a")   
    //@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[2]/div/ul/li[1]/a")                	
	public WebElement ButtonNewPaymentCheque;
	
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[2]/a/span")  	
	public WebElement ButtonPaymentRefresh;

	@FindBy(xpath = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/span/a")  
	public WebElement ButtonPersonDetailsEdit;
	
	@FindBy(xpath = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div/a[@class = 'btn btn-primary']/text()/..")
    //"//*[@id='contactDetails']/text()[contains(.,'Save')]/..")
	//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[13]/a[1]
	//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div/p[@class = 'ng-binding']/text()
	public WebElement ButtonPersonDetailsSave;
	
	@FindBy(xpath = "//*[@id='addNote']")     	
	public WebElement ButtonAddNote;
	
	@FindBy(xpath = "//*[@id='renewLink']")     	
	public WebElement ButtonUseDetails;  
	
	@FindBy(xpath = "//*[@id='historyButton']")     
	public WebElement ButtonHistory;
	
	@FindBy(xpath = "//*[@id='renewLink']")     
	public WebElement ButtonRenew;    
	
	@FindBy(xpath = "//*[@id='buttonControl']/div/a[6]")   
	public WebElement ButtonAdhocCardPayment;    

	@FindBy(xpath = "//*[@id='buttonControl']/div/a[7]")      
	public WebElement ButtonCardRefundPayment;    

	@FindBy(xpath = "//*[@id='ppcPayments']/tbody/tr[last()]/td[2]")   
	private WebElement LastPaymentType;

	@FindBy(xpath = "//*[@id='ppcPayments']/tbody/tr[last()]/td[3]")   
	private WebElement LastAmount;
	
	@FindBy(xpath = "//*[@id='ppcPayments']/tbody/tr[last()]/td[4]")   
	private WebElement LastStatus;	
	 
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1][contains(.,'Total')]/div/div[3]/div/div[2]/span")
	//@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]")   
	private WebElement CurrentTotal;
	
	@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1][contains(.,'Outstanding')]/div/div[3]/div/div[3]/span")
	//@FindBy(xpath = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[3]/span")  
	private WebElement CurrentOutstanding;
	
	@FindBy(xpath = "//input[@name='certificateStart']")
	public WebElement InputCertificateStart;

	@FindBy(xpath = "//textarea[@name='notes']")
	public WebElement InputCertificateNotes;

	@FindBy(xpath = "//*[@id='contactEmail']") 
	private WebElement InputEmail;

	@FindBy(xpath = "//input[@id='duration3']")
	public WebElement Radio3Months;

	@FindBy(xpath = "//input[@id='duration12']")
	public WebElement Radio12Months;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[3]/div/div/input")                	
	public WebElement InputPaymentAmmount;	
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[4]/div/div/input")                	
	public WebElement InputchequeAmount;	

	public void SetCertificateDuration(Certificate certificate) {

		switch (certificate.CertificateDuration) {
		case ThreeMonths:
			Radio3Months.click();
			break;
		case TwelveMonths:
			Radio12Months.click();
			break;
		}
	}
	
	
    public Double getCurrentTotal(){
	     
   	 String existingTotal = CurrentTotal.getText();
   	 
   	 if (existingTotal.isEmpty()) {
   		 return 0.0;
   	 } else {
   		 String newTotal = existingTotal.replace("£", "");
   		 Double total = null;
   	 
   		 try {
   			 total = Double.parseDouble(newTotal);
   		 } catch (NumberFormatException e) {
   			 assertTrue("Retrieve of current Total failed)", true);
   		 }
   		 return total;

   	 	}
    }
    
    public Double getCurrentOutstanding(){
  	     
   	 String existingOutstanding = CurrentOutstanding.getText();
   	 
   	 if (existingOutstanding.isEmpty()) {
   		 return 0.0;
   	 } else {
   		 String newOutstanding = existingOutstanding.replace("£", "");
   		 Double Outstanding = null;
   	 		
   		 try {
   			 Outstanding = Double.parseDouble(newOutstanding);
   		 } catch (NumberFormatException e) {
   			 assertTrue("Retrieve of current Outstanding failed)", true);
   		 }
   		 return Outstanding;
   	 	}
    }
    
 
    public String getLastPaymentType(){
   	 String lastPayType = LastPaymentType.getText();
   	 return lastPayType;
    }  
    
    public String getLastAmount(){
   	 String lastAmount = LastAmount.getText();
   	 String newAmount = lastAmount.replace("£", "");
   	 return newAmount;
    }
    
    public String getLastStatus(){
   	 String lastStatus = LastStatus.getText();
   	 return lastStatus;
    }

	public void setEmail(String email) {
		
		InputEmail.clear();
		InputEmail.sendKeys(email);
	}
	
	public void setPaymentAmount(String paymentAmount) {
		
		//InputPaymentAmmount.clear();
		InputPaymentAmmount.sendKeys(paymentAmount);
	}	
	
	public void ClickNewApplication() {
		ButtonNewApplication.click();
	}
	
	public void ClickNewPayment() {
		NewPaymentButton.click();
	}
	
	public void ClickNewPaymentCheque() {
		ButtonNewPaymentCheque.click();
	}
	
 	
}
