package com.curaHealthcare.utils;

import com.curaHealthcare.stepdefinition.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil extends BaseTest {

    // Method to capture screenshot with a timestamped file name
    public static void captureScreenshot(String fileName) throws IOException {
        // Create a Date object to get the current time
        Date date = new Date();
        // Format the timestamp to be used in the screenshot file name
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = simpleDateFormat.format(date);  // Generate timestamp
        String screenshotName = fileName + "_" + timestamp + ".png";  // Append timestamp to file name

        // Capture the screenshot using the TakesScreenshot interface
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot file
        File destinationFile = new File("src/test/resources/screenshots/pages"  + screenshotName);

        // Copy the captured screenshot to the destination file
        FileUtils.copyFile(screenshot, destinationFile);  // Save the screenshot to disk
    }
}
