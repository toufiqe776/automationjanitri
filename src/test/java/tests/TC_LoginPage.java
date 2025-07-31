package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC_LoginPage extends BaseTest {

    LoginPage loginpage;

    @BeforeClass
    public void setupTest() {
        loginpage = new LoginPage(driver); 
    }
    


    @Test(priority = 1)
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        assertFalse(loginpage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test(priority = 2)
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
        loginpage.enterUserId("adc@gmail.com");
        loginpage.enterPassword("Admin@123");
        loginpage.clickOnLoginBtn();
        Thread.sleep(2000);
        String error = loginpage.getEorroeMessage();
        System.out.println("Error Message: " + error);
        assertTrue(error.toLowerCase().contains("invalid") || error.length() > 0, "Error message should be visible");
    }

    @Test(priority = 3)
    public void testPasswordMaskedbutton() throws InterruptedException {
        loginpage.enterPassword("admin123");
        assertEquals(loginpage.getPasswordInputType(), "password", "Password should be masked");

        loginpage.togglePasswordVisibility();
        Thread.sleep(1000);
        assertEquals(loginpage.getPasswordInputType(), "text", "Password should be visible");

        loginpage.togglePasswordVisibility();
        Thread.sleep(1000);
        assertEquals(loginpage.getPasswordInputType(), "password", "Password should be masked again");
    }

    @Test(priority = 4)
    public void testLoginPageElementsDisplayed() throws InterruptedException {
        assertTrue(loginpage.isUseridFieldDisplayed(), "Email input field is missing");
        assertTrue(loginpage.isPasswordFieldDisplayed(), "Password input field is missing");
        assertTrue(loginpage.isPasswordToggleDisplayed(), "Eye icon is missing");
        assertTrue(loginpage.isLoginButtonDisplayed(), "Login button is missing");
        assertTrue(loginpage.getPageTitle().contains("Janitri") || loginpage.getPageTitle().length() > 0, "Page title is missing");
    }
}
