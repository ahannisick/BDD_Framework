package pages;

import objectrepository.ObjectMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.DriverFactory;
import util.PropertyReader;
import util.verifylinks;

import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;

public class FacebookLogin extends DriverFactory {

    // Call Apache Log4J
    static Logger log = LogManager.getLogger();

    // Call Object Map
    ObjectMap objMap = new ObjectMap();


    // Store user credentials as strings inside properties file
    Properties properties = new Properties();
    String fbUsername = new PropertyReader().readProperty("FacebookUsername");
    String fbPassword = new PropertyReader().readProperty("FacebookPassword");


    public void fbhomepageFetch() {
        DriverFactory.getDriverInstance();
        log.info("PASS - HomePage Land Success.");

        // Quick sanity test to detect any broken page links/images
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        // Capture and verify all page links
        verifylinks.main(currentURL);
        // Capture and verify all page images
        verifylinks.validateInvalidImages();

    }

    // User enters username
    public void fbusernameInput() throws AssertionError, Exception {
        // Waiting for username field to display - includes success messages and failing exceptions
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("fb_txtbox_username")));
            if (usernameField.isDisplayed()) {
                log.info("PASS - Username Field is Displayed.");
            } else if (!usernameField.isDisplayed()) {
                (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("fb_txtbox_username")));
                log.info("PASS - Username Field is Displayed.");
            }

        } catch (Exception e) {
            log.error("FAIL - Username Field Locate Failure.");
            throw new AssertionError("Login Page - Failed To Locate Username Text Box - https://www.facebook.com/");
        }


        // Validate username field is empty by default
        WebElement usernameField = driver.findElement(objMap.getLocator("fb_txtbox_username"));
        String usernameFieldInput = usernameField.getAttribute("value");
        try {
            assertEquals(usernameField.getAttribute("value"), "");
            log.info("INFO - Username Field Empty By Default.");
        } catch (Exception e) {
            log.error(e);
            log.error("Username Field Pre-Populated By Default With the Following Text: " + usernameFieldInput);
        }


        // Clicking username field - includes success messages and failing exceptions
        try {
            // If username field is selected by default, wait until clickable and click it anyway to validate click function
            if (usernameField.isSelected()) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.elementToBeClickable(objMap.getLocator("fb_txtbox_username")));
                usernameField.click();
                log.info("PASS - Username Field Click Success");
                // If username field is not selected by default, wait until clickable and click it
            } else if (!usernameField.isSelected()) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.elementToBeClickable(objMap.getLocator("fb_txtbox_username")));
                usernameField.click();
                log.info("PASS - Username Field Click Success.");
            }
            // If click fails to execute, throw assertion error - unable to click username field
        } catch (Exception e) {
            log.error("FAIL - Username Click Failure.");
            throw new AssertionError("Login Page - Failed On Username Click - https://www.facebook.com/");
        }


        // Clearing username field - includes success messages and failing exceptions

        // Clear username field and validate returns empty
        try {
            usernameField.clear();
            assertEquals(usernameField.getAttribute("value"), "");
            log.info("PASS - Username Field Clear Success.");

        } catch (Exception e) {
            log.error(e);
            log.error("Username Field Clear Failure. Retrieved Text: " + usernameFieldInput);
            throw new AssertionError("Login Page - Failed On Username Clear - https://www.facebook.com/");
        }


        // Sending keys to username field - includes success messages and failing exceptions
        try {

            usernameField.sendKeys(fbUsername);

            String attributeValue = usernameField.getAttribute("value");
            String expectedValue = fbUsername;

            if (attributeValue.equals(fbUsername)) {
                log.info("PASS - Username Field Send Keys Success.");

            } else if (!attributeValue.equals(fbUsername)) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.attributeContains(usernameField, "value", expectedValue));
                log.info("PASS - Username Field Send Keys Success");
            }

            // If conditions do not satisfy the expected text to be present in element - throw assertion error
        } catch (Exception e) {
            WebElement text = driver.findElement(objMap.getLocator("fb_txtbox_username"));
            String attributeValue = text.getAttribute("value");
            log.error("FAIL - Username Field Send Keys Failure");
            throw new AssertionError("Login Page - Failed On Username Entry - Text Validation Returned Incorrect: " + attributeValue);
        }

    }

    // User enters password
    public void fbpasswordInput() throws AssertionError, Exception {
        WebElement passwordField = driver.findElement(objMap.getLocator("fb_txtbox_password"));

        //Checking if password field is displayed - includes success messages and failing exceptions
        try {

            if (passwordField.isDisplayed()) {
                log.info("PASS - Password Field is Displayed.");

            } else if (!passwordField.isDisplayed()) {
                (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("fb_txtbox_password"))).isDisplayed();
                log.info("PASS - Password Field is Displayed.");
            }

        } catch (Exception e) {
            log.error("FAIL - Password Field Locate Failure.");
            throw new AssertionError("Login Page - Failed To Locate Password Text Box - https://www.facebook.com/");

        }

        // Validate password field is empty by default
        String passwordFieldInput = passwordField.getAttribute("value");
        try {
            assertEquals(passwordField.getAttribute("value"), "");
            log.info("INFO - Password Field Empty By Default.");
        } catch (Exception e) {
            log.error(e);
            log.error("Password Field Pre-Populated By Default With the Following Text: " + passwordFieldInput);
        }


        // Clicking password field - includes success messages and failing exceptions

        WebElement elementToClick = driver.findElement(objMap.getLocator("fb_txtbox_password"));

        // Stale Element Exception & Element Not Clickable at Point Handling
        // Using for loop, try 3 times for element
        // If element is located for the first time
        // Wait till clickable
        // Clicks then breaks the for loop

        for (int i = 0; i <= 2; i++) {

            try {
                //Using JavascriptExecutor instead for element click method
                JavascriptExecutor js = (JavascriptExecutor) driver;
                //Wait for element to be clickable then click
                WebDriverWait wait = new WebDriverWait(driver, 10);
                js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(elementToClick)));
                log.info("PASS - Password Field Click Success.");
                break;
            } catch (Exception e) {
                log.error(e);
            }

        }


        // Clearing password field - includes success messages and failing exceptions
        // Clear password field and validate returns empty

        for (int i = 0; i <= 2; i++) {

            WebElement elementToClear;
            elementToClear = driver.findElement(objMap.getLocator("fb_txtbox_password"));

            try {
                //Using JavascriptExecutor instead for element click method
                JavascriptExecutor js = (JavascriptExecutor) driver;
                //Wait for element to be clickable then click
                WebDriverWait wait = new WebDriverWait(driver, 10);
                js.executeScript("arguments[0].value = '';", wait.until(ExpectedConditions.elementToBeClickable(elementToClear)));
                break;

            } catch (Exception e) {
                log.error(e);

            }

        }

        try {
            assertEquals(passwordField.getAttribute("value"), "");
            log.info("PASS - Password Field Clear Success.");

        } catch (Exception e) {
            log.error(e);
            log.error("Password Field Clear Failure. Retrieved Text: " + passwordFieldInput);
            throw new AssertionError("Login Page - Failed On Password Clear - https://www.facebook.com/");
        }

        // Sending keys to password field - includes success messages and failing exceptions

        try {

            passwordField.sendKeys(fbPassword);

            String attributeValue = passwordField.getAttribute("value");
            String expectedValue = fbPassword;

            if (attributeValue.equals(fbPassword)) {
                log.info("PASS - Password Field Send Keys Success.");

            } else if (!attributeValue.equals(fbPassword)) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.attributeContains(passwordField, "value", expectedValue));
                log.info("PASS - Password Field Send Keys Success");
            }

            // If conditions do not satisfy the expected text to be present in element - throw assertion error
        } catch (Exception e) {
            WebElement text = driver.findElement(objMap.getLocator("fb_txtbox_username"));
            String attributeValue = text.getAttribute("value");
            log.error("FAIL - Password Field Send Keys Failure");
            throw new AssertionError("Login Page - Failed On Password Entry - Text Validation Returned Incorrect: " + attributeValue);
        }

    }

    public void fbloginBtnClick() throws Exception {
        WebElement loginBtn = driver.findElement(objMap.getLocator("fb_login_btn"));

        try {
            if (loginBtn.isDisplayed()) {
                log.info("PASS - Login Button is Displayed");
            } else if (!loginBtn.isDisplayed()) {
                (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("fb_login_btn"))).isDisplayed();
                log.info("PASS - Login Button is Displayed.");
            }

        } catch (Exception e) {
            log.error("FAIL - Login Button Locate Failure.");
            throw new AssertionError("Login Page - Failed To Locate Login Button - https://www.facebook.com/");

        }

        try {
            loginBtn.click();
            log.info("PASS - Login Button Click Success.");
        } catch (Exception e) {
            log.error("Login Page - Login Button Failure - https://www.facebook.com/");
            log.error("Login Page - Failed On Login Click");
        }

    }

    // User Lands on Facebook Homepage - Login Complete
    public void fbhomepageLanding() throws AssertionError, Exception {
        WebElement facebookHomeIcon = driver.findElement(objMap.getLocator("fb_home_icon"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("fb_home_icon")));
            log.info("PASS - Facebook Homepage Landing Success.");

        } catch (Exception e) {
            log.error(e);
            log.error("Facebook Homepage - Landing Failure - https://www.facebook.com/");
        }


        // Validate Facebook User Icon Has The Correct Username

        String expectedValue = "Selenium";
        String facebookUserText = facebookHomeIcon.getText();


        try {
            Assert.assertEquals(facebookUserText, expectedValue, "FAIL - Facebook User Icon Title: " + facebookUserText + " is Incorrect.");
            log.info("PASS - Facebook User Icon Title: " + facebookUserText + " is Correct.");
            log.info("SCENARIO PASS - Facebook Login Success!");
            destroyDriver();

        } catch (Exception e) {
            log.error(e);
            log.info("FAIL - Facebook User Icon Title: " + facebookUserText + " is Incorrect.");
            destroyDriver();
        }
        destroyDriver();

    }

}
