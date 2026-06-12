package Selenium.Framework.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChatBotPage {
    @FindBy(xpath="//button[contains(@class,'chat')]")
    public WebElement chatBtn;

    @FindBy(xpath="//button[contains(text(),'Find a product')]")
    public WebElement findproduct;

    @FindBy(xpath="//input[contains(@class,'chat-input')]")
    public WebElement input;

    @FindBy(xpath="//button[contains(@class,'chat-send')]")
    public WebElement sendBtn;

    @FindBy(xpath="//div[contains(@class,'product-name')]")
    public List<WebElement> product;

    @FindBy(xpath = "//button[@data-test='chat-action-back-to-menu']")
    public WebElement backToMenu;

}
