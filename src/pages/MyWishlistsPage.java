package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyWishlistsPage {
	WebDriver driver;
	WebElement tableWishlist;
	WebElement tableQuantity;
	WebElement nameField;
	WebElement saveButton;
	WebElement wishlistTableName;
	WebElement wishlistTableName1;
	WebElement wishlistTableName2;
	WebElement wishlistTableName3;
	
	WebElement deleteWishlistButton;
	
	WebElement pageBody;
	public MyWishlistsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getTableWishlist() {
		return driver.findElement(By.id("block-history"));
	}
	
	public WebElement getTableQuantity() {
		return driver.findElement(By.xpath("//*[@id=\"wishlist_34734\"]/td[2]"));
	}
	
	public String textFromTableQuantity() {
		return this.getTableQuantity().getText();
	}
	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getWishlistTableName() {
		return driver.findElement(By.linkText("ListTest"));
	}
	
	public WebElement getWishlistTableName1() {
		return driver.findElement(By.linkText("Listtest1"));
	}

	public WebElement getWishlistTableName2() {
		return driver.findElement(By.linkText("Listtest2"));
	}
	public WebElement getWishlistTableName3() {
		return driver.findElement(By.linkText("Listtest3"));
	}


	public WebElement getDeleteWishlistButton() {
		return driver.findElement(By.className("icon-remove"));
	}

	public WebElement getPageBody() {
		return driver.findElement(By.xpath("//body"));
	}	

	public void enterName(String string) {
		this.getNameField().sendKeys(string);
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public String wishlistTableNameText() {
		return this.getWishlistTableName().getText();
	}
	
	public String wishlistTableName1Text() {
		return this.getWishlistTableName1().getText();		
	}
	
	public String wishlistTableName2Text() {
		return this.getWishlistTableName2().getText();
	}
	public String wishlistTableName3Text() {
		return this.getWishlistTableName3().getText();
	}
	
	public void deleteWishlistButtonClick() {
		this.getDeleteWishlistButton().click();
		driver.switchTo().alert().accept();
	}
	
	public void pageBodyEnterClick() {
		this.getPageBody().sendKeys(Keys.ENTER);
	}

	public int wishlistCount() {
		List<WebElement> wishlistList = driver.findElements(By.className("wishlist_delete"));
		return wishlistList.size();
	}
	
}
