package Lib.SharedModule;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Module {

	WebDriver driver;
	WebDriverWait wait;
	
	public Module(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public Module launchURL(String URL) {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return this;
	}
	
	public Module navigateToContact(String URL) {
		System.out.println("-------------navigating to " + URL + "-------------");
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	public Module takeScreenShot() throws Exception {
		System.out.println("-------------Taking Screenshot-------------");
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takeScreenshot.getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("dd_M_yyyy_HH_mm_ss");
		String screenshotTakeAt = format.format(time);
		File file = new File(".//src//test/resources//Screenshots//Scrrenshot"+ screenshotTakeAt +".png");
		FileUtils.copyFile(screenshotAs, file);
		String property = System.getProperty("user.dir");
		System.out.println("Screenshot taken and stored at:\n"+ property + "/src/test/resources/Screenshots/\n"+"as \nScrrenshot" + screenshotTakeAt);
		return this;
	}
}