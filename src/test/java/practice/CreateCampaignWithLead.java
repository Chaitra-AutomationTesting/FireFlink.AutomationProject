package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ninza.CRM.ObjectRepository.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateCampaignWithLead {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Create Object Of Utilities
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver;
		
		//Read Data From Property File
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read Test Data
		String CAMPAIGNNAME = fUtil.readDataFromExcel("Integration", 1, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = fUtil.readDataFromExcel("Integration", 1, 3);
		
		String LEADNAME = fUtil.readDataFromExcel("Integration", 1, 4);
		String COMPANY = fUtil.readDataFromExcel("Integration", 1, 5);
		String LEADSOURCE = fUtil.readDataFromExcel("Integration", 1, 6);
		String LEADSTATUS = fUtil.readDataFromExcel("Integration", 1, 7);
		String INDUSTRY = fUtil.readDataFromExcel("Integration", 1, 8);
		String RATING = fUtil.readDataFromExcel("Integration", 1, 9);
		String PHONE = fUtil.readDataFromExcel("Integration", 1, 10);
		
		
		
		// Launch the browser - Run time polymorphism
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.addimplicitlyWait(driver);

		driver.get(URL);

		// Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
//		lp.getUserNameTF().sendKeys(USERNAME);
//		lp.getPasswordTF().sendKeys(PASSWORD);
//		lp.getSignInBtn().click();
		
		
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();

		// click on create Create campaign
		driver.findElement(By.xpath("//span[.='Create Campaign']")).click();

		// create campaign with mandatory fields
		driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGNNAME);
		driver.findElement(By.name("targetSize")).sendKeys(TARGETSIZE);
		//driver.findElement(By.name("expectedCloseDate")).sendKeys(DA);
		driver.findElement(By.xpath("//button[.='Create Campaign']")).click();

		Thread.sleep(7000);

		// Navigate to Leads
		driver.findElement(By.linkText("Leads")).click();

		// click on Create Lead
		driver.findElement(By.xpath("//span[.='Create Lead']")).click();

		// Create lead with campaign
		driver.findElement(By.name("name")).sendKeys(LEADNAME);
		driver.findElement(By.name("company")).sendKeys(COMPANY);
		driver.findElement(By.name("leadSource")).sendKeys(LEADSOURCE);
		driver.findElement(By.name("industry")).sendKeys(INDUSTRY);
		driver.findElement(By.name("leadStatus")).sendKeys(LEADSTATUS);
		driver.findElement(By.name("phone")).sendKeys(PHONE);
		driver.findElement(By.name("rating")).sendKeys(RATING);

		// navigate to campagin page
		driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();

		// Handle window popup
		wUtil.switchToWindow(driver, "Campaign");

		// search for campagin in child window
		WebElement selDropdown = driver.findElement(By.id("search-criteria"));
		wUtil.handleDropdown("Campaign Name", selDropdown);

		driver.findElement(By.id("search-input")).sendKeys(CAMPAIGNNAME);
		driver.findElement(By.xpath("//td[.='"+CAMPAIGNNAME+"']/following-sibling::td/child::button")).click();

		// switch the window control to main
		wUtil.switchToWindow(driver, "Ninza CRM");

		// Click on create lead
		driver.findElement(By.xpath("//button[.='Create Lead']")).click();

		// Validation
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]"));
		for (WebElement ele : list) {
			String leadInfo = ele.getText();
			if (leadInfo.equalsIgnoreCase("Chaitra")) {
				System.out.println(leadInfo);
				System.out.println("Lead added successfully");
				break;
			}
		}

		Thread.sleep(8000);

		// Logout
		WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wUtil.mouseOverAction(driver, ele);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		System.out.println("Logout successful");
	}

}
