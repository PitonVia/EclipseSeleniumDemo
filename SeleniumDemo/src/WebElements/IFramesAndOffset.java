package WebElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IFramesAndOffset {


    WebDriver driver;
    String baseURL;
    JavascriptExecutor js; // for running js commands

    @Before
    public void setUp() throws Exception {
        
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Dev\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        
        js = (JavascriptExecutor) driver; // cast jsExecutor to driver
        baseURL = "https://www.seoreviewtools.com/valuable-backlinks-checker/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	// Want to check the "I'm not a robot" checkbox - the pop-up dialog will open
    	// Then, on the pop-up we want to click on Verify button 
    	
    	driver.get(baseURL);
    	
    	// SCROLLING DOWN using JS
        // picking a large vertical # '1900' to make sure it goes all the way down:
        js.executeScript("window.scrollBy(0,700);");
    	                
        // I'm not a robot checkbox is inside an iFrame --> need to locate the iFrame first
        // Find out how many iFrames exist for a page 
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("There are " + size + " iFrame(s) of the current webpage.");
        
        // Create a loop to go through all the iFrames
        for (int i=0; i<size; i++) {
        	
        	// switch to the iFrame starting from i = 0
        	driver.switchTo().frame(i);
        	
        	// How many imNotRobot elements are present inside the iFrame 
        	int count = driver.findElements(By.className("recaptcha-checkbox-checkmark")).size();
        	System.out.println("there is " + count + " checkbox on the iFrame " + i);
        	
        	// if element is present in the iFrame 
        	if (count > 0) {
        		
        		driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
        		break;
        	} 
        	
        	System.out.println("proceeding to the next loop iteration");
        }
        
        // Unless there is another iFrame nested inside the first 
        // iFrame, remember to switch back to the main window
        driver.switchTo().defaultContent();
        Thread.sleep(5000L);
        
        
        // Now have to locate 'Verify' button by finding correct offset values in relation to 
        // some identifiable element:
        WebElement btn = driver.findElement(By.cssSelector("button.btn.btn-default.green-bdr"));
        
        // Using Actions class to hover over the element:
        Actions action = new Actions(driver);
        
        // hover over the webelement and click
        action.moveToElement(btn).click().build().perform();
        
        action.moveToElement(btn, 30, 0).click().build().perform();
        Thread.sleep(500L);
        action.moveToElement(btn, 30, 30).click().build().perform();
        Thread.sleep(500L);
        action.moveToElement(btn, 335, 480).click().build().perform();
        
        Thread.sleep(2000L);
        
    }
        
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000L);
	    driver.close();
	}

}
