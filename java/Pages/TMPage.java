package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TMPage {
	public WebElement goToLastPageButton, saveButton, savedCode, newDescription, editedCode, editedDescription, codeInputField, descriptionInputField, priceInputField;

	public void CreateTimeRecord(WebDriver driver) throws InterruptedException
	{
		try
		{
			// Click on Create New button
			WebElement createNewButton = driver.findElement(By.xpath("(//div[@id='container']//a)[1]"));
			createNewButton.click();
		}
		catch(Exception ex)
		{
			Assert.fail("Create New Button has not been found");
		}

		//Click on TypeCode Dropdown
		WebElement typeCodeDropdown = driver.findElement(By.xpath("//span[@class='k-input']"));
		typeCodeDropdown.click();
		Thread.sleep(2000);

		//Click on TimeOption
		WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
		timeOption.click();
		Thread.sleep(2000);

		//Enter Code in the Code TextBox
		WebElement codeInputField = driver.findElement(By.xpath("//input[@id='Code']"));
		codeInputField.sendKeys("CodeBha001");

		//Enter Description in the decription TextBox
		WebElement descriptionInputField = driver.findElement(By.xpath("//input[@id='Description']"));
		descriptionInputField.sendKeys("This is a description for Bha001");

		//Enter Price in the price per unit TextBox
		WebElement priceInputField = driver.findElement(By.xpath("(//span[contains(@class,'numerictextbox')]//input)[1]"));
		priceInputField.sendKeys("7300");

		//Click on Save button
		saveButton = driver.findElement(By.xpath("//input[@id='SaveButton']"));
		saveButton.click();
		Thread.sleep(3000);


		//Click on goToLastPage button
		goToLastPageButton = driver.findElement(By.xpath("//span[contains(text(),'Go to the last page')]"));
		goToLastPageButton.click();

	}

	public void EditTimeRecord(WebDriver driver) throws InterruptedException
	{

		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Go to the last page')]")));

		//Click on goToLastPage button
		goToLastPageButton = driver.findElement(By.xpath("//span[contains(text(),'Go to the last page')]"));
		goToLastPageButton.click(); 

		Thread.sleep(2000);


		WebElement editButton = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[last()]/td[5]/a[contains(@class, 'k-grid-Edit')]"));
		editButton.click();
		Thread.sleep(2000);

		//Edit Code in the Code TextBox

		codeInputField = driver.findElement(By.xpath("//input[@id='Code']"));
		codeInputField.clear();
		codeInputField.sendKeys("CodeBha001edited");
		Thread.sleep(2000);

		//Edit Description in the decription TextBox
		descriptionInputField = driver.findElement(By.xpath("//input[@id='Description']"));
		descriptionInputField.clear();
		descriptionInputField.sendKeys("Des Edited");
		Thread.sleep(2000);

		//Click on Save button
		saveButton = driver.findElement(By.xpath("//input[@id='SaveButton']"));
		saveButton.click();
		Thread.sleep(2000);



		//Check Time record has been edited successfully

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Go to the last page')]")));

		//Click on goToLastPage button
		goToLastPageButton = driver.findElement(By.xpath("//span[contains(text(),'Go to the last page')]"));
		goToLastPageButton.click();

		savedCode = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[last()]/td[1]"));

		//Compare edited Time record has been listed correctly in the list page


		//Compare edited Time record has been listed correctly in the list page
		Assert.assertEquals("CodeBha001edited", savedCode.getText());

	}


	public void DeleteTimeRecord(WebDriver driver) throws InterruptedException
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Go to the last page')]")));

		//Click on goToLastPage button
		goToLastPageButton = driver.findElement(By.xpath("//span[contains(text(),'Go to the last page')]"));
		goToLastPageButton.click(); 

		Thread.sleep(2000);
		
		//Wait applied to delete button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div[3]/table/tbody/tr[last()]/td[5]/a[2]")));
		deleteButton.click();

		//explicit wait applied to alert
		WebDriverWait alertwait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the alert is present
		Alert alert = alertwait.until(ExpectedConditions.alertIsPresent());
		alert.accept();




		//Check Time record has been deleted successfully

		Thread.sleep(3000);
		//Click on goToLastPage button
		goToLastPageButton = driver.findElement(By.xpath("//span[contains(text(),'Go to the last page')]"));
		goToLastPageButton.click();

		savedCode = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[last()]/td[1]"));

		//Compare edited Time record has been listed correctly in the list page
		Assert.assertNotEquals("CodeBha001edited", savedCode.getText());
	}
}
