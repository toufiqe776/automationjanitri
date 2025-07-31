package tests;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadConfig;




public class BaseTest {

	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	public static WebDriver driver;



	@BeforeClass
	public void setup() throws InterruptedException
	{

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			 WebDriverManager.chromedriver().setup();
		        //  Notification allow 
		        Map<String, Object> prefs = new HashMap<>();
		        // 1 = allow, 2 = block
		        prefs.put("profile.default_content_setting_values.notifications", 1);

		        ChromeOptions options = new ChromeOptions();
		        options.setExperimentalOption("prefs", prefs);

		        driver = new ChromeDriver(options);
		        driver.manage().window().maximize();	        
		    	
			    break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		//implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//open url 
		
		driver.get(url);
		    
	}

//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		driver.quit();
//	}
}
