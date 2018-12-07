package WebElements;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestedOptionsWithJSExecutor {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js; // for running js commands

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        
        js = (JavascriptExecutor) driver; // cast jsExecutor to driver
        baseURL = "https://www.ksrtc.in/oprs-web/guest/home.do?h=1";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// We want to validate that when we type in 'ben' there is an 
    	// auto-suggested option for 'BENGALURU INTERNATION AIPORT'
    	
    	// click on the Leaving From text box
    	driver.findElement(By.id("fromPlaceName")).click();
    	
    	// type in the required text 'ben'
    	driver.findElement(By.id("fromPlaceName")).sendKeys("ben");
    	
    	// In case the text will not match to avoid infinite loop, we want 
    	// to declare a var to break from the loop after 10 unsuccessful attempts
    	int attempt = 0;
    	
    	while (true) {
    		// Use the arrow down key option to access the auto-suggested options
    		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
    		attempt ++;
    		Thread.sleep(250);
    		
    		// Selenium cannot identify hidden text or element (AJAX) 
        	// However, JavaScript DOM can extract hidden elements
    		System.out.println(js.executeScript("return document.getElementById(\"fromPlaceName\").value;")
    				.toString());
    		
    		if (js.executeScript("return document.getElementById(\"fromPlaceName\").value;")
    				.toString().equals("BENGALURU INTERNATION AIPORT")) {
    			break;
    		}
    		
    		// after running 10 times, if the text will not be matched, the loop will end
    		if (attempt==10) {
    			System.out.println("the text did not match");
    			break;
    		}		
    	} 
	}
    
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000L);
	    driver.close();
	}


}
