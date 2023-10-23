package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    public void standardLogin(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        //Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Given("Launch the login page saucedemo")
    public void launchTheLoginPageSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("User input a registered username")
    public void userInputARegisteredUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input registered password")
    public void userInputRegisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User cLick login button")
    public void userCLickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in dashboard page")
    public void userInDashboardPage() {
        String inventory = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(inventory, "Products");
        //quit
        driver.close();
    }

    @And("User input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("wrong_sauce");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        //quit
        driver.close();
    }

    @Given("Open Sauce Labs Backpack page")
    public void openSauceLabsBackpackPage() {
        standardLogin();
        //driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @When("User cLick Add to chart button")
    public void userCLickAddToChartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User cLick chart button")
    public void userCLickChartButton() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("User have Sauce Labs Backpack in chart page")
    public void userHaveSauceLabsBackpackInChartPage() {
        driver.findElement(By.id("header_container"));
        String username = driver.findElement(By.id("item_4_title_link")).getText();
        Assert.assertEquals(username, "Sauce Labs Backpack");
        //quit
        driver.close();
    }

    @Given("Open checkout-information page saucedemo")
    public void openCheckoutInformationPageSaucedemo() {
        standardLogin();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @When("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Rakamin");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Indonesia");
    }

    @And("User input postal code")
    public void userInputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("170845");
    }

    @And("User cLick continue button")
    public void userCLickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User in checkout-overview page")
    public void userInCheckoutOverviewPage() {
        String header = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(header, "Checkout: Overview");
        //quit
        driver.close();
    }

    @And("User leave postal code blank")
    public void userLeavePostalCodeBlank() {
    }

    @Then("User get error postal code message")
    public void userGetErrorPostalCodeMessage() {
        String header = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]")).getText();
        Assert.assertEquals(header, "Error: Postal Code is required");
        //quit
        driver.close();
    }
}
