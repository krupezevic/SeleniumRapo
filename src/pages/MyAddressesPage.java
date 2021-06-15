package pages;





import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyAddressesPage {
     WebDriver driver;
     WebElement updateButton;
     WebElement deleteButton;
     WebElement addANewAddressButton;
     WebElement saveButton;
     WebElement enterButton;
     WebElement textDeleteLabel;
     WebElement textTittleAddress;
     
     
     public MyAddressesPage(WebDriver driver) {
 		super();
 		this.driver = driver;
 	}
     public WebElement getUpdateButton() {
 		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[9]/a[1]"));
 	}
 	public void updateButtonClick() {
 		this.getUpdateButton().click();
 	}
	public WebElement getDeleteButton() {   
 		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[2]/span"));
 	}
 	
 	public void deleteButtonClick() {
		this.getDeleteButton().click();
		driver.switchTo().alert().accept();
	}
 	public WebElement getAddANewAddressButton() {
 		return driver.findElement(By.linkText("Add a new address"));
 	}
 	public void addANewAddressButtonClick() {
 		this.getAddANewAddressButton().click();
 	}
 	
 	public WebElement getSaveButton() {
 		return driver.findElement(By.xpath("//*[@id=\"submitAddress\"]/span"));
 	}
 	public void saveButtonClick() {
 		this.getSaveButton().click();
 	}
 	
 	public WebElement getTextDeleteLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]"));
	}
 	public String textDeleteLabel() {
		return this.getTextDeleteLabel().getText();
	}
 	
 	public WebElement getTextMyAddress() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]"));
	}
 	public String textMyAddress() {
		return this.getTextMyAddress().getText();
	}
 	public WebElement getTextTittleAddress() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div/ul/li[1]/h3"));
	}
 	public String textTittleAddress() {
		return this.getTextTittleAddress().getText();
	}
 	public int addressCount() {
 	List<WebElement> addressList = driver.findElements(By.cssSelector("col-xs-12.col-sm-6.address"));
 	return addressList.size();
 	}
}
