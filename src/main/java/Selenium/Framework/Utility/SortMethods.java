package Selenium.Framework.Utility;

import Selenium.Framework.Elements.SortPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class SortMethods {
    WebDriver driver;
    WebDriverWait wait;
    Logger log=LoggerFactory.getLogger(SortPage.class);
    public SortMethods(WebDriver dr){
        driver=dr;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void sortpage(){
        SortPage sp= PageFactory.initElements(driver,SortPage.class);
        Select s = new Select(sp.sort);
        s.selectByValue("name,asc");
        List<WebElement> selectedValue = s.getAllSelectedOptions();
        System.out.println(selectedValue.get(0).getText());
        log.info("Page sorted to (A - Z)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Name (A - Z)']")));


    }

}

