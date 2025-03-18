package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	public void LoginActions(WebDriver driver) throws InterruptedException
	{ 
		//Launch TurnupPortal
		driver.get("http://horse.industryconnect.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			//Identify Username field and enter username
			WebElement userNameTextBox = driver.findElement(By.id("UserName"));
			userNameTextBox.sendKeys("hari");
		}
		catch(Exception ex)
		{
			Assert.fail("Username TextBox not located");
		}
	
	//Identify Password field and enter password
	WebElement passwordTextBox = driver.findElement(By.id("Password"));
	passwordTextBox.sendKeys("123123");

	//Identify login and Click on it
	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
	loginButton.click();
}
}

