package com.Twoitesting.hooks;

import com.Twoitesting.SharedDictionary;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private final SharedDictionary sharedDict;

    public Hooks(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sharedDict.addDict("driver", driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
