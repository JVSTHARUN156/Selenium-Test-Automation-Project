package Selenium.Framework.Elements;

import org.openqa.selenium.By;

public class homePage {
    public final By signIn = By.linkText("Sign in");
    public final By contact = By.linkText("Contact");
    public final By home = By.xpath("//a[text()='Home']");
}
