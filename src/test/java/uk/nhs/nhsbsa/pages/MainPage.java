package uk.nhs.nhsbsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class MainPage {
	private WebDriver driver;
	private int timeout = 15;

	private final String pageLoadedText = "Welcome | NHSBSA";
	
	private final String searchPageLoadedText = "Search results";

	@FindBy(id = "edit-aggregated-field")
	private WebElement searchField;

	@FindBy(id = "edit-submit-search")
	private WebElement searchButton;
	
	@FindBy(className = "js-quickedit-page-title")
	private WebElement searchResultsPageTitle;
	
	@FindBy(className = "search-listing-tags")
	private WebElement searchTags;

	public MainPage() {
	}

	public MainPage(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public MainPage(WebDriver driver, int timeout) {
		this(driver);
		this.timeout = timeout;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the ErrorPage class instance.
	 */
	public MainPage verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});

		return this;
	}

	public MainPage searchFor(String arg1) {
		searchField.sendKeys(arg1);
		searchButton.click();

		return this;
	}

	public void assertSearchPageResults(String arg1) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(searchPageLoadedText);
			}
		});
		String str = searchTags.getText();
		Assert.assertEquals(arg1, str);

	}

}
