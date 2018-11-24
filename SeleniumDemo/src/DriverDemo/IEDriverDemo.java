package DriverDemo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) throws Exception {
		
		String driverPath = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPath);

        WebDriver driver = new InternetExplorerDriver();
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        String baseURL = "http://www.google.com";
        driver.get(baseURL);
        
        Thread.sleep(4000);
      
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
        Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");

        driver.close();  // closes this instance of selenium WebDriver
        driver.quit();  // closes all instances of selenium WebDriver

	}

}
