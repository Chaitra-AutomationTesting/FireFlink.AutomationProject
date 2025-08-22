package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninza.CRM.ObjectRepository.DashBoardPage;
import ninza.CRM.ObjectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * 
 * @author Chaitra M
 *
 */
public class BaseClass {

	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil = new FileUtility();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("============= DB Connection successful =================");
	}

	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		String URL = fUtil.readDataFromPropertyFile("url");
		
		
		if (BROWSER.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new EdgeDriver();
		}

		wUtil.maximizeWindow(driver);
		wUtil.addimplicitlyWait(driver);

		driver.get(URL);
		System.out.println("============"+BROWSER+" browser launch successful ===================");

		//For Listeners
		sdriver = driver;
		
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//LoginPage lp = new LoginPage(driver);
		//loginToApp(USERNAME, PASSWORD);
		
		System.out.println("=========== login to App ============");
	
	
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		//DashBoardPage dp = new DashBoardPage(driver);
		//dp.logoutOfApp(driver);
		
		System.out.println("=========== logout successful ===========");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		//driver.quit();
		System.out.println("============ Browesr closed successfully ==========");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("============= DB Connection closed =================");
	}

}
