package Selenium.Framework.Utility;

import Selenium.Framework.Elements.loginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loginMethods {

    WebDriver driver;

    public loginMethods(WebDriver dr){
        driver=dr;
    }
    Logger log = LoggerFactory.getLogger(loginMethods.class);

    public void navigateToRegister(){
        loginPage lp = PageFactory.initElements(driver, loginPage.class);
        lp.registerAcc.click();
        Assertions.assertThat(driver.getCurrentUrl()).contains("register");
        log.info("===== Navigated to Register Page =====");
    }


}
