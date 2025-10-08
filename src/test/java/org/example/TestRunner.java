package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "org.example",
    plugin = {"html:target/cucumber-html-reports/index.html", "json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}