package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail

	Data is invalid - login success - test fail  - logout
	Data is invalid -- login failed - test pass*/
	

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void LoginTestex(String email,String password,String exp) {

		// HomePage
		logger.info("************Started logging**********************");
try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// LoginPage
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();

		// MyAccountPage

		MyAccountPage macc = new MyAccountPage(driver);

		boolean targetPage = macc.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
	
		
		
		
		logger.info("**********Tested Completed*******************");

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
