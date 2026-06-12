package Selenium.Framework.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class loginPage {

    @FindBy(id="email")
    public WebElement email;

    @FindBys(
            {@FindBy(id="password"),@FindBy(xpath="//input[@data-test='password']")}
    )
    public WebElement pwd;

    @FindAll({
            @FindBy(className="btnSubmit"),
            @FindBy(xpath="//input[@aria-label='Login']")})
    public WebElement loginBtn;

    @FindBy(linkText = "Register your account")
    public WebElement registerAcc;

}
