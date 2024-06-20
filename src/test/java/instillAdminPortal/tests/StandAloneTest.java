package instillAdminPortal.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import instillAdminPortal.pageobjects.LandingPage;
import instillAdminPortal.TestComponents.BaseTests;

public class StandAloneTest extends BaseTests {
	

	@Test
	public void successfulLogin() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication("godsfavour@instill.education","Password@2");
		Boolean match = landingPage.VerifyLoginWelcomeMessage("Welcome");
		Assert.assertTrue(match);
		
	}
	
	@Test
	public void successfulSignOut() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication("godsfavour@instill.education","Password@2");
		landingPage.SignOut();
		Assert.assertEquals("Let's log back into your account", landingPage.getDashBoardLoginMessage());	
			
		
	}
	
	@Test
	public void LoginErrorValidation() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication("godsfavour@instill.education","Password@");//Invalid password
		Assert.assertEquals("Invalid email/password!", landingPage.getLoginErrorMessage());
		
	}
	
	
	
	
	
	
	
	

}
