package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInfoPage;
import pages.MyWishlistsPage;
import pages.SignInPage;
import pages.UpdateAddressPage;


public class BaseTests {
	WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	ExcelReader citacIzExcela;
	String homeUrl;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
    MyPersonalInfoPage myPersonalInfoPage;
    MyWishlistsPage myWishlistsPage;
    UpdateAddressPage updateAddressPage;
    
	@BeforeClass
	public void preSvihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		homePage =  new HomePage(driver);
		signInPage = new SignInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		myPersonalInfoPage = new MyPersonalInfoPage(driver);
		myWishlistsPage = new MyWishlistsPage(driver);
		updateAddressPage = new UpdateAddressPage(driver);
		
		citacIzExcela =  new ExcelReader("data/seleniumR.xlsx");
		homeUrl = "http://automationpractice.com/index.php";
	}
	@AfterClass
	public void posleSvihTestova() {
		driver.close();
	}
}