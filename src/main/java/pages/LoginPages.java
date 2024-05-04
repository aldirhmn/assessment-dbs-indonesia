package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Helpers;

public class LoginPages {

    private WebDriver driver;
    private By field_username = By.id("username");
    private By field_password = By.id("password");
    private By button_login = By.xpath("//button[@type='submit']");
    private By text_homePage = By.cssSelector(".subheader");

    public LoginPages(WebDriver driver){
        this.driver = driver;
        Helpers.setDriver(driver);
    }

    public void inputUsername(String username){
        Helpers.takeScreenshot();
        WebElement usernameElement = Helpers.waitForElementVisible(field_username, 80);
        usernameElement.sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(field_password).sendKeys(password);
        Helpers.takeScreenshot();
    }

    public void clickLogin(){
        driver.findElement(button_login).click();
    }

    public void homePage(){
        Helpers.waitForElementVisible(text_homePage, 60);
        Helpers.takeScreenshot();
        System.out.println(driver.findElement(text_homePage).getText());
        driver.quit();
    }

    public void getMessageContains(String message){
        if (driver.getPageSource().contains(message)){
            System.out.println("The Message was Found");
        } else {
            System.out.println("The Message was Not Found");
        }
    }
}
