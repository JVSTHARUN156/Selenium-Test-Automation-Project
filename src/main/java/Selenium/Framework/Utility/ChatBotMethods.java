package Selenium.Framework.Utility;
import Selenium.Framework.Elements.ChatBotPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class ChatBotMethods {

    public WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerFactory.getLogger(ChatBotMethods.class);

    public ChatBotMethods(WebDriver dr){
        driver=dr;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));

    }

public void chat(String prodname){
    ChatBotPage cb = PageFactory.initElements(driver, ChatBotPage.class);
    cb.chatBtn.click();
    cb.findproduct.click();
    cb.input.sendKeys(prodname);
    cb.sendBtn.click();

    List<WebElement> products = cb.product;
    Assertions.assertThat(products.size()).as("Product list is empty").isGreaterThan(0);
    Assertions.assertThat(products.get(0).getText()).as("Expected product text not found").contains("Pliers");
    cb.backToMenu.click();

}

}
