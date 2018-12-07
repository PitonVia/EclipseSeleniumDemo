package utilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificateHandling {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {
        
    	// Creating an object of the DesiredCapabilities class of Selenium
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	
    	// Using .acceptInsecureCerts() to bypass SSL Certificate warnings
    	//capabilities.acceptInsecureCerts();
    	
    	// Another was to do the same is:
    	capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	
        ChromeOptions options = new ChromeOptions();
        
        // We have to merge the DesiredCapabilities into our local Chrome options  
        options.merge(capabilities);
        
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Dev\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        
        baseURL = "https://untrusted-root.badssl.com/";
        driver.manage().window().maximize();
        
        // This is to delete all cookies in the browser
        driver.manage().deleteAllCookies();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	// Want to bypass the expired SSL Certificate
    	
    	driver.get(baseURL);
    	
    	System.out.println(driver.getTitle());
    	
    }
        
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000L);
	    driver.close();
	}

}
