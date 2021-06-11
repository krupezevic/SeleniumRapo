package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	WebDriver driver;
	WebElement emailInputField;
	WebElement passwordInputField;
	
	WebElement signInButton;
	WebElement signOutButton;
	
	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public void insertEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}
	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	}
	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
	}
	public String textFromLogOutButton() {
		return this.getSignOutButton().getText();
	}
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}
	public WebElement getTextWrongCredentialsLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	
	public String textWrongCredentialsLabel() {
		return this.getTextWrongCredentialsLabel().getText();
	}
	public String textFromSignInButton() {
		return this.getSignInButton().getText();
	}
}
