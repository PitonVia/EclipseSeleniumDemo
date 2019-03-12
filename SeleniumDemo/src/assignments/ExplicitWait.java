package assignments;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {


    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        baseURL = "http://www.itgeared.com/demo/1506-ajax-loading.html";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// 1. Click on the link "Click to load get data via Ajax!" and note that
    	// it will take several seconds to load the page. The objective is to 
    	//print red text that appears without getting any errors.
    	
    	// Since loading the page takes some time, have to use Explicit wait
    	WebDriverWait explWait = new WebDriverWait(driver, 5);
    	
    	// clicking the link
    	driver.findElement(By.partialLinkText("Click to load")).click();
    	
    	// Locate element containing red text after clicking the link
    	WebElement resultText = driver.findElement(By.id("results"));
    	
    	// using the object of WebDriverWait with expected conditions
    	explWait.until(ExpectedConditions.elementToBeClickable(resultText));
    	
    	// printing the text after wait is over
    	System.out.println(resultText.getText());
    }

    @After
    public void tearDown() throws Exception {

        driver.close();
    }

}
