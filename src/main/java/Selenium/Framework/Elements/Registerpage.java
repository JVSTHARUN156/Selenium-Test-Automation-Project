package Selenium.Framework.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Registerpage {

        @FindBy(id="first_name")
        public WebElement firstname;

        @FindBys(
                {@FindBy(id="last_name"),@FindBy(xpath="//input[@id='last_name']")}
        )
        public WebElement lastname;

        @FindBys(
            {@FindBy(id="dob"),@FindBy(xpath="//input[@data-test='dob']")}
        )
        public WebElement dob;

        @FindBys(
            {@FindBy(id="country"),@FindBy(xpath="//select[@id='country']")}
        )
        public WebElement country;

        @FindAll({
                @FindBy(id="postal_code"),
                @FindBy(xpath="//input[@id='postal_code']")})
        public WebElement postalcode;

        @FindAll({
            @FindBy(id="house_number"),
            @FindBy(xpath="//input[@id='house_number']")})
        public WebElement houseno;

        @FindAll({
            @FindBy(id="street"),
            @FindBy(xpath="//input[@id='street']")})
        public WebElement street;

        @FindAll({
            @FindBy(id="city"),
            @FindBy(xpath="//input[@id='city']")})
        public WebElement city;

        @FindAll({
            @FindBy(id="state"),
            @FindBy(xpath="//input[@id='state']")})
        public WebElement state;

    @FindBys(
            {@FindBy(id="phone"),@FindBy(xpath="//input[@id='phone']")}
    )
    public WebElement phone;

    @FindBys(
            {@FindBy(id="email"),@FindBy(xpath="//input[@id='email']")}
    )
    public WebElement email;

    @FindBys(
            {@FindBy(id="password"),@FindBy(xpath="//input[@id='password']")}
    )
    public WebElement password;

    @FindAll({
            @FindBy(className="btn-primary"),
            @FindBy(xpath="//button[text()='Register ']")})
    public WebElement registerBtn;

    }




