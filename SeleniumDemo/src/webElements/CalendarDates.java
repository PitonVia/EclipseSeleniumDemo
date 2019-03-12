package webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarDates {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        baseURL = "https://www.path2usa.com/travel-companions";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// We want to pick a day in the calendar in the specific month = February 
    	
    	// click on the Date field to open the calendar
    	driver.findElement(By.id("travel_date")).click();
    	
    	// go through months until required month is reached (it contains text = February)
    	// Note the use of space when identifying a class inside class by their class names
    	while (!driver.findElement(By.cssSelector
    			("div.datepicker-days th.datepicker-switch")).getText().contains("February")) {
    		
    		// we want to click on the arrow button to traverse to the next month 
    		// when the month of February will be reached, the while loop will exit
    		driver.findElement(By.cssSelector
    				("div.datepicker-days th.next")).click();
    	}
    	
    	// print the text from the month element
		System.out.println(driver.findElement(By.cssSelector
				("div.datepicker-days th.datepicker-switch")).getText());
    	
    	// Identifying WebElements for all days in the calendar
    	List<WebElement> calendarDays = driver.findElements(By.xpath("//td[@class='day']"));
    	
    	// in case we wanted to access today's date in the calendar, we could 
    	// add the current date to the list - it has a unique class: 'active day'
    	// calendarDays.add(driver.findElement(By.cssSelector("td[class='active day']")));
    	
    	//div[contains(@class, 'class1') and contains(@class, 'class2')]
    	
    	for (WebElement day : calendarDays) {
    		
    		if (day.getText().contains("27")) {
    			System.out.println(day.getText());
    			day.click();
    			break;  // add break when continuing with the loop is not required
    		}
    	}
    	
    	
	}
    
	@After
	public void tearDown() throws Exception {
		
	    driver.close();
	}


}
