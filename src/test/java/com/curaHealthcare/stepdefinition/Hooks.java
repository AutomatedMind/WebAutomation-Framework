package com.curaHealthcare.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    // Before hook to initialize the driver and launch the application before each scenario
    @Before
    public void setup() {
        initializeDriver(); // Initialize WebDriver (chrome/firefox) based on config
        launchApplication(); // Launch the application URL from config
    }

    // After hook to quit the driver and clean up after each scenario
    @After
    public void teardown() {
        quitDriver(); // Quit the WebDriver and finalize any reports
    }
}
