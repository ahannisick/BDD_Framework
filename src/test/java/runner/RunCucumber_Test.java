package runner;

// Created by adam.hannisick on 11/12/2019.
// Created Initial Runner
// Added Tag Annotation Capabilities
// Added Extent 1.0 Reporting plugin
// Upgraded to Extent 1.1 Reporting plugin due to reporting issues
// Added a BeforeClass for Report setup
// Modified extent-config.xml to reflect FisherSci as the app being tested in the report Generation
// ****Description*****
// Junit TestRunner that is required to run Cucumber Suite of tests
// Uses Extent Reports to show result sets > Outputted to output/Run<num> using Cucumber json reports


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = "com.cucumber.listener.ExtentCucumberFormatter:output/ExtentReport.html",
        tags = "@FBTestSuite",  //Used to define Scripts to be ran(@) and Exclude (@~)
        features = "src/features/",  //Location of Feature Files
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },  //Report Generation with test results
        //dryRun = true,
        glue = "steps",  //Location of all Step Declaration
        monochrome = true
)

public class RunCucumber_Test {

    @AfterClass
    public static void extentReport() {

        // Initiates the extent report and generates the output in the output/Run_/report.html file by default.
        Reporter.loadXMLConfig(new java.io.File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User", System.getProperty("user.name"));
        Reporter.setSystemInfo("Application Name", "test.app ");
        Reporter.setSystemInfo("OS", System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA-Env");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}