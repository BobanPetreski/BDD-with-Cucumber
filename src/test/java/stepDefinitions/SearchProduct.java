package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

    static WebDriver driver;

    @Given("I navigate to home page")
    public void i_navigate_to_home_page() {
        WebDriverManager.chromedriver().setup();
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
        driver.findElement(By.name("search")).sendKeys("Samsung S23");
        Thread.sleep(2000);
    }

    @And("Click on the requested product")
    public void click_on_the_requested_product() {
        driver.findElement(By.linkText("Samsung Galaxy S23 Plus 5G 8GB/512GB Cream")).click();
    }

    @Then("Add product to shopping cart")
    public void add_product_to_shopping_cart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"product\"]/div[1]/div[2]/section/div/div[2]/div/div[3]/div/button")).click();
        Thread.sleep(4000);
    }


    // Shopping Cart


    @Given("I am in shopping cart")
    public void i_am_in_shopping_cart()throws InterruptedException  {
        String url = driver.getCurrentUrl();
        System.out.println("Current url is:"+url);
        Thread.sleep(2000);
    }

    @When("I check the name of heading")
    public void i_check_the_name_of_heading() {

        String expectedHeading = "Вашата кошничка";

        String heading = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/h1")).getText();
        if(expectedHeading.equalsIgnoreCase(heading))
            System.out.println("The expected heading is same as actual heading --- "+heading);
        else
            System.out.println("The expected heading doesn't match the actual heading --- "+heading);

    }

    @Then("I check the price of the product")
    public void i_check_the_price_of_the_product() {

        WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[4]"));
        String productPrice = priceElement.getText();
        System.out.println("The price of the product is: " + productPrice);

    }

    @And("I increase the quantity of the product")
    public void i_increase_the_quantity_of_the_product() throws InterruptedException {
        driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a[1]/i[1]")).click();
        Thread.sleep(5000);
    }

    @Then("I check the price after increasing")
    public void i_check_the_price_after_increasing() {
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[5]"));
        String productTotal = totalPrice.getText();
        System.out.println("The price of the product after increasing is: " + productTotal);


    }



}
