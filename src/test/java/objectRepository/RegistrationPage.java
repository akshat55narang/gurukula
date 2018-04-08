package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement inputNewRegistrationLoginId;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement inputNewRegistrationEmailId;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement inputNewRegistrationNewPassword;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement inputNewRegistrationNewPasswordConfirmation;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-scope']")
	private WebElement buttonRegister;
	
	@FindBy(xpath="//div[@class='alert alert-danger ng-scope']")
	private WebElement messageRegistrationFailure;

	
	public WebElement getLoginIdForNewUserRegistration(){
		return inputNewRegistrationLoginId;
	}

	public WebElement getEmailIdForNewUserRegistration(){
		return inputNewRegistrationEmailId;
	}
	
	public WebElement getPasswordForNewUserRegistration(){
		return inputNewRegistrationNewPassword;
	}
	
	public WebElement getPasswordConfirmationForNewUserRegistration(){
		return inputNewRegistrationNewPasswordConfirmation;
	}
	
	public WebElement getRegisterButtonForNewUserRegistration(){
		return buttonRegister;
	}
	
	public WebElement getRegistrationFailureMessage(){
		return messageRegistrationFailure;
	}

}
