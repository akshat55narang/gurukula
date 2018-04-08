package stepDefinition;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePage;
import objectRepository.StaffOverviewPage;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionEntities {

	TestContext testContext;
	public HomePage home;
	public WebDriverWait wait;
	public StaffOverviewPage staff;
	
	public StepDefinitionEntities(TestContext context){
		testContext=context;
		home = testContext.getPageObjectManager().getHomePage();
		staff = testContext.getPageObjectManager().getStaffOverviewPage();
	}

	@When("^User clicks on Entities Menu$")
	public void user_User_clicks_on_Entities_Menu() throws Throwable {
	    home.getEntitiesMenu().click();
	    wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(home.getEntitiesMenu()));
	}

	@Then("^User should be able to view Branch and Staff values in the Entity list$")
	public void user_should_be_able_to_view_Branch_and_Staff_values_in_the_Entity_list() throws Throwable {
		Assert.assertEquals(" Branch", home.getEntitiesList().get(0).getText());
		Assert.assertEquals(" Staff", home.getEntitiesList().get(1).getText());
		
		testContext.getWebDriverManager().closeBrowser();
	}
	
	@When("^User clicks on Branches Menu$")
	public void user_clicks_on_Branches_Menu() throws Throwable {
	   
	}

	@Then("^User should be able to see a list of all the Branches$")
	public void user_should_be_able_to_see_a_list_of_all_the_Branches() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^User clicks on Staffs Menu$")
	public void user_clicks_on_Staffs_Menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^User should be able to see a list of all the staff information$")
	public void user_should_be_able_to_see_a_list_of_all_the_staff_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Given("^User opens Entities Menu$")
	public void user_User_opens_Entities_Menu() throws Throwable {
	    home.getEntitiesMenu().click();
	    wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(home.getListItemStaffFromEntitiesMenu()));
	}

	@Given("^User selects Staffs Menu$")
	public void user_opens_Staffs_Menu() throws Throwable {
	    home.getListItemStaffFromEntitiesMenu().click();
	}

	@When("^User creates a new staff entry$")
	public void user_creates_a_new_staff_entry() throws Throwable {
	    staff.getCreateStaffButton().click();
	    staff.getFormInputName().sendKeys("akshatnarang");
	    staff.getSaveButton().click();
	}

	@Then("^User should be able to see the created entry in the Staff list$")
	public void user_should_be_able_to_see_the_created_entry_in_the_Staff_list() throws Throwable {
	    int count = staff.getStaffTableRows().size();
	    for(int i=0;i<count;i++){
	    	System.out.println(staff.getStaffTableRows().get(i).getText());
	    }
	    
	}
	
	@When("^User opens Settings from Account menu$")
	public void user_opens_Settings_from_Account_menu() throws Throwable {
	    
	}

	@Then("^User should be able to edit the logged in account information$")
	public void user_should_be_able_to_edit_the_logged_in_account_information() throws Throwable {
	    
	}
	
}
