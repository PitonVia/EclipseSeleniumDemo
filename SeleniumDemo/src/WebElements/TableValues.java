package WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableValues {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();
        baseURL = "https://www.cricbuzz.com/live-cricket-scorecard/21513/ts-vs-pr-21st-match-mzansi-super-league-2018";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// We want to get a List of all Runs (column R) and to validate their Sum 
    	// against the Sum value in the Total table row.
    	// Approach is to identify the common CSS used by all values in a row.
    	// Because there are more common CSS objects, need to link them to parent elements
    	
    	// Get the WebElement of the entire table:
    	WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
    	
    	// From that point make a list of all the elements of values from the "R" column: 
    	List<WebElement> values = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms>div.cb-col.cb-col-8.text-right.text-bold"));
    	
    	// Print the number of values in the list 
    	System.out.println("There are " + values.size() + " values in the List.");
    	
    	// Print all the values from the list
    	for (WebElement e : values) {		
        	System.out.print(e.getText() + " ");
    	}
    	
    	int sum = 0;
    	
    	// creating for loop to get all values except for the last one, which is a total
    	for (int i=0; i<values.size()-1; i++) {
    		
    		String value = values.get(i).getText();
  
    		// using Integer class with parseInt() to convert String value to an int!!!
    		int valueInt = Integer.parseInt(value);
    		
    		sum = sum + valueInt;
    	}
    	
    	System.out.println();
    	System.out.println("The sum is: " + sum);
    	
    	// Intermittent step to print the last element from the values List 
    	System.out.println(values.get(values.size()-1).getText());
    	
    	// Validate the sum of all elements is correct
    	if (Integer.parseInt(values.get(values.size()-1).getText()) == sum ) {
    		
    		System.out.println("Validation was correct, the sum was: " + sum);
    	}
	}
    
	@After
	public void tearDown() throws Exception {
		
	    driver.close();
	}


}
