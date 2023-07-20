package Base_Scripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class WebDriverControl implements ISuiteListener{
	private static final String DRIVER = "driver";

    @Override
    public void onStart(ISuite suite) {
        RemoteWebDriver driver;
        String browserType = suite.getParameter("browserType");
        String appURL = suite.getParameter("appURL");
        switch (browserType) {
            case "chrome":
            	
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("test-type");
            	options.addArguments("start-maximized");
            	options.addArguments("disable-infobars");
            	options.addArguments("--disable-extensions"); 
            	System.setProperty("webdriver.chrome.driver","C:/Users/Public/chromedriver_win32/chromedriver.exe"); 
            	driver = new ChromeDriver(options);
        		 //driver = new ChromeDriver(dc);
               // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
               // driver.manage().window().maximize();
                driver.navigate().to(appURL);
                break;
            default:
                driver = new InternetExplorerDriver();
                
        }
        suite.setAttribute(DRIVER, driver);
        
    }

    @Override
    public void onFinish(ISuite suite) {
        Object driver = suite.getAttribute(DRIVER);
        if (driver == null) {
            return;
        }
        if (!(driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        ((RemoteWebDriver) driver).quit();
        suite.setAttribute(DRIVER, null);
    }

    public static RemoteWebDriver getDriver() {
        ITestResult result = Reporter.getCurrentTestResult();
        if (result == null) {
            throw new UnsupportedOperationException("Please invoke only from within an @Test method");
        }
        Object driver = result.getTestContext().getSuite().getAttribute(DRIVER);
        if (driver == null) {
            throw new IllegalStateException("Unable to find a valid webdriver instance");
        }
        if (! (driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        return (RemoteWebDriver) driver;
    }
}
