package uk.nhs.nhsbsa.config.env;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Env
{
	static WebDriver driver = null;
	static String browserName = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(Env.class);

	public static String getBrowserName()
	{
		browserName = EnvConfig.getBrowser();

		if (browserName == null)
			browserName = "ff";
		return browserName;
	}

	public static WebDriver CreateWebDriver(String browser)
	{
		System.out.println("Browser: " + browser);

		switch (browser.toLowerCase())
		{
			case "ff":
			case "firefox":
				String geckoDriverPath = "src//test//resources//drivers//geckodriver.exe";
				System.setProperty("webdriver.firefox.driver", geckoDriverPath);
				driver = new FirefoxDriver();
				break;

			case "ch":
			case "chrome":
				String chromeDriverPath = "src//test//resources//drivers//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("start-maximized");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();    
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				break;
				
			case "ph":
			case "phantomjs":
		    		String phantomjsDriverPath = "src//test//resources//drivers//phantomjs.exe";
		    		DesiredCapabilities caps = new DesiredCapabilities();
		    		caps.setJavascriptEnabled(true);                
		    		caps.setCapability("takesScreenshot", true);  
		    		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsDriverPath);
		    		driver = new  PhantomJSDriver(caps);
		    		break;
						
			case "ie":
			case "internetexplorer":
				String ieDriverPath = "src//test//resources//drivers//IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", ieDriverPath);
				driver = new InternetExplorerDriver();
				break;

			case "safari":
				// TODO
				driver = new SafariDriver();
				break;

			default:
				System.out.println("Invalid browser name " + browser);
				System.exit(0);
				break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run()
			{
				Env.initSeleniumEnd();
			}
		});

		return driver;
	}

	private static void initSeleniumEnd()
	{
		LOGGER.info("===============================================================");
		LOGGER.info("|          Stopping driver (closing browser)                   |");
		LOGGER.info("===============================================================");
		driver.quit();
		LOGGER.debug("===============================================================");
		LOGGER.debug("|         Driver stopped (browser closed)                     |");
		LOGGER.debug("===============================================================\n");
	}
}
