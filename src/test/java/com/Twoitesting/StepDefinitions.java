package com.Twoitesting;


import com.Twoitesting.hooks.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    private static WebDriver driver;
    private final SharedDictionary sharedDict;

    public StepDefinitions(SharedDictionary sharedDict){
        this.sharedDict = sharedDict;
        this.driver = (WebDriver)sharedDict.readDict("driver");
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/sdocs/auth.php");
    }

}
