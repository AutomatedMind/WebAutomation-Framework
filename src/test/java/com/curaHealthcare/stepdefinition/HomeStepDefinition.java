package com.curaHealthcare.stepdefinition;

import com.curaHealthcare.pages.HomePage;
import com.curaHealthcare.pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.curaHealthcare.utils.ScreenshotUtil;
import com.curaHealthcare.utils.ExtentReportUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class HomeStepDefinition extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver); // Initialize HomePage class with WebDriver instance

    // Initialize ExtentReports for logging the test steps
    static ExtentTest test = ExtentReportUtil.getExtentReports().createTest("Home Page Test");

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String pageName) throws IOException {
        try {
            // Perform login actions and verify the home page title
            loginPage.verifyLoginPageTitle().enterUsername().enterPassword().clickLogin();
            homePage.verifyHomePageTitle();
            test.pass("Successfully logged in and verified the home page title.");
        } catch (Exception e) {
            test.fail("Failed to verify the home page title: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("HomePageVerificationError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/HomePageVerificationError.png");
        }
    }

    @When("the user selects {string} from the facility dropdown")
    public void theUserSelectsFromTheFacilityDropdown(String facility) throws IOException {
        try {
            homePage.selectFacility(facility);  // Select facility
            test.pass("Selected facility: " + facility);
            ScreenshotUtil.captureScreenshot("FacilitySelected_" + facility);
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/FacilitySelected_" + facility + ".png");
        } catch (Exception e) {
            test.fail("Failed to select facility: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("FacilitySelectionError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/FacilitySelectionError.png");
        }
    }

    @When("the user selects {string} as the healthcare program")
    public void theUserSelectsAsTheHealthcareProgram(String program) throws IOException {
        try {
            homePage.selectHealthcareProgram(program);  // Select healthcare program
            test.pass("Selected healthcare program: " + program);
            ScreenshotUtil.captureScreenshot("HealthcareProgramSelected_" + program);
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/HealthcareProgramSelected_" + program + ".png");
        } catch (Exception e) {
            test.fail("Failed to select healthcare program: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("HealthcareProgramSelectionError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/HealthcareProgramSelectionError.png");
        }
    }

    @When("the user enters a valid visit date")
    public void theUserEntersAValidVisitDate() throws IOException {
        try {
            homePage.enterVisitDate("10/12/2024");  // Example visit date
            test.pass("Entered visit date: 10/12/2024");
            ScreenshotUtil.captureScreenshot("VisitDateEntered");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/VisitDateEntered.png");
        } catch (Exception e) {
            test.fail("Failed to enter visit date: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("VisitDateEntryError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/VisitDateEntryError.png");
        }
    }

    @When("the user writes a comment in the comment box")
    public void theUserWritesACommentInTheCommentBox() throws IOException {
        try {
            homePage.enterComment("Looking forward to the appointment.");  // Enter comment
            test.pass("Entered comment: Looking forward to the appointment.");
            ScreenshotUtil.captureScreenshot("CommentEntered");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/CommentEntered.png");
        } catch (Exception e) {
            test.fail("Failed to write comment: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("CommentEntryError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/CommentEntryError.png");
        }
    }

    @Then("the user should be able to book the appointment")
    public void theUserShouldBeAbleToBookTheAppointment() throws IOException {
        try {
            homePage.clickBookAppointment();  // Click to book appointment
            test.pass("Successfully clicked book appointment.");
            ScreenshotUtil.captureScreenshot("AppointmentBooked");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/AppointmentBooked.png");
        } catch (Exception e) {
            test.fail("Failed to book appointment: " + e.getMessage());
            ScreenshotUtil.captureScreenshot("AppointmentBookingError");
            test.addScreenCaptureFromPath("src/test/resources/screenshots/pageWise/AppointmentBookingError.png");
        }
    }


}
