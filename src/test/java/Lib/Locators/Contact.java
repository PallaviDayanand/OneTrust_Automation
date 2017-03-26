package Lib.Locators;

public class Contact {

	public static final String FIRST_NAME	= "first_name",
			LAST_NAME	= "last_name",
			EMAIL		= "//input[@name='email']",
			COMPANY		= "input[name='company']",
			PHONE		= "phone",
			COMMENTS	= "//label[text()='Comments']/following-sibling::textarea[@placeholder='Comments']";
}
