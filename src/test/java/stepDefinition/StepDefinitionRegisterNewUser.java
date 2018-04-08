package stepDefinition;

import objectRepository.HomePage;
import objectRepository.RegistrationPage;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionRegisterNewUser {

	TestContext testContext;
	public HomePage home;
	public RegistrationPage register;
	
	public StepDefinitionRegisterNewUser(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		register = testContext.getPageObjectManager().getRegistrationPage();
	}
	
	//Register New User
	
		@Given("^User clicks on Register in Accounts Menu$")
		public void user_clicks_on_Register_in_Accounts_Menu() throws Throwable {
		   // page = new PageObjectManager(driver);
		   // home = page.getHomePage();
		    home.getAccountMenu().click();
			home.getUserRegistrationFromAccountMenu().click();
			
			
		}

		@When("^User enters the Registration details$")
		public void user_enters_the_Registration_details() throws Throwable {
			//register = page.getRegistrationPage();
			register.getLoginIdForNewUserRegistration().sendKeys("");
			
			register.getLoginIdForNewUserRegistration().sendKeys("akshatnarang");
			register.getEmailIdForNewUserRegistration().sendKeys("akshat55narang@gmail.com");
			register.getPasswordForNewUserRegistration().sendKeys("liverpoolFC");
			register.getPasswordConfirmationForNewUserRegistration().sendKeys("liverpoolFC");
			
			}

		@When("^clicks on Register$")
		public void clicks_on_Register() throws Throwable {
			register.getRegisterButtonForNewUserRegistration().click();
		}

		@Then("^User should register his/her account successfully$")
		public void user_should_register_his_her_account_successfully() throws Throwable {
			Assert.assertEquals("Registration failed! Please try again later.", register.getRegistrationFailureMessage().getText());
			testContext.getWebDriverManager().closeBrowser();

		}

		@Then("^Register button should be disabled$")
		public void register_button_should_be_disabled() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   
		}
		
	
}
