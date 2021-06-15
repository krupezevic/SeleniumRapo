package tests;

import static org.testng.Assert.assertEquals;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends BaseTests{

	
	@BeforeMethod
	public void beforeAllMethods() throws InterruptedException {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		signIn();
	}
	
	//success
	@Test (priority = 0)
	public void addOneWishlist() throws InterruptedException {
		myAccountPage.myWishlistsButtonClick();
		String name = citacIzExcela.getStringData("TC14", 6, 2);
		addWishlistProcedure(name);	
	    Thread.sleep(4000);
		int numForAssertion = 1;
		int wishlistCount = myWishlistsPage.wishlistCount();
		assertEquals(wishlistCount, numForAssertion);
		
		//or
		//String actualWishlistName = myWishlistsPage.wishlistTableNameText();
		//String wishlistNameForAssertion = name;
		//assertEquals(actualWishlistName, wishlistNameForAssertion);
	
	}
	
	@Test (priority = 5)
	public void addThreeWishlists() throws InterruptedException {
		myAccountPage.myWishlistsButtonClick();
		String name = citacIzExcela.getStringData("TC15", 5, 2);
		addWishlistProcedure(name);	
		
		//String actualWishlistName = myWishlistsPage.wishlistTableName1Text();
		//String wishlistNameForAssertion = name;
		//assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		name = citacIzExcela.getStringData("TC15", 9, 2);
		addWishlistProcedure(name);	
		
		//actualWishlistName = myWishlistsPage.wishlistTableName2Text();
		//wishlistNameForAssertion = name;
		//assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		name = citacIzExcela.getStringData("TC15", 13, 2);
		addWishlistProcedure(name);	
		Thread.sleep(4000);
		
		//actualWishlistName = myWishlistsPage.wishlistTableName3Text();
		//wishlistNameForAssertion = name;
		//assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		
		int numForAssertion = 4;
		int wishlistCount = myWishlistsPage.wishlistCount();
		assertEquals(wishlistCount, numForAssertion);
		
	}

	@Test (priority = 10)
	public void deleteWishlist() throws InterruptedException {
		myAccountPage.myWishlistsButtonClick();
		myWishlistsPage.deleteWishlistButtonClick();
		Thread.sleep(5000);
		
		int numForAssertion = 3;
		int wishlistCount = myWishlistsPage.wishlistCount();
		assertEquals(wishlistCount, numForAssertion);
	
	}
	


	@AfterMethod
	public void afterAllMethods() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	public void addWishlistProcedure(String name) {
		myWishlistsPage.getNameField().clear();
		myWishlistsPage.enterName(name);		
		myWishlistsPage.saveButtonClick();		
		
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
