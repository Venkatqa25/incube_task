package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"classpath:1.Gmaillogin.feature"}
        ,glue = {"com.qa.stepdef"}
        //,snippets =CAMELCASE
        ,dryRun = false
        ,monochrome=true
        ,strict = true
        ,tags = "@scenario1 or @scenario2 or @scenario3"
        // ,tags = {"@foo", "not @bar"}
        //,features = {"src/test/resources"}
)

public class MyRunnerTest {


}
