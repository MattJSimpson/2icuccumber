package com.Twoitesting;

import com.Twoitesting.hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static com.Twoitesting.hooks.Hooks.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class LoginSteps {

    private final WebDriver driver;
    private final SharedDictionary sharedDict;


    public LoginSteps(SharedDictionary sharedDict){
        this.sharedDict = sharedDict;
        this.driver = (WebDriver)sharedDict.readDict("driver");
    }


    @When("I use the username {string} and password {string}")
    public void i_use_the_username_and_password(String username, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.linkText("Submit")).click();
    }

    @Then("I am logged in")
    public void i_am_logged_in() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        assertThat("We are not logged in", driver.findElement(By.linkText("Log Out")).isDisplayed(), is(true));
    }

    @When("I use the valid login credentials")
    public void i_use_the_valid_login_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String,String>> logins = dataTable.asMaps(String.class,String.class);

        for (var login:logins) {
            driver.findElement(By.id("username")).sendKeys(login.get("username"));
            driver.findElement(By.id("password")).sendKeys(login.get("password"));
            Thread.sleep(3000);
        }
        driver.findElement(By.linkText("Submit")).click();
    }
}
