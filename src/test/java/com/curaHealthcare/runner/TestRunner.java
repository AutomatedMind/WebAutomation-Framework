package com.curaHealthcare.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/curaHealthcare/features/HomePage.feature"},
        //dryRun = true,
        //snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"com.curaHealthcare.stepdefinition"},
        monochrome = true
        )
public class TestRunner extends AbstractTestNGCucumberTests {
}
