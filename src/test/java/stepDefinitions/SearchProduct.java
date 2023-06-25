package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

    WebDriver driver;

    @Given("I navigate to home page")
    public void i_navigate_to_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Boban/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.anhoch.com/");
        driver.manage().window().maximize();

        String url = driver.getCurrentUrl();
        System.out.println("Current url is:"+url);

    }
    @When("I click on search field, for research products")
    public void i_click_on_search_field_for_research_products() throws InterruptedException {
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(2000);
    }
    @Then("I enter product name")
    public void i_enter_product_name() throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys("Samsung");
        Thread.sleep(2000);
    }
    @Then("Verify that search button is displayed")
    public void verify_that_search_button_is_displayed() throws InterruptedException {
        boolean d = driver.findElement(By.className("icon-search")).isDisplayed();
        Assert.assertTrue(d);
        System.out.println(d);
        Thread.sleep(2000);
    }
    @Then("Click search button")
    public void click_search_button() {
        driver.findElement(By.className("icon-search")).click();

    }

}
