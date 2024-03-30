package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//input[@id='passwordField']
	@FindBy(xpath="//a[@id='login_Layer']")
	WebElement homelogin;
	@FindBy(xpath="//input[@type='text'][1]")
	WebElement email;
	@FindBy(xpath="//input[@type='password']")
	WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn;
	@FindBy(css="div.nI-gNb-drawer__bars")
	WebElement profile;
	@FindBy(xpath="//a[@href='/mnjuser/profile?id=&altresid']")
	WebElement profileLink;
	@FindBy(xpath="//span[@class='edit icon']")
	WebElement editIcon;
	@FindBy(xpath="(//button[@class='btn-dark-ot'])[3]")
	WebElement savebtn;
	
	
	public void loginToAccount(String mail,String pass) {
		homelogin.click();
		email.sendKeys(mail);
		pwd.sendKeys(pass);
		btn.click();
	}
	
	public void goToProfile() throws InterruptedException {
		profile.click();
		profileLink.click();
		editIcon.click();
		Thread.sleep(2000);
//		editIcon.click();
//		Thread.sleep(2000);
		
	//	savebtn.click();
	}

}
