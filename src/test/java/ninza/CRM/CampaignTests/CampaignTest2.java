package ninza.CRM.CampaignTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninza.CRM.ObjectRepository.CampaignPage;
import ninza.CRM.ObjectRepository.CreateCampaignPage;
import ninza.CRM.ObjectRepository.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;

public class CampaignTest2 extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void tc_001_createCampaignTest() throws EncryptedDocumentException, IOException
	{
		//Read Test data from Excel
		String CAMPAIGNNAME = fUtil.readDataFromExcel("Integration", 1, 2);
	    String TARGETSIZE = fUtil.readDataFromExcel("Integration", 1, 3);
	    
	    //Click on campaign link 
	    DashBoardPage dp = new DashBoardPage(driver);
	    dp.clickOnCampaignsLnk();
	    
	    //Click on create campaign button
	    CampaignPage cp = new CampaignPage(driver);
	    cp.clickOnCreateCampaignBtn();
	    
	    //Create campaign with mandatory info
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
	    
	    		
	
	}
	
	@Test(groups = "RegressionSuite")
	public void sample()
	{
		System.out.println("Sample");
	}

}
