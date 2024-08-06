package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Functional"})
	public void verify_account_registration() {

		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("***** Register account  ****");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());

			String password = randomAlphaNumeric();
             logger.info("hgsdjhsgdf");
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
	        logger.info("Test passed");
		}
	        
	        catch(Exception e) {
	        	
	        	logger.error("Text message:"+e.getMessage());
	        	Assert.fail("Text message:" +e.getMessage());
	        	
	        
	        }finally {
	        	
	        	logger.info("**********Tested completed********************");
	        	
	        }
	        
	        
	    
		
	}

}
