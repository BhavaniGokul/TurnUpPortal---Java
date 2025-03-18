package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

public class HomePage {
	public void NavigateToTMPage(WebDriver driver) throws InterruptedException
	{ 
		Thread.sleep(2000);
		try
		{    //Click on Administration tab
			WebElement administrationTab = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
			administrationTab.click();

			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='dropdown-menu']//a)[3]")));


			//Click on Time and Materials tab
			WebElement timeAndMaterialsTab = driver.findElement(By.xpath("(//ul[@class='dropdown-menu']//a)[3]"));
			timeAndMaterialsTab.click();

		}
		catch(Exception ex)
		{
			Assert.fail("Turnup portal page is not displayed " + ex.getMessage());
		}

	}
}
