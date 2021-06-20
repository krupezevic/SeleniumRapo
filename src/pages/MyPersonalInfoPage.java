package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyPersonalInfoPage {
	 
	 
	    WebDriver driver;
		
		WebElement mrRadioButton;
		WebElement mrsRadioButton;
		WebElement curentPassswordInputField;
		WebElement newPasswordInputField;
		WebElement confirmationInputField;
		WebElement saveButton;
	    WebElement firstNameInputField;
	     WebElement lastNameInputField;
	     WebElement errorMessage;
	     
	     
	     public MyPersonalInfoPage(WebDriver driver) {
	 		super();
	 		this.driver = driver;
	 	}
	  

	 	public WebElement getMrRadioButton() {
	 		return driver.findElement(By.id("id_gender1"));
	 	}

	 	public WebElement getMrsRadioButton() {
	 		return driver.findElement(By.id("id_gender2"));
	 	}
	 	public WebElement getSelectedMr() {
			return driver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]/span"));
		}

		public WebElement getSelectedMrs() {
			return driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]/span"));
		}
	 	public WebElement getFirstNameInputField() {
			return driver.findElement(By.id("firstname"));
		}
	 	public WebElement getLastNameInputField() {
			return driver.findElement(By.id("lastname"));
		}

	 	public WebElement getCurentPassswordInputField() {
	 		return driver.findElement(By.id("old_passwd"));
	 	}

	 	public WebElement getNewPasswordInputField() {
	 		return driver.findElement(By.id("passwd"));
	 	}

	 	public WebElement getConfirmationInputField() {
	 		return driver.findElement(By.id("confirmation"));
	 	}
	 	

	 	public WebElement getSaveButton() {
	 		return driver.findElement(By.name("submitIdentity"));
	 	}

	 	public void MrRadioButtonClick() {
	 		this.getMrRadioButton().click();
	 	}

	 	public void MrsRadioButtonClick() {
	 		this.getMrsRadioButton().click();
	 	}

	 	public boolean isSelectedMr() {
			return this.getSelectedMr().getAttribute("class").equals("checked");
		}

		public boolean isSelectedMrs() {
			return this.getSelectedMrs().getAttribute("class").equals("checked");
		}

	 	public void insertCurrentPassword(String password) {
	 		this.getCurentPassswordInputField().clear();
	 		this.getCurentPassswordInputField().sendKeys(password);

	 	}

	 	public void insertNewPassword(String password) {
	 		this.getNewPasswordInputField().clear();
	 		this.getNewPasswordInputField().sendKeys(password);

	 	}

	 	public void confirmNewPassword(String password) {
	 		this.getConfirmationInputField().clear();
	 		this.getConfirmationInputField().sendKeys(password);

	 	}
	 	
	 	public void saveButtonClick() {
	 		this.getSaveButton().click();
	 	
	 	}
	 	
	 	public WebElement getErrorMessage() {
			return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
		}
	 	
	 	public String textErrorMessage() {
	 		return this.getErrorMessage().getText();
	 	}
	 	public void clearFirstName() {
			this.getFirstNameInputField().clear();
		}
}
