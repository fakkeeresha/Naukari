package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	@BeforeTest
	public void applicationSetUp() throws IOException {
	//	WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
	//.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(getPropertey("url"));
		lp=new LoginPage(driver);
		js=(JavascriptExecutor)driver;
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}
	
	public String getPropertey(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//config.properties");
		prop.load(fis);
		String key1=prop.getProperty(key);
		System.out.println(key1);
		return key1;
	}

}
