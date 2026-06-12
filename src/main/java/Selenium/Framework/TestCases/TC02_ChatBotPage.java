package Selenium.Framework.TestCases;
import Selenium.Framework.Utility.ChatBotMethods;
import Selenium.Framework.Utility.commons;
import Selenium.Framework.Utility.homePageMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC02_ChatBotPage {
    commons com = new commons();
    WebDriver driver;

    @Parameters({"browser","env"})
    @BeforeMethod
    public void preCondition(String browser, String env){
        driver = com.openDriver(browser,env);
    }

    @Test
    public void tc02(){
        homePageMethods hpm = new homePageMethods(driver);
        com.implicitWait();

        ChatBotMethods cb = new ChatBotMethods(driver);
        cb.chat("Pliers");
    }

    @AfterMethod
    public void postCondition(){
        com.quitDriver();
    }
}


