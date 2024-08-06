package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	
	@Test(groups= {"Sanity","Functional","Regression"})
	public void LoginTestex() {

		// HomePage
		logger.info("************Started logging**********************");

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
		try {
			Assert.assertEquals(targetPage, true);
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**********Tested Completed*******************");

	}

}
