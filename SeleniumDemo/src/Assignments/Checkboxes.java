package Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkboxes {


    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        baseURL = "http://qaclickacademy.com/practice.php";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	// There are 3 Checkboxes displayed in the Page: Option 1, Option 2, Option 3
    	
    	// 1. Check the first  Checkbox and verify if it is successfully checked and  
    	// Uncheck it again to verify if it is successfully Unchecked.
    	
    	// 2. How to get the Count of number of check boxes present in the page
    	
    	driver.get(baseURL);
    	
    	//ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
    		//	 driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
    	ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
    			 driver.findElements(By.cssSelector("#checkbox-example>fieldset>label>input"));
    	
    	for (WebElement box: checkboxes ) {
    		
    		// identifying Option 1 checkbox by its unique id:
    		if (box.getAttribute("id").equals("checkBoxOption1")) {
    			box.click();
    			System.out.println("Checkbox Option1 is selected? " + box.isSelected());
    			Thread.sleep(1500);
    			box.click();
    			System.out.println("Checkbox Option1 is selected? " + box.isSelected());
    		}
    	}

    	// getting the total number of checkboxes:
    	System.out.println("There are " + checkboxes.size() + " checkboxes.");
    	
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(2000);
        driver.quit();
    }

}
