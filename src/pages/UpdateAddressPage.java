package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateAddressPage {
	WebDriver driver;
	WebElement addressInputField;
	WebElement saveButton;
	WebElement cityInputField;
	WebElement stateDropDownMenu;
	WebElement postalCodeInputField;
	WebElement homePhoneInputField;
	WebElement mobilePhoneInputField;
	WebElement addressTitle;

	public UpdateAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));

	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateDropDownMenu() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getPostalCodeInputField() {
		return driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
	}

	public WebElement getHomePhoneInputField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}
	
    public void saveButtonClick() {
		this.getSaveButton().click();
	}
    
	public void insertAddress(String newAddress) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(newAddress);
	}


	public void insertCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
	}

	public void stateDropDownManuClick() {
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("3");
	}

	public void insertPostalCode(String postalCode) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(postalCode);
	}

	public void insertHomePhone(String homePhone) {
		this.getHomePhoneInputField().clear();
		this.getHomePhoneInputField().sendKeys(homePhone);
	}

	public void insertMobilePhone(String mobilePhone) {
		this.getMobilePhoneInputField().clear();
		this.getMobilePhoneInputField().sendKeys(mobilePhone);
	}

	public void insertAddressTitle(String nameAddress) {
		this.getAddressTitle().clear();
		this.getAddressTitle().sendKeys(nameAddress);
	}
}
