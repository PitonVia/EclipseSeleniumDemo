package Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class InterrelatedElements {


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

    	driver.get(baseURL);
    	
    	// 1. Check any of the Option Example checkboxes without 'Option#' text.
    	// 2. Grab the label of the selected checkbox and save it in a var. 
    	// 3. Select a Dropdown Example value that matches the Option label.
    	// 4. Type in label text into the Switch to Alert textbox 
    	// 5. Click on Alert and verify that the text is present in the pop-up msg.
    	
    	ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
   			 driver.findElements(By.cssSelector("#checkbox-example>fieldset>label>input"));
    	
    	// Click on the checkbox @ index = 1
    	checkboxes.get(1).click();
    	    	
    	ArrayList<WebElement> options = (ArrayList<WebElement>)
    			 driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
    	  
    	// Declare a WebElement of checkbox at Index = 1:
    	WebElement checkbox = options.get(1);
    	
    	// Get textLabel of the selected checkbox:
    	String textLabel = checkbox.getText(); 
    	System.out.println(textLabel);
    	
    	// Declaring a new instance of the Select class
    	Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
    	
    	// select a dropdown by visible text = textLabel String
    	dropdown.selectByVisibleText(textLabel);
    	
    	// Send label text into the Switch to Alert textbox
    	driver.findElement(By.id("name")).sendKeys(textLabel);
    	// click on the Alert button
    	driver.findElement(By.id("alertbtn")).click(); 
    	
    	// Declare an object of the Alert class
    	Alert alert = driver.switchTo().alert();
    	
    	// verify that textLabel is part of the pop-up message
    	String alertMsg = alert.getText();
    	if (alertMsg.contains(textLabel)) {
    		System.out.println("Alert message verified successfully");
    	} else {
    		System.out.println("Test failed. Alert msg did not contain label text");
    	}	
    }

    @After
    public void tearDown() throws Exception {

        driver.close();
    }

}
