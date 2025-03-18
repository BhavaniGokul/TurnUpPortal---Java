package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.*;

import Pages.*;

public class TM_Test {
	
	WebDriver driver;
	
	@BeforeTest
	public void SetupTest() throws InterruptedException
	{   //Open browser
	    driver = new ChromeDriver();

	    //Login Page object initialization and definition
	    LoginPage loginPageObj = new LoginPage();
	    loginPageObj.LoginActions(driver);


	    //Home page object initialization and definition
	    HomePage homePageObj = new HomePage();
	    homePageObj.NavigateToTMPage(driver);
    
	}
	@Test (priority = 1)
	
	public void CreateTimeTest() throws InterruptedException
	{
	    //Create Time record
	    //TM_Page object initialization and definition
	    TMPage tMPageobj = new TMPage(); 
	    tMPageobj.CreateTimeRecord(driver);            
	}
	
	@Test (priority = 2)
	public void EditTimeTest() throws InterruptedException
	{
	    //Edit Time record
	    TMPage tMPageobj = new TMPage();
	    tMPageobj.EditTimeRecord(driver);            
	}
	
	@Test(priority = 3)
	public void DeleteTimeTest() throws InterruptedException
	{
	    //Delete Time record
	    TMPage tMPageobj = new TMPage();
	    tMPageobj.DeleteTimeRecord(driver);
	}
	
	@AfterTest
	public void CloseTestRun()
	{
	    driver.quit();
	}
	
}
