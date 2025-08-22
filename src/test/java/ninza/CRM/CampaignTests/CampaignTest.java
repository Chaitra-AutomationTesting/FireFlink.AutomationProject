package ninza.CRM.CampaignTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninza.CRM.ObjectRepository.CampaignPage;
import ninza.CRM.ObjectRepository.CreateCampaignPage;
import ninza.CRM.ObjectRepository.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;

@Listeners(ninzaCRM.genericUtilities.ListenersImplementation.class)
public class CampaignTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void tc_001_createCampaignTest() throws EncryptedDocumentException, IOException
	{
		
		System.out.println("Smoke Test - Create Campaign");
//		//Read Test data from Excel
//		String CAMPAIGNNAME = fUtil.readDataFromExcel("Integration", 1, 2);
//	    String TARGETSIZE = fUtil.readDataFromExcel("Integration", 1, 3);
//	    
//	    //Click on campaign link 
//	    DashBoardPage dp = new DashBoardPage(driver);
//	    dp.clickOnCampaignsLnk();
//	    Reporter.log("Clicked on campaign link",true);//report print in console
//	    
//	    //Click on create campaign button
//	    CampaignPage cp = new CampaignPage(driver);
//	    cp.clickOnCreateCampaignBtn();
//	    Reporter.log("Clicked on create campaign button",true);
//	    
//	    
//	    Assert.fail();
//	    //Create campaign with mandatory info
//	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
//	    ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
//	    Reporter.log("campaign created successfully", true);
//	    		
	
	}
	
	@Test(groups = "RegressionSuite")
	public void sample()
	{
		Assert.fail();
		System.out.println("Sample");
	}

}
