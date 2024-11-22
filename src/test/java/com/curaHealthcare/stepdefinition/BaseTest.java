package com.curaHealthcare.stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.curaHealthcare.utils.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.curaHealthcare.utils.ConfigReaderUtil;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ExtentReports extent;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest test;

    public static final Logger logger = Logger.getLogger(BaseTest.class);

    // Initialize the WebDriver based on browser type defined in config file
    public void initializeDriver() {
        PropertyConfigurator.configure("src/test/resources/log4j.properties"); // Configure log4j for logging
        String browserType = ConfigReaderUtil.getProperty("browser"); // Read browser type from config file

        // Initialize WebDriver based on browser type
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup(); // Setup Chrome WebDriver
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized"); // Maximize browser window
                driver = new ChromeDriver(chromeOptions); // Instantiate Chrome driver
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup(); // Setup Firefox WebDriver
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized"); // Maximize browser window
                driver = new FirefoxDriver(firefoxOptions); // Instantiate Firefox driver
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType); // Throw exception if unsupported browser
        }

        // Set implicit and explicit wait times
        int implicitWait = Integer.parseInt(ConfigReaderUtil.getProperty("implicit.wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        int explicitWait = Integer.parseInt(ConfigReaderUtil.getProperty("explicit.wait"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    // Launch the application URL from config file
    public void launchApplication() {
        driver.get(ConfigReaderUtil.getProperty("curaHealthcare.url")); // Open the specified URL
    }

    // Quit the WebDriver and finalize the report
    public void quitDriver() {
        if (driver != null) {
            driver.quit(); // Close the browser and end the session
        }
        if (extent != null) {
            extent.flush(); // Finalize the report and save the data
        }
    }
}
