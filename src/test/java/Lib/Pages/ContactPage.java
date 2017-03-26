package Lib.Pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Lib.Locators.Contact;

public class ContactPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public ContactPage verifyContactPageTitle(String title) {
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, title);
		return this;
	}
	
	public ContactPage enterFirstName(String firstName) {
		driver.findElement(By.name(Contact.FIRST_NAME)).sendKeys(firstName);
		assertEquals(driver.findElement(By.name(Contact.FIRST_NAME)).getAttribute("value"), firstName);
		return this;
	}
	
	public ContactPage enterLasttName(String lastName) {
		driver.findElement(By.name(Contact.LAST_NAME)).sendKeys(lastName);
		assertEquals(driver.findElement(By.name(Contact.LAST_NAME)).getAttribute("value"), lastName);
		return this;
	}
	
	public ContactPage enterEmail(String email) {
		driver.findElement(By.xpath(Contact.EMAIL)).sendKeys(email);
		assertEquals(driver.findElement(By.xpath(Contact.EMAIL)).getAttribute("value"), email);
		return this;
	}
	
	public ContactPage enterCompany(String company) {
		driver.findElement(By.cssSelector(Contact.COMPANY)).sendKeys(company);
		assertEquals(driver.findElement(By.cssSelector(Contact.COMPANY)).getAttribute("value"), company);
		return this;
	}
	
	public ContactPage enterPhoneNumber(String phoneNumber) {
		driver.findElement(By.name(Contact.PHONE)).sendKeys(phoneNumber);
		assertEquals(driver.findElement(By.name(Contact.PHONE)).getAttribute("value"), phoneNumber);
		return this;
	}
	
	public ContactPage enterComments(String comments) {
		driver.findElement(By.xpath(Contact.COMMENTS)).sendKeys(comments);
		assertEquals(driver.findElement(By.xpath(Contact.COMMENTS)).getAttribute("value"), comments);
		return this;
	}
}
