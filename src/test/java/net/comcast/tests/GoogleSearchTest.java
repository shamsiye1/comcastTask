package net.comcast.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.comcast.pages.GoogleHomePage;
import net.comcast.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test
    public void googleSearchTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("comcast internet service" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("results count = " + results.getText());
    }

    @Test
    public void googleSearchPOMTest() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.isCurrentPage();
        homePage.searchFor("comcast internet service");

        SearchPage searchPage = new SearchPage(driver);
        System.out.println(searchPage.results.getText());
        searchPage.resultTrue();

        System.out.println( searchPage.getResultsCount());

        assertTrue(searchPage.getResultsCount()>0);
    }


}
