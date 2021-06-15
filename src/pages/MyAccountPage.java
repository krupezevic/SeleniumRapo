package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressesButton;
	WebElement myWishlistsButton;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getMyAddressesButton() {
		return driver.findElement(By.className("icon-building"));
	}
	public void myAddressesButtonClick() {
		this.getMyAddressesButton().click();
	}
	
    public WebElement getMyPersonalInfoButton() {
	   return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
    }
    public void myPersonalInfoButtonClick() {
	  this.getMyPersonalInfoButton().click();
    }
    public WebElement getMyWishlistsButton() {  
		return driver.findElement(By.className("lnk_wishlist"));
	}
    //public WebElement getMyWishlistsButton() {
 	 //  return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[5]/a/span"));
     //}
     public void myWishlistsButtonClick() {
 	  this.getMyWishlistsButton().click();
     }
}
