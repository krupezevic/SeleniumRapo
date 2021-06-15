package tests;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


	public class MyPersonalInfoTests extends BaseTests {

		@BeforeMethod
		public void beforMethod() throws InterruptedException {
			driver.navigate().to(homeUrl);
			driver.manage().window().maximize();
			signIn();
		}

		@Test(priority = 0)
		public void radioButtonChecked() throws InterruptedException {
			
			myAccountPage.myPersonalInfoButtonClick();
			Thread.sleep(4000);
			myPersonalInfoPage.MrsRadioButtonClick();
			myPersonalInfoPage.MrRadioButtonClick();
			
			assertEquals(myPersonalInfoPage.isSelectedMrs(),false);
	
		}
		
		@Test(priority = 5)
		public void emptyFirstName() {
		
			myAccountPage.myPersonalInfoButtonClick();
			myPersonalInfoPage.clearFirstName();
			String password = citacIzExcela.getStringData("TC1", 5, 2);
			myPersonalInfoPage.insertCurrentPassword(password);
			myPersonalInfoPage.saveButtonClick();

			String textForAssertion = citacIzExcela.getStringData("TC13", 9, 2);
			String actualText = myPersonalInfoPage.textErrorMessage();
			assertEquals(actualText, textForAssertion);
		}
		
		
		@AfterMethod
		public void posleSvakogTesta() throws InterruptedException {		
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		}
		
		public void signIn() throws InterruptedException {
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
}
