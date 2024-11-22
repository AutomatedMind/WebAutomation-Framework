package com.curaHealthcare.pages;

import com.curaHealthcare.stepdefinition.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    // Locators for the home page elements
    @FindBy(id = "combo_facility")
    private WebElement facilityDropdown;

    @FindBy(id = "radio_program_medicare")
    private WebElement healthcareProgramMedicare;

    @FindBy(id = "radio_program_medicaid")
    private WebElement healthcareProgramMedicaid;

    @FindBy(id = "radio_program_none")
    private WebElement healthcareProgramNone;

    @FindBy(id = "txt_visit_date")
    private WebElement visitDateInput;

    @FindBy(id = "txt_comment")
    private WebElement commentTextArea;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;


    // Constructor to initialize the PageFactory elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements
    }

    // Verify the home page title
    public HomePage verifyHomePageTitle() {
        String expectedTitle = "CURA Healthcare Service";
        String actualTitle = driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            logger.error("Home page title verification failed.");
        } else {
            logger.info("Home page title verification passed.");
        }
        return this;
    }

    // Select a facility from the dropdown
    public void selectFacility(String facility) {
        facilityDropdown.sendKeys(facility);
    }

    // Select a healthcare program
    public void selectHealthcareProgram(String program) {
        switch (program.toLowerCase()) {
            case "medicare":
                healthcareProgramMedicare.click();
                break;
            case "medicaid":
                healthcareProgramMedicaid.click();
                break;
            case "none":
                healthcareProgramNone.click();
                break;
        }
    }

    // Enter a visit date
    public void enterVisitDate(String date) {
        visitDateInput.sendKeys(date);
    }

    // Enter a comment
    public void enterComment(String comment) {
        commentTextArea.sendKeys(comment);
    }

    // Click the "Book Appointment" button
    public void clickBookAppointment() {
        bookAppointmentButton.click();
    }
}
