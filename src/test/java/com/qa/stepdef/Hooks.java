package com.qa.stepdef;

//import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    // It starts the Appium Server & initialize the Appium Driver. Normally it occurs before cucumber scenario
    public void initialize() throws Exception {

        //to start Video
        //new VideoManager().startRecording();
    }

    @After
    //It stop the appium the server and quit the Appium Driver. Normally it occurs after cucumber scenario
    public void quit(Scenario scenario) throws IOException {
    //To take screenshot for failure scenario

        /*if(scenario.isFailed()) {
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());

            System.out.println("Get Name when scenario get failed" +scenario.getName());
            new TestUtils().log().info("Get Name when scenario get failed" +scenario.getName());

        }*/

        // To stop video manager
        //new VideoManager().stopRecording(scenario.getName());

        //System.out.println("Get Name when Video record getting stop" +scenario.getName());
        //new TestUtils().log().info("Get Name when Video record getting stop" +scenario.getName());

    }


}
