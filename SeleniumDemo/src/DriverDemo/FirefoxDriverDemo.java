package DriverDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) throws Exception {
		
        System.setProperty("webdriver.gecko.driver", "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
        String baseURL = "http://www.google.com";
        driver.get(baseURL);

        System.out.println(driver.getTitle());
        
        Thread.sleep(5000);
        driver.close();

        // Testing git hub commit.
        // Adding 2-nd comment for 2-nd commit from Eclipse.
        // Adding 3-rd comment for 3-nd commit from Eclipse.
	}

}
