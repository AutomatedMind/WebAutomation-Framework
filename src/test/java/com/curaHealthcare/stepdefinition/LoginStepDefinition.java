package com.curaHealthcare.stepdefinition;

import com.aventstack.extentreports.ExtentTest;
import com.curaHealthcare.pages.LoginPage;
import com.curaHealthcare.stepdefinition.BaseTest;
import com.curaHealthcare.utils.ConfigReaderUtil;
import com.curaHealthcare.utils.ScreenshotUtil;
import com.curaHealthcare.utils.ExtentReportUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class LoginStepDefinition extends BaseTest {

    // Initialize the LoginPage with the WebDriver instance
    LoginPage loginPage = new LoginPage(driver);

    // Initialize ExtentReports for logging the test steps
    static ExtentTest test = ExtentReportUtil.getExtentReports().createTest("Login Test");

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() throws IOException {
        try {
            loginPage.verifyLoginPageTitle(); // Verify login page title
            test.pass("Verified the login page title.");
            ScreenshotUtil.captureScreenshot("LoginPageTitleVerified"); // Capture screenshot
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/LoginPageTitleVerified.png");
        } catch (Exception e) {
            test.fail("Failed to verify the login page title: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("LoginPageTitleError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/LoginPageTitleError.png");
        }
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() throws IOException {
        try {
            loginPage.enterUsername(); // Enter username
            loginPage.enterPassword(); // Enter password
            test.pass("Entered username and password.");
            ScreenshotUtil.captureScreenshot("CredentialsEntered"); // Capture screenshot
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/CredentialsEntered.png");
        } catch (Exception e) {
            test.fail("Failed to enter username and password: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("CredentialsEntryError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/CredentialsEntryError.png");
        }
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() throws IOException {
        try {
            loginPage.clickLogin(); // Click the login button
            test.pass("Clicked the login button.");
            ScreenshotUtil.captureScreenshot("LoginButtonClicked"); // Capture screenshot
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/LoginButtonClicked.png");
        } catch (Exception e) {
            test.fail("Failed to click the login button: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("LoginButtonClickError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/LoginButtonClickError.png");
        }
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        try {
            // Validate if the user is redirected to the homepage correctly
            String expectedHomePageUrl = ConfigReaderUtil.getProperty("homepage.url");
            String actualHomePageUrl = driver.getCurrentUrl();

            if (actualHomePageUrl.equals(expectedHomePageUrl)) {
                test.pass("User successfully redirected to the homepage.");
            } else {
                test.fail("User was not redirected to the homepage. Expected URL: "
                        + expectedHomePageUrl + ", but found: " + actualHomePageUrl);
            }
        } catch (Exception e) {
            test.fail("Failed to validate homepage redirection: " + e.getMessage());
        }
    }
}
