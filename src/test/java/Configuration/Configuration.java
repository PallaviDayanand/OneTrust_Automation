package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Configuration {

	public WebDriver driver;
	public static String browserName = "chrome";
	public WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browserName);

		switch(browserName) {
		case "firefox":
			driver = new FirefoxDriver(cap);
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver",System.getProperty("webdriver.chrome.driver",
					".//src//test//resources//BrowserDrivers//chromedriver.exe"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver",System.getProperty("webdriver.ie.driver",
					".//src//test//resources//BrowserDrivers//IEDriverServer.exe"));
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(cap);
			driver.manage().deleteAllCookies();
			break;
		}

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
