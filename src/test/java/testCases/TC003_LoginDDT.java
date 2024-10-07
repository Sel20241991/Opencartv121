package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Datadriven") //getting dataprovider from different class
	
	public void verify_loginDDT(String email,String pwd, String exp)
	{
		logger.info("*****starting TC003_LoginDDt *****");
		
		try
		{
			//HomePage
			    HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//LoginPage
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//MyAccountPage
				myAccountPage macc = new myAccountPage(driver);
				boolean targetpage=macc.isMyAccountPageExists();
								
				/*Data is valid - login success -test pass -logout
				 *                login failed -test fail 
				 * Data is invalid - login sucess -test fail -logout
				 *                    login failed -test pass 
				 */

				if(exp.equalsIgnoreCase("valid"))
				{
					if(targetpage == true)
					{
						macc.clickLogout();
					    Assert.assertTrue(true);
				    }
				else
				    {
					Assert.assertTrue(false);
				    }
				}
				
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetpage == true)
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
		Assert.fail();
	}
	
	logger.info("*****starting TC003_LoginDDt *****");
	
	
	}
}
