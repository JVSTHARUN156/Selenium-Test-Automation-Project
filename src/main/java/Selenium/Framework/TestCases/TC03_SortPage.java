package Selenium.Framework.TestCases;

import Selenium.Framework.Utility.SortMethods;
import Selenium.Framework.Utility.commons;
import Selenium.Framework.Utility.homePageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC03_SortPage {
    commons com= new commons();
    WebDriver driver;
    WebDriverWait wait;
    @Parameters({"browser","env"})
    @BeforeMethod
    public void preCondition(String browser, String env){
        driver = com.openDriver(browser,env);
    }

    @Test
     public void tc03() throws Exception{
        homePageMethods hpm = new homePageMethods(driver);
        com.implicitWait();
        SortMethods sm=new SortMethods(driver);
        sm.sortpage();
        com.sleep(6);

    }

    @AfterMethod
    public void postCondition(){
        com.quitDriver();
    }


}
