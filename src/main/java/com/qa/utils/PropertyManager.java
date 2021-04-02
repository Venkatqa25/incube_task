package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    //create property object

    private static Properties props = new Properties();

    //Create instance for TestUtils class for logging purpose. Already created logger method in testutils class to
    // initialize our logger
    // Thread local is not needed because going to use Global params it create single instance and shared to the device.
    // Even if you use thread local its not problem

    TestUtils utils = new TestUtils();

    //Below method return property object


    public Properties getProps() throws IOException {
        // to load the properties calling input stream

        InputStream is = null;
        String propsFileName = "config.properties";

        //If property empty we load the property otherwise not need to load the property again
        if(props.isEmpty()) {

            try {

                utils.log().info("Loading config Properties");
                //Use input stream to load the resource in try catch block
                //getresourceasstream read the file name of property(for eg: Config.Properties) from classpath
                //Other option is using File input stream and have to give complete path to load the resources

                is = getClass().getClassLoader().getResourceAsStream(propsFileName);

                //to load properties and need to supply input stream write below statement
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!! " + e.toString());

                // if fails to load the properties no need to continue so throw the exception again
                throw e;
            }
            //basically to close the input stream. Best practise to close the input stream
            finally {
                if (is != null) {
                    is.close();
                }

            }
        }
        return props;
    }
}

