package ninza.CRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule no 1
	
	//Rule 2: Identify webelemnts using @FindBy, @FindAll, @FindBys
    // @FindBY - IDENTIFY Single/Multiple webelemnt using Single Locator
	@FindBy(id = "username") 
	private WebElement userNameTF; 
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement signInBtn;
	
	//Rule 3: Create a contsructor and initialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule 4: provide getters
	
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	//Business library
	//Generic method but they are specific to a application
	//reusable inside application
	//Business logic we are writing inside a method
	//use the webelements from current pom class only
	
	/**
	 * This method will perform Login Operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();	
	}
	


}
