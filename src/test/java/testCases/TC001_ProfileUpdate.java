package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_ProfileUpdate extends BaseClass{
	
	@Test
	public void loginToApplication() throws InterruptedException {
		
		lp.loginToAccount("fmnagarahalli@gmail.com", "Gate@1998");
		lp.goToProfile();
		WebElement edit_icon=driver.findElement(By.xpath("//span[@class='edit icon']"));
		
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", edit_icon);
		//Thread.sleep(20000);
		WebElement save=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		wait.until(ExpectedConditions.visibilityOf(save));
		js.executeScript("arguments[0].click();", save);
		System.out.println("profile updated");
	
	}
}
