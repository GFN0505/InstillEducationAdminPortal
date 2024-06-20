package instillAdminPortal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import instillAdminPortal.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)//A constructor, the first block of code to be executed in this class
	{
		super(driver); //This sends driver to the parent class 
		
		this.driver= driver;
		PageFactory.initElements(driver, this);//This allows for replacement of driver.findElementB y
		
	}
	
	@FindBy(id="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(css="button[type='button']")
	WebElement signOut;
	
	@FindBy(css=".chakra-text.css-q9xp4t")  
	WebElement loginWelcomeMessage;
	
	@FindBy(css=".chakra-text.css-0")  
	WebElement dashBoardLoginMessage;
	
	
	@FindBy(css="div[id='toast-1-description']")
	WebElement loginErrorMessage;
	
	
	public void loginApplication(String email, String password)//Action methods
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
	}
	
	public void SignOut()
	{
		signOut.click();
	}
	
	
	public String getDashBoardLoginMessage()
	{
		//waitForWebElementToAppear(loginWelcomeMessage);
		return dashBoardLoginMessage.getText();
		
	}
	
		
	
	public String getLoginWelcomeMessage()
	{
		//waitForWebElementToAppear(loginWelcomeMessage);
		return loginWelcomeMessage.getText();
		
	}
	
	public Boolean VerifyLoginWelcomeMessage(String message)
	{
	Boolean match =  getLoginWelcomeMessage().contains(message);;
	return match;
	}
	
	public String getLoginErrorMessage()
	{
		waitForWebElementToAppear(loginErrorMessage);
		return loginErrorMessage.getText();
		
	}
	
	
	public void goTo()
	{
		driver.get("https://admin.uat.instill.education/");
	}
	
}
