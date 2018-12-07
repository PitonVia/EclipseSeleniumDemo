package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoComplete {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        baseURL = "http://qaclickacademy.com/practice.php";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// We want to enter the first 3 letters "uni" into the Suggestion Class box
    	// and select from the auto-completed dropdown "United States"
    	
    	WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
    	
    	Actions action = new Actions(driver);
    	
    	// Navigate to, click on and send keys 'uni' to the Auto-Suggest text box
    	action.moveToElement(suggestionBox).click().sendKeys("uni").build().perform();
    	
    	// METHOD 1 - use a List of drop-down options with for each loop
    	List<WebElement> options = driver.findElements(By.cssSelector("div.ui-menu-item-wrapper"));
    	
    	for (WebElement e : options ) {
    		
    		suggestionBox.sendKeys(Keys.ARROW_DOWN);
    		
    		Thread.sleep(500L);
    		
    		System.out.println(e.getText());
    		
    		if (e.getText().equals("United States")) {
    			e.click();
    			break;
    		}
    	}
    	
    	suggestionBox.clear();
    	action.moveToElement(suggestionBox).click().sendKeys("uni").build().perform();
    	
    	// METHOD 2 - use JavaScript to get text from the field with while loop
    	
    	int count = 0;
    	
    	while (true) {
    		
    		suggestionBox.sendKeys(Keys.ARROW_DOWN);
    		count++;
    		
    		// this is alternative way (to the .getText() method) to print value  
    		System.out.println(suggestionBox.getAttribute("value"));
    		
    		Thread.sleep(500L);
    		
    		if (js.executeScript("return document.getElementById(\"autocomplete\").value;")
    			.toString().equals("United States")) {
    			suggestionBox.sendKeys(Keys.ENTER);
    			break;
    		}
    		
    		if (count > 10) {
    			System.out.println("The text did not match");
    			break;
    		}
    	}
	}
    
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(5000L);
	    driver.close();
	}


}
