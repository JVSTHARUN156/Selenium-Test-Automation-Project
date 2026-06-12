package Selenium.Framework.Utility;
import Selenium.Framework.Elements.Registerpage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class RegisterMethods {
    WebDriver driver;
    public RegisterMethods(WebDriver dr){
        driver=dr;
    }
    Logger log=LoggerFactory.getLogger(RegisterMethods.class);

    public void register()throws Exception{
        Registerpage rg = PageFactory.initElements(driver, Registerpage.class);
        String path=System.getProperty("user.dir");
        String filepath=path+"\\src\\main\\java\\Selenium\\Framework\\TestData\\TC001_RegisterAccount.properties";
        File file=new File(filepath);
        FileInputStream fis=new FileInputStream(file);
        Properties prop=new Properties();
        prop.load(fis);
        rg.firstname.sendKeys(prop.getProperty("Firstname"));
        rg.lastname.sendKeys(prop.getProperty("LastName"));
        rg.dob.sendKeys(prop.getProperty("dob"));
        rg.country.sendKeys(prop.getProperty("Country"));
        rg.postalcode.sendKeys(prop.getProperty("postalcode"));
        rg.houseno.sendKeys(prop.getProperty("houseno"));
        rg.street.sendKeys(prop.getProperty("Street"));
        rg.city.sendKeys(prop.getProperty("city"));
        rg.state.sendKeys(prop.getProperty("State"));
        rg.phone.sendKeys(prop.getProperty("Phone"));
        rg.email.sendKeys(prop.getProperty("Email"));
        rg.password.sendKeys(prop.getProperty("Password"));
        rg.registerBtn.click();
        Assertions.assertThat(driver.getCurrentUrl()).contains("register");
        log.info("===== Register Page =====");
    }
}
