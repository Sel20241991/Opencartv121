package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{

	public myAccountPage(WebDriver driver) {
		super(driver);
	}
   
	@FindBy(xpath="//h2[normalize-space()='My Account']")//myaccount page heading
	WebElement msfHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") //added in step6
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return (msfHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
}
