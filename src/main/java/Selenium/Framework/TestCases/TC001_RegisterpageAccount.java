package Selenium.Framework.TestCases;
import io.github.bonigarcia.wdm.WebDriverManager;
import Selenium.Framework.Utility.RegisterMethods;
import Selenium.Framework.Utility.commons;
import Selenium.Framework.Utility.homePageMethods;
import Selenium.Framework.Utility.loginMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC001_RegisterpageAccount {

    commons com = new commons();
    WebDriver driver;


    @Parameters({"browser","env"})
    @BeforeMethod
    public void preCondition(String browser, String env){
        driver = com.openDriver(browser,env);
    }

    @Test
    public void tc001() throws Exception{
        homePageMethods hpm = new homePageMethods(driver);
        com.implicitWait();
        hpm.navigateToSignIn();
        loginMethods lpm = new loginMethods(driver);
        lpm.navigateToRegister();
        Thread.sleep(10000);
        RegisterMethods rg=new RegisterMethods(driver);
        rg.register();
    }

    @AfterMethod
    public void postCondition(){
        com.quitDriver();
    }
}
