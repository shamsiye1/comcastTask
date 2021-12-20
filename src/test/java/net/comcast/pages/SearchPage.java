package net.comcast.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "result-stats")
    public WebElement results;

    // about 54,100,100 results(0.58 seconds)
    public int getResultsCount(){

        String[] resultArr = results.getText().split(" ");
     return Integer.parseInt(resultArr[1].replace(",",""));

    }


    public void resultTrue() {
        assertTrue(results.isDisplayed());
    }

}
