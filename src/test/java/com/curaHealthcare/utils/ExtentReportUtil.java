package com.curaHealthcare.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.curaHealthcare.stepdefinition.BaseTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil extends BaseTest {

    // Method to get an instance of ExtentReports
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            // Generate a timestamp for the report filename
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportFilename = "ExtentReport-" + timestamp + ".html";  // Report filename with timestamp

            // Set the report file path
            extentSparkReporter = new ExtentSparkReporter("src/test/resources/reports/extentReports" + reportFilename);
            extent = new ExtentReports();  // Initialize ExtentReports instance
            extent.attachReporter(extentSparkReporter);  // Attach the reporter to the extent reports instance

            // Set system information to be displayed in the report
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", "Automation Tester");

            // Configure the report title and name
            extentSparkReporter.config().setDocumentTitle("CURA Healthcare Test Report");
            extentSparkReporter.config().setReportName("Automation Results");
        }
        return extent;  // Return the ExtentReports instance
    }
}
