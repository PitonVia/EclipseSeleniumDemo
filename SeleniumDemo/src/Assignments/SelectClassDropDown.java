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

public class SelectClassDropDown {


    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        baseURL = "https://cleartrip.com";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// 1. On the Search Flights page select any value from the 'Adults' 
    	// and 'Children' drop-down menus. Both menus are using Select class.
    	
    	// Instantiate a new object of Select class
    	Select adultsMenu = new Select(driver.findElement(By.id("Adults")));
    	adultsMenu.selectByValue("2");
    	
    	Select childrenMenu = new Select(driver.findElement(By.id("Childrens")));
    	childrenMenu.selectByValue("1");
    	
    	// 2. Select today's date from the 'Depart on' calendar.
    	
    	// click on Depart on field to display dates calendar
    	driver.findElement(By.id("DepartDate")).click();
    	// click on today's date - note that it has additional classes:
    	driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();
    	
    	// 3. Click on 'More options..' link and enter any Preferred Airline name.
    	driver.findElement(By.id("MoreOptionsLink")).click();
    	driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Air India");
    	
    	// 4. Click on 'Search Flights' button - error message will be displayed.
    	driver.findElement(By.id("SearchBtn")).click();
    	
    	// 5. Print the text of the error msg in the console.
    	System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
    		
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(2000);
        driver.close();
    }

}
