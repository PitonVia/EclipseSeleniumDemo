package driverDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleDriverDemo {

	public static void main(String[] args) throws Exception {
		
		
		ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Dev\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        
        String baseURL = "http://www.google.com";
        driver.get(baseURL);

        System.out.println(driver.getTitle());
        
        Thread.sleep(5000);
        driver.close();

	}

}
