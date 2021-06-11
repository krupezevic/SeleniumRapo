package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;
import pages.SignInPage;


public class BaseTests {
	WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	ExcelReader citacIzExcela;
	String homeUrl;
	
	@BeforeClass
	public void preSihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//mainNavigation = new MainNavigation(driver);
		//myAccountPage =  new MyAccountPage(driver);
		homePage =  new HomePage(driver);
		signInPage = new SignInPage(driver);
		citacIzExcela =  new ExcelReader("data/seleniumR.xlsx");
		homeUrl = "http://automationpractice.com/index.php";
	}
	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
}