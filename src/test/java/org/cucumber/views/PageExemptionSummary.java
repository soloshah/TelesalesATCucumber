package org.cucumber.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageExemptionSummary {
	
	@FindBy(xpath = "//button[@accesskey='Q']")
	private WebElement ButtonNewPayment;

	@FindBy(xpath = "//a[@ng-click='refreshPayments()']")
	private WebElement ButtonPaymentsRefresh;

	@FindBy(xpath = "//a[@ng-click='toggleEditor()']")
	private WebElement ButtonPersonalDetailsEdit;

	@FindBy(xpath = "//span[@id='addNote']")
	private WebElement ButtonAddNote;

	@FindBy(xpath = "//a[@id'newAppLink']")
	private WebElement ButtonNewApplication;

	@FindBy(xpath = "//a[@id=renewLink]")
	private WebElement ButtonUseDetails;

	@FindBy(xpath = "//a[@id='historyButton']")
	private WebElement ButtonHistory;

	@FindBy(xpath = "//a[@id='paymentCalllink']")
	private WebElement ButtonCardPaymentCall;

	@FindBy(xpath = "//a[text()='Adhoc Card Payment']")
	private WebElement ButtonAdhocCardPayment;

	@FindBy(xpath = "//a[text()='Card Refund Payment']")
	private WebElement ButtonCardRefundPayment;
	
	@FindBy(xpath = "//*[@id='editBtn']")
	private WebElement ButtonEdit;

}
