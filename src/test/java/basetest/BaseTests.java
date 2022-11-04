package basetest;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    String BASEURL = "http://www.way2automation.com/angularjs-protractor/webtables/";


    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();


        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASEURL);
        System.out.println("Title name: " + driver.getTitle());
        homePage = new HomePage(driver);
        Assert.assertEquals(BASEURL, "http://www.way2automation.com/angularjs-protractor/webtables/");

    }
    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {

        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/Failed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {

            TakesScreenshot screenshot = (TakesScreenshot) driver; //create a screenshot
            File source = screenshot.getScreenshotAs(OutputType.FILE); // specify the output type
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/Passed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);// error will printout if file or source is not reached
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
