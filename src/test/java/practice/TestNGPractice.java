package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(dataProvider = "customerInfo")
	public void create(String name, int id ) //cust - Name ,ID
	{
		//Assert.fail();
		System.out.println(name+" and "+id+" -created");
		
	}
	
	@DataProvider(name = "customerInfo")
	public Object[][] getData()
	{              // 4 rows and 2 col -> 4 data sets with 2 info each
		Object[][] data = new Object[4][2];
		
		data[0][0] = "Batman";
		data[0][1] = 1;
		
		data[1][0] = "Spiderman";
		data[1][1] = 2;
		
		data[2][0] = 3;
		data[2][1] = 3;
		
		data[3][0] = "Hulk";
		data[3][1] = 4;
		
		return data;
	}
	
	

}
