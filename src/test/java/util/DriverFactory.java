package util;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



/**
 * Created by adam.hannisick on 11/12/2019.
 * WebDriver Factory
 * Based on browser.properties for config
 */

public class DriverFactory {
    public static WebDriver driver;
    public static WebDriverWait waitVar;
//    public static WebDriverWait wait = new WebDriverWait(driver, 10);
//    public static int waitTime = 30;
    public static String propertyFileName = null;
    public static String browser = "";
    public static String URL1 = new PropertyReader().readProperty("URL");

    public static void getDriverInstance()  {
        System.out.println("Before Class");
        browser = new PropertyReader().readProperty("browser");
        createNewDriverInstance(browser);
    }

    //browser.properties has browser=[value]. function pulls to declare browser.
    public static void createNewDriverInstance(final String browserID) {

        if (browserID == null){
            returnFireFoxDriver();
            propertyFileName = "FireFox";
        }
        if (browserID.equalsIgnoreCase("firefox")) {
            returnFireFoxDriver();
            propertyFileName = "FireFox";
        }
        if (browserID.equalsIgnoreCase("chrome")) {
            returnChromeDriver();
            propertyFileName = "Chrome";
        }
        if (browserID.equalsIgnoreCase("IE")) {
            returnIEDriver();
            propertyFileName = "IE";
        }
        if (browserID.equalsIgnoreCase("Edge")) {
            returnEdgeDriver();
            propertyFileName = "Edge";
        }

        if (browserID.equalsIgnoreCase("Opera")) {
            returnOperaDriver();
            propertyFileName = "Opera";
        }
//        if (browserID.equalsIgnoreCase("Grid")){
//            returnGridDriver();
//            propertyFileName= "Grid";
//        }
    }

//    public static void returnGridDriver(){
//        WebDriverManager.griddriver.setup()
//
//    }

    public static void returnChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Chrome started");
    }

    public static void returnFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("FireFox started");
    }

    public static void returnIEDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("IE started");
    }

    public static void returnOperaDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Opera Started");
    }

    public static void returnEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Edge Started");
    }

    public static void destroyDriver() {
        System.out.println("Driver Quit...");
        driver.quit();
    }

    //Called on any Scenario fails.
    public static void screenShot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}