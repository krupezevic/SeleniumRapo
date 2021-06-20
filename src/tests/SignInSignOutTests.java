package tests;

import static org.testng.Assert.assertEquals;
//import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInSignOutTests extends BaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	@Test(priority = 0)
	public void signInValidCredentials() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC1", 4, 2);
		String password = citacIzExcela.getStringData("TC1", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("TC1", 8, 2);
		String actualText = signInPage.textFromSignOutButton();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 5)
	public void signInValidEmailInvalidPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC2", 4, 2);
		String password = citacIzExcela.getStringData("TC2", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("TC2", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 10)
	public void signInInvalidEmailValidPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC3", 4, 2);
		String password = citacIzExcela.getStringData("TC3", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		//Thread.sleep(2000);
		String textForAssertion = citacIzExcela.getStringData("TC3", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 15)
	public void signInEmptyEmailValidPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC4", 4, 2);
		String password = citacIzExcela.getStringData("TC4", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		Thread.sleep(2000);
		String textForAssertion = citacIzExcela.getStringData("TC4", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 25)
	public void signInValidEmailEmptyPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC5", 4, 2);
		String password = citacIzExcela.getStringData("TC5", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("TC5", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 30)
	public void signInInvalidEmailInvalidPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC6", 4, 2);
		String password = citacIzExcela.getStringData("TC6", 5, 2);
		//String email = String.valueOf(citacIzExcela.getIntegerData("TC6", 4, 2));
		//String password = String.valueOf(citacIzExcela.getIntegerData("TC6", 5, 2));
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		Thread.sleep(2000);
		String textForAssertion = citacIzExcela.getStringData("TC6", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 35)
	public void signInEmptyEmailEmptyPass() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC7", 4, 2);
		String password = citacIzExcela.getStringData("TC7", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("TC7", 8, 2);
		String actualText = signInPage.textWrongCredentialsLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 40)
	public void signOut() throws InterruptedException {
		homePage.signInButtonClick();
		String email = citacIzExcela.getStringData("TC8", 4, 2);
		String password = citacIzExcela.getStringData("TC8", 5, 2);
		signInPage.insertEmail(email);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
		Thread.sleep(2000);
		signInPage.signOutButtonClick();
		String textForAssertion = citacIzExcela.getStringData("TC8", 9, 2);
		String actualText = signInPage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}