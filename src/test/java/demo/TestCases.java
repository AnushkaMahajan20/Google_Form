package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*

     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
//happy coding 
     @Test
public void testCase01() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

    WebElement nameInputBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@type='text'])[1]")));

    Wrappers.enterText(nameInputBox, "Crio Learner");
                System.out.println("Your name has been entered successfully!");
    WebElement practicingAutomationTextArea = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(),'Why are you practicing Automation')]/ancestor::div[@role='listitem']//textarea")));

    String practicingAutomationText = "I want to be the best QA Engineer!";
    System.out.println("The reason for practicing automation has been defined successfully!");
    String epochTimeString = Wrappers.getEpochTimeString();

    Wrappers.enterText(practicingAutomationTextArea,
            practicingAutomationText + " " + epochTimeString);

    Wrappers.radioButton(driver, "3 - 5");
    System.out.println("The experience level has been selected successfully!");
    Wrappers.checkBox(driver, "Java");
    Wrappers.checkBox(driver, "Selenium");
    Wrappers.checkBox(driver, "TestNG");
    System.out.println("The skills have been selected successfully!");

    WebElement dropDoWebElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'DEh1R')]")));

    Wrappers.clickOnElement(driver, dropDoWebElement);

    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@role='option']//span[text()='Mrs']")));

    List<WebElement> dropDownList = driver.findElements(
            By.xpath("//div[@role='option']//span[text()='Mr' or text()='Ms' or text()='Mrs' or text()='Dr' or text()='Rather not say']"));

    Wrappers.dropDownClickByLoop(dropDownList, "Mrs");
    System.out.println("The dropdown option has been selected successfully!");

    WebElement dateInputBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@aria-labelledby='i56']")));

    String sevenDaysAgoDate = Wrappers.getdateSevenDaysAgo(7);

    Wrappers.enterText(dateInputBox, sevenDaysAgoDate);
        System.out.println("The date has been entered successfully!");

    WebElement hourElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@aria-label='Hour']")));

    WebElement minElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@aria-label='Minute']")));
                    System.out.println("The hour and minute input boxes have been located successfully!");

    WebElement submitBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Submit']")));

    Wrappers.enterText(hourElement, "07");

    Wrappers.enterText(minElement, "30");

    Wrappers.clickOnElement(driver, submitBtn);

    WebElement successMsgElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='vHW8K']")));

    successMsgElement.getText();
 }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}