package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*******starting TC002_LoginTest**********");
				
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		myAccountPage ap = new myAccountPage(driver);
		boolean targetpage=ap.isMyAccountPageExists();
		Assert.assertEquals(targetpage,true,"Login failed");
		Assert.assertTrue(targetpage);
	
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("*******Finished TC002_LoginTest*********");
}
}
