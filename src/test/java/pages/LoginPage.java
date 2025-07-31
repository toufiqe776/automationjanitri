package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.BaseTest;

public class LoginPage {
	 WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    //find element 
	    @FindBy(id="formEmail")
	    WebElement userId;
	    
	    @FindBy(id="formPassword")
	    WebElement password;
	    
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement loginBtn;
	    
	    @FindBy(xpath="//p[@class='normal-text']")
	    WebElement erroeMessage;
	    
	    @FindBy(xpath="//img[@alt=' Password Visible']")
	    WebElement passwordVisibleToggle;
	    
	    @FindBy(xpath="//img[@alt='Password Not Visible']")
	    WebElement passwordNotVisibleToggle;
	    
	    @FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/form/div[2]/img")
	    WebElement eyeIcon;
	    
	    
	    //action 
	    public void clickOnLoginBtn() {
	    	loginBtn.click();
	    }
	    
	    public String getEorroeMessage() {
	    	return erroeMessage.getText();
	    }
	    
	    public boolean isLoginButtonEnabled() {
	        return loginBtn.isEnabled();
	    }
	    
	    public boolean isLoginButtonDisplayed() {
	        return loginBtn.isDisplayed();
	    }
	    //enter userid 
	    public void  enterUserId(String username) {
	    	userId.clear();
	    	userId.sendKeys(username);
	    }
	    //enter password
	    public void enterPassword(String pass) {
	    	password.clear();
	    	password.sendKeys(pass);
	    }

	    public String getPasswordInputType() {
	        return password.getAttribute("type");
	    }
	    
	    public void togglePasswordVisibility() {
	    	passwordVisibleToggle.click();
	    }
	    
	    public boolean isUseridFieldDisplayed() {
	        return userId.isDisplayed();
	    }
	    
	    public boolean isPasswordFieldDisplayed() {
	        return password.isDisplayed();
	    }

		public String getPageTitle() {
			
			return null;
		}

		public boolean isPasswordToggleDisplayed() {
			
			return eyeIcon.isDisplayed();
		}
		

	    public void waitForLoginPageToLoad() {
	        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(userId));
	    }

	

		

		
	    
	    
	   

}
