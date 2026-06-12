package Selenium.Framework.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class commons {

    Logger log = LoggerFactory.getLogger(commons.class);

    WebDriver driver;

    public WebDriver openDriver(String browser,String env){

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        log.info("===== Opening "+browser+" driver =====");

        switch (env.toLowerCase()){
            case "qa":
                driver.get("https://practicesoftwaretesting.com");
                log.info("===== Opening QA Env =====");
                break;

            case "dev":
                driver.get("https://dev.practicesoftwaretesting.com");
                log.info("===== Opening Dev Env =====");
                break;

            case "uat":
                driver.get("https://uat.practicesoftwaretesting.com");
                log.info("===== Opening UAT Env =====");
                break;

            default:
                log.info("===== Incorrect Environment =====");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }

    public void quitDriver(){
        log.info("===== Quitting the Driver =====");
        driver.quit();
    }

    public void sleep() throws Exception{
        Thread.sleep(60000);
    }

    public void sleep(int seconds) throws Exception{
        Thread.sleep(seconds*1000);
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    public HashMap<String, Object> readDataFromPropFile(String fileName, String... props) throws Exception{
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\APIAutomation\\TestData";
        filePath = filePath+"\\"+fileName+".properties";

        log.info("===== Reading the Properties file from: "+filePath+" =====");

        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        HashMap<String,Object> hm = new HashMap<>();
        for(String s: props){
            hm.put(s,prop.getProperty(s));
        }

        return hm;
    }
}
