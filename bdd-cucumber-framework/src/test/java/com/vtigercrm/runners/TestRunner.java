package com.vtigercrm.runners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Featurs",
  glue="com.vtigercrm",tags="@Marketing",dryRun = false, monochrome = true, 
  plugin={"pretty","html:target/cucumber-reports/reports.html" ,"html:target/cucumber-reports/index.html"} )
 

//@CucumberOptions(features="src\\test\\resources\\Featurs",glue="com.vtiger.stepdefs",tags="@Home")
public class TestRunner {
	
	@AfterClass
    public static void generateReportAndSendEmail() {
		EmailSender.sendReportByEmail();
    }
	
 
}

