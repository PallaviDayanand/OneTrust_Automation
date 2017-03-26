package Requirements;

import org.testng.annotations.Test;

import Configuration.Configuration;
import Lib.Data.CommonData;
import Lib.Data.ContactData;
import Lib.Data.HomeData;
import Lib.Pages.ContactPage;
import Lib.Pages.HomePage;
import Lib.SharedModule.Module;

public class OneTrustAutomation extends Configuration {

	@Test(description="Take screenshot after filling all the firlds in 'Contact' page of OneTrust")
	public void TakeScreenShot_ContactsPage() throws Exception {
		Module module = new Module(driver, wait);
		HomePage home = new HomePage(driver, wait);
		ContactPage contact = new ContactPage(driver, wait);
		
		ContactData contactData = new ContactData();
		
		module.launchURL(CommonData.ONE_TRUST_URL);
		home.verifyHomePageTitle(HomeData.HOME_PAGE_TITLE);
		
		module.navigateToContact(CommonData.CONTACT_URL);
		contact.verifyContactPageTitle(ContactData.CONTACT_PAGE_TITLE);
		
		contact.enterFirstName(contactData.firstName)
				.enterLasttName(contactData.lastName)
				.enterEmail(contactData.email)
				.enterCompany(ContactData.COMPANY)
				.enterPhoneNumber(contactData.phone)
				.enterComments(contactData.comments);
		
		module.takeScreenShot();
	}
}