package com.curaHealthcare.pages;

import com.curaHealthcare.stepdefinition.BaseTest;
import com.curaHealthcare.utils.ConfigReaderUtil;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    // Locators for the login page elements
    @FindBy(id = "txt-username")
    private WebElement usernameInputField;

    @FindBy(id = "txt-password")
    private WebElement passwordInputField;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    // Constructor to initialize the PageFactory elements
    public LoginPage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements
        logger.info("LoginPage elements initialized successfully.");
    }

    // Verify the login page title
    public LoginPage verifyLoginPageTitle() {
        try {
            String expectedTitle = "CURA Healthcare Service";
            String actualTitle = driver.getTitle();
            logger.info("Validating login page title. Actual title: " + actualTitle);

            if (!actualTitle.equals(expectedTitle)) {
                logger.error("Login page title verification failed.");
            } else {
                logger.info("Login page title verification passed.");
            }
        } catch (Exception e) {
            logger.error("An error occurred during login page title verification: " + e.getMessage());
        }
        return this;
    }

    // Enter the username from the configuration file
    public LoginPage enterUsername() {
        try {
            String username = ConfigReaderUtil.getProperty("username");
            logger.info("Entering username: " + username);
            usernameInputField.clear();
            usernameInputField.sendKeys(username);
        } catch (NoSuchElementException e) {
            logger.error("Username input field not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Failed to enter username: " + e.getMessage());
        }
        return this;
    }

    // Enter the password from the configuration file
    public LoginPage enterPassword() {
        try {
            String password = ConfigReaderUtil.getProperty("password");
            logger.info("Entering password.");
            passwordInputField.clear();
            passwordInputField.sendKeys(password);
        } catch (NoSuchElementException e) {
            logger.error("Password input field not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Failed to enter password: " + e.getMessage());
        }
        return this;
    }

    // Click the login button and return to the HomePage
    public HomePage clickLogin() {
        try {
            logger.info("Clicking the login button.");
            loginButton.click();
        } catch (NoSuchElementException e) {
            logger.error("Login button not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Failed to click login button: " + e.getMessage());
        }
        return new HomePage(driver); // Return HomePage instance after login
    }
}
