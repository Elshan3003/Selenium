package com.Selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(dryRun=false,
				 tags={"@a","~@s"  },
				 monochrome=true,
				 plugin={"pretty","html:target/html", "json:target/cucember-report.json"},
				 //glue="./src/test/java/com/Selenium/stepDefinition",
				 features="./src/test/resources/com/Selenium/features"
				 )

public class Cuke_Runner {

}
