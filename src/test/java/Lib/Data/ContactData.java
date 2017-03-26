package Lib.Data;

public class ContactData {

	public static final String CONTACT_PAGE_TITLE	= "Contact Us | OneTrust",
			COMPANY	= "OnetrustAutomation";
	
	public String timeStamp	= System.currentTimeMillis() + "",
			firstName	= "autoFN" + timeStamp,
			lastName	= "autoLN" + timeStamp,
			email		= "auto" + timeStamp + "@gmail.com",
			phone		= timeStamp.substring(0, 10),
			comments	= "test auto comments" + timeStamp;
}
