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
       // ,tags = {"@test"}
        // ,tags = {"@foo", "not @bar"}
        //,features = {"src/test/resources"}
)

public class MyRunnerTest {


}
