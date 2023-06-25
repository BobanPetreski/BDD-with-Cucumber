package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AnhochSteps {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Boban/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I open Anhoch homapage")
    public void i_open_anhoch_homapage() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Then("I verify that logo is displayed on page")
    public void i_verify_that_logo_is_displayed_on_page() throws InterruptedException {
        boolean b = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div/a/img")).isDisplayed();
        Assert.assertTrue(b);
        System.out.println(b);
    }

    @And("I click login button")
    public void i_click_login_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a")).click();
        Thread.sleep(2000);
    }

    @When("I enter valid email and password")
    public void i_enter_valid_email_and_password() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/form/div[1]/div/input")).sendKeys("bosh.petreski@gmail.com");

        driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]")).sendKeys("bobo0709");
        Thread.sleep(2000);
    }

    @Then("I click ok button")
    public void i_click_ok_button() throws InterruptedException {
       WebElement el = driver.findElement(By.xpath("//button[contains(text(),'Најавете се')]"));
       String str = el.getAttribute("value");
       if (str.equals("Најавете се")){
           System.out.println("test case passed");
       }
       el.click();
        
        Thread.sleep(2000);
    }

    @When("I click on dropdown button")
    public void i_click_on_dropdown_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a")).click();
        Thread.sleep(2000);
    }

    @Then("I click on review of orders")
    public void i_click_on_review_of_orders() throws InterruptedException {
       driver.findElement(By.linkText("Преглед на нарачки")).click();
       Thread.sleep(2000);
    }

    @When("I checked current URL")
    public void i_checked_current_url() throws InterruptedException {
        String orUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:" +orUrl);
        Thread.sleep(2000);
    }

    @And("close browser")
    public void close_browser() {
        driver.quit();
    }
}

