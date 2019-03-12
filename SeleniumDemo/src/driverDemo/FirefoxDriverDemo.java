package driverDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) throws Exception {
		
        System.setProperty("webdriver.gecko.driver", "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
                
        String baseURL = "http://www.google.com";
        driver.get(baseURL);

        System.out.println(driver.getTitle());
        
        Thread.sleep(5000);
        driver.close();

	}

}
