package tests;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MyAddressesTests extends BaseTests{
       
	@BeforeMethod
	public void preSvakogTesta() throws InterruptedException {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	     signIn();
	}
	
	
	@Test(priority = 0)
	public void updateAddress() throws InterruptedException {
		
		WebDriverWait wdwait = new WebDriverWait(driver, 10);
		wdwait.until(ExpectedConditions.elementToBeClickable(myAccountPage.getMyAddressesButton()));
		myAccountPage.myAddressesButtonClick();
		Thread.sleep(3000);
		wdwait.until(ExpectedConditions.elementToBeClickable(myAddressesPage.getUpdateButton()));
		myAddressesPage.updateButtonClick();
		Thread.sleep(2000);
		String newAddress = citacIzExcela.getStringData("TC9", 10, 2);
		updateAddressPage.insertAddress(newAddress);
		updateAddressPage.saveButtonClick();

		String textForAssertion = citacIzExcela.getStringData("TC9", 14, 2);
		String actualText = myAddressesPage.textMyAddress();
		assertEquals(actualText, textForAssertion);
	}
	
	
	@Test(priority = 5)
	public void addNewAddress() throws InterruptedException {
		 WebDriverWait wdwait = new WebDriverWait(driver, 10);
		 wdwait.until(ExpectedConditions.elementToBeClickable(myAccountPage.getMyAddressesButton()));
	        myAccountPage.myAddressesButtonClick();
			wdwait.until(ExpectedConditions.elementToBeClickable(myAddressesPage.getAddANewAddressButton()));
			myAddressesPage.addANewAddressButtonClick();
			Thread.sleep(2000);
		String address = citacIzExcela.getStringData("TC11", 5, 2);
		updateAddressPage.insertAddress(address);
		String city = citacIzExcela.getStringData("TC11", 6, 2);
		updateAddressPage.insertCity(city);
		updateAddressPage.stateDropDownManuClick();
		Thread.sleep(3000);
		String postalCode = String.valueOf(citacIzExcela.getIntegerData("TC11", 8, 2));
		
		updateAddressPage.insertPostalCode(postalCode);
		String homePhone = citacIzExcela.getStringData("TC11", 9, 2);
		updateAddressPage.insertHomePhone(homePhone);
		String nameAddress = citacIzExcela.getStringData("TC11", 10, 2);
		updateAddressPage.insertAddressTitle(nameAddress);
		wdwait.until(ExpectedConditions.elementToBeClickable(updateAddressPage.getSaveButton()));
		updateAddressPage.saveButtonClick();

		String textForAssertion = citacIzExcela.getStringData("TC11", 14, 2);
		String actualText = myAddressesPage.textTittleAddress();
		assertEquals(actualText, textForAssertion);

	}
	@Test(priority = 10)
	public void deleteAddress() throws InterruptedException {
		
        WebDriverWait wdwait = new WebDriverWait(driver, 10);
		
        wdwait.until(ExpectedConditions.elementToBeClickable(myAccountPage.getMyAddressesButton()));
        myAccountPage.myAddressesButtonClick();
		wdwait.until(ExpectedConditions.elementToBeClickable(myAddressesPage.getDeleteButton()));
		myAddressesPage.deleteButtonClick();
		Thread.sleep(6000);
		int numForAssertion = 0;
		int addressCount = myAddressesPage.addressCount();
		assertEquals(addressCount, numForAssertion);
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
