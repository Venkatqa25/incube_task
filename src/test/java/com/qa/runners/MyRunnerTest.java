package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions( plugin =  {"pretty"
        , "html:target/cucumber"
        , "summary"
        //,"de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"
        ,"de.monochromata.cucumber.report.PrettyReports:target"
        ,"json:target/cucumber.json" }
        ,features = {"classpath:1.Gmailcompose.feature"}
        ,glue = {"com.qa.stepdef"}
        ,snippets =CAMELCASE
        ,dryRun = false
        ,monochrome=true
        ,strict = true
        ,tags = "@scenario1 or @scenario2 or @scenario3 or @scenario4"

)

public class MyRunnerTest {


}
