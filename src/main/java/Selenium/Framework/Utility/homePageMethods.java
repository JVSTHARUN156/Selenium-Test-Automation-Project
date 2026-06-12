package Selenium.Framework.Utility;

import Selenium.Framework.Elements.homePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class homePageMethods {

    public WebDriver driver;
    WebDriverWait wait;

    Logger log = LoggerFactory.getLogger(homePageMethods.class);

    public homePageMethods(WebDriver dr) {

        driver = dr;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void navigateToSignIn() {

        homePage hp = new homePage();

        driver.findElement(hp.signIn).click();

        wait.until(ExpectedConditions.urlContains("login"));

        Assertions.assertThat(driver.getCurrentUrl()).contains("login");

        log.info("===== Navigated to Sign In Page =====");
    }
}