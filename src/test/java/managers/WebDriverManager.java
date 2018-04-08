package managers;

import java.util.concurrent.TimeUnit;

import objectRepository.HomePage;
import objectRepository.LoginPage;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigFileReader;

public class WebDriverManager {

	public WebDriver driver;
	public ConfigFileManager fileReadManager;
	public ConfigFileReader config;
	public HomePage home;
	public PageObjectManager page;
	
	public WebDriverManager(){
		
	}
	
	public WebDriver getDriver(){
		return (driver==null)? driver = openBrowser():driver;
	}
	
	public WebDriver openBrowser(){
			
		String url = ConfigFileManager.getInstance().getConfiguration().getApplicationURL();
		String browser = ConfigFileManager.getInstance().getConfiguration().getApplicationBrowser();
		String chromedriverPath = ConfigFileManager.getInstance().getConfiguration().getChromeDriverPath();
		Long implicitWait = Long.parseLong(ConfigFileManager.getInstance().getConfiguration().getimplicitWait());
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",chromedriverPath);
			driver = new ChromeDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
	
	public void closeBrowser(){
		driver.close();
		
	}
	public void closeAllBrowsers(){
		driver.quit();
	}
	
	public void getValidLogin() throws InterruptedException{
		/*String userType = "admin";
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getLoginPage().getInputUserName().sendKeys("admin");
		page.getLoginPage().getInputPassword().sendKeys("admin");
		page.getLoginPage().getAuthenticationButton().click();
		//System.out.println(page.getLoginPage().getAuthenticationSuccessMessage().getText());
		Assert.assertTrue(page.getLoginPage().getAuthenticationSuccessMessage().getText().equals("You are logged in as user \""+userType+"\"."));
	*/
	}
	
	public void getInvalidUsername() throws InterruptedException{
		String userType = "admin";
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getLoginPage().getInputUserName().sendKeys("admin");
		page.getLoginPage().getInputPassword().sendKeys("admin");
		page.getLoginPage().getAuthenticationButton().click();
		//System.out.println(page.getLoginPage().getAuthenticationSuccessMessage().getText());
		Assert.assertTrue(page.getLoginPage().getAuthenticationSuccessMessage().getText().equals("You are logged in as user \""+userType+"\"."));
	}
	
	public void getInvalidPassword() throws InterruptedException{
		String userType = "admin";
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getLoginPage().getInputUserName().sendKeys("admin");
		page.getLoginPage().getInputPassword().sendKeys("admin");
		page.getLoginPage().getAuthenticationButton().click();
		//System.out.println(page.getLoginPage().getAuthenticationSuccessMessage().getText());
		Assert.assertTrue(page.getLoginPage().getAuthenticationSuccessMessage().getText().equals("You are logged in as user \""+userType+"\"."));
	}
	
	public void getLogout() throws InterruptedException{
		String userType = "admin";
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getLoginPage().getInputUserName().sendKeys("admin");
		page.getLoginPage().getInputPassword().sendKeys("admin");
		page.getLoginPage().getAuthenticationButton().click();
		//System.out.println(page.getLoginPage().getAuthenticationSuccessMessage().getText());
		//Assert.assertTrue(page.getLoginPage().getAuthenticationSuccessMessage().getText().equals("You are logged in as user \""+userType+"\"."));
		page.getHomePage().getAccountMenu().click();
		//Thread.sleep(5000);
		//System.out.println("Before = "+page.getHomePage().getLoginButton().isDisplayed());
		int count = page.getHomePage().getAccountMenuList().size();
		System.out.println(count);
		for(int i=0;i<count;i++){
			System.out.println(page.getHomePage().getAccountMenuList().get(i).getText());
			if(page.getHomePage().getAccountMenuList().get(i).getText().equals(" Log out")){
				//System.out.println();
				page.getHomePage().getAccountMenuList().get(i).click();
				break;
			}
		}
		Assert.assertTrue(page.getHomePage().getLoginButton().isDisplayed());
		
	}
	
	public void getRegister(){
		page = new PageObjectManager(driver);
		page.getHomePage().getAccountMenu().click();
		page.getHomePage().getUserRegistrationFromAccountMenu().click();
		page.getRegistrationPage().getLoginIdForNewUserRegistration().sendKeys("akshatnarang");
		page.getRegistrationPage().getEmailIdForNewUserRegistration().sendKeys("akshat55narang@gmail.com");
		page.getRegistrationPage().getPasswordForNewUserRegistration().sendKeys("liverpoolFC");
		page.getRegistrationPage().getPasswordConfirmationForNewUserRegistration().sendKeys("liverpoolFC");
		page.getRegistrationPage().getRegisterButtonForNewUserRegistration().click();
		Assert.assertEquals("Registration failed! Please try again later.", page.getRegistrationPage().getRegistrationFailureMessage().getText());
		
	}
	
	public void getForgotPassword(){
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getHomePage().getForgotPasswordLink().click();
		//admin@localhost
		//E-Mail address isn't registered! Please check and try again
		page.getPasswordResetPage().getResetPasswordEmail().sendKeys("admin@localhost.com");
		page.getPasswordResetPage().getResetPasswordButton().click();
		Assert.assertEquals("E-Mail address isn't registered! Please check and try again", page.getPasswordResetPage().getFailedResetPasswordMessage().getText());
	}
	
	public void getEntityList(){
		String userType = "admin";
		page = new PageObjectManager(driver);
		page.getHomePage().getLoginButton().click();
		page.getLoginPage().getInputUserName().sendKeys("admin");
		page.getLoginPage().getInputPassword().sendKeys("admin");
		page.getLoginPage().getAuthenticationButton().click();
		page.getHomePage().getEntitiesMenu().click();
		
		
		int count = page.getHomePage().getEntitiesList().size();
		for(int i=0;i<count;i++){
			System.out.println(page.getHomePage().getEntitiesList().get(i).getText());
			
		}
		
	}
	public static void main(String []args) throws InterruptedException{
	WebDriverManager web = new WebDriverManager();
	web.openBrowser();
	web.getEntityList();

	
	}

}
