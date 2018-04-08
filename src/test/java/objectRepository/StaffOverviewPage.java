package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffOverviewPage {

	private WebDriver driver;
	
	public StaffOverviewPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='col-md-4']/button/span[@class='ng-scope']")
	private WebElement buttonCreateStaff;
	
	@FindBy(css="#searchQuery")
	private WebElement inputSearchQuery;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	private WebElement buttonSearchStaff;
	
	@FindBy(xpath="//*[text()='View']")
	private WebElement buttonViewStaff;
	
	@FindBy(xpath="//*[text()='Edit']")
	private WebElement buttonEditStaff;
	
	@FindBy(xpath="//*[text()='Delete']")
	private WebElement buttonDeleteStaff;
	
	@FindBy(linkText="<<")
	private WebElement linkFirst;
	
	@FindBy(linkText=">>")
	private WebElement linkLast;
	
	@FindBy(linkText="<")
	private WebElement linkPrevious;
	
	@FindBy(linkText=">")
	private WebElement linkNext;
	
	@FindBy(xpath="//*[@name='name']")
	private WebElement formInputName;
	
	@FindBy(xpath="//*[@name='related_branch']")
	private WebElement formInputRelatedBranch;
	
	@FindBy(xpath="//*[text()='Cancel']")
	private WebElement buttonCancelStaffCreation;
	
	@FindBy(xpath="//*[text()='Save']")
	private WebElement buttonSaveStaffCreation;
	
	//table table-striped
	@FindBy(xpath="//*[@class='table table-striped']")
	public WebElement tableStaffInformation;
	
	@FindAll(value = { @FindBy(css="[class='table table-striped'] tr[class='ng-scope'] td:nth-child(2)") })
	private List<WebElement> rowStaffList; 
	
	
	public WebElement getCreateStaffButton(){
		return buttonCreateStaff;
	}
	
	public WebElement getSearchInput(){
		return inputSearchQuery;
	}
	
	public WebElement getSearchStaffButton(){
		return buttonSearchStaff;
	}
	
	public WebElement getViewStaffButton(){
		return buttonViewStaff;
	}
	
	public WebElement getEditStaffButton(){
		return buttonEditStaff;
	}
	
	public WebElement getFirstPageButton(){
		return linkFirst;
	}
	
	public WebElement getLastPageButton(){
		return linkLast;
	}
	
	public WebElement getNextPageButton(){
		return linkNext;
	}
	
	public WebElement getPreviousPageButton(){
		return linkPrevious;
	}
	
	public WebElement getFormInputName(){
		return formInputName;
	}
	
	public WebElement getFormInputBranch(){
		return formInputRelatedBranch;
	}
	
	public WebElement getCancelButton(){
		return buttonCancelStaffCreation;
	}
	
	public WebElement getSaveButton(){
		return buttonSaveStaffCreation;
	}
	
	public WebElement getStaffListTable(){
		return tableStaffInformation;
	}
	
	public List<WebElement> getStaffTableRows(){
		return rowStaffList;
	}
}
