package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPages;
import utilities.Helpers;

public class LoginSteps {

    private WebDriver driver;
    private LoginPages loginPages;

    @Given("User open browser and navigate to Url")
    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(Helpers.getProperty("baseUrl"));
        loginPages = new LoginPages(driver);

    }

    @When("User input username with {string} and password with {string}")
    public void inputCredentials(String username, String password){
        loginPages.inputUsername(username);
        loginPages.inputPassword(password);
    }

    @And("User click button Login")
    public void clickLoginButton(){
        loginPages.clickLogin();
    }

    @Then("User successfully Login and direct to HomePage")
    public void directHomePage(){
        loginPages.homePage();
        loginPages.getMessageContains("You logged into a secure area!");
    }

    @Then("User failed Login and get error message")
    public void failedLogin(){
        loginPages.getMessageContains("Your username is invalid!");
    }
}
