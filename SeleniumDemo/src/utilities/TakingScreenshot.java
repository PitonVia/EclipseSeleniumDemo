package utilities;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakingScreenshot {

	WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception {

        String driverLocFF = "D:\\Yo\\QA\\Automation\\Selenium_java_3.14.0\\BrowserDrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverLocFF);
        driver = new FirefoxDriver();

        baseURL = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputTypesDemo() throws Exception {

    	driver.get(baseURL);
    	
    	// We want to take a screenshot using File (java.io)
    	// and FileUtils library from Apache Commons IO
    	
    
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String dest = "C:\\Users\\Pitoshka\\Git\\git-repos-home\\eclipse\\SeleniumDemo\\SeleniumDemo\\src\\utilities\\resources\\screenshot.png";
    	FileUtils.copyFile(src, new File(dest));
    	
    	
	}
    
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000L);
	    driver.close();
	    driver.quit();
	    //Runtime rt = Runtime.getRuntime();
	    //Process proc = rt.exec("taskkill /im geckodriver.exe /f");
	}


}
