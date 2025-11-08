package stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Form {

    WebDriver driver;
    String baseUrl = "https://www.lambdatest.com/selenium-playground";
    String message;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I open the LambdaTest Selenium Playground")
    public void i_open_the_lambda_test_selenium_playground() {
        driver.get(baseUrl);
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String expected) {
        assertTrue(driver.getCurrentUrl().contains(expected));
    }

    @And("I enter the message {string}")
    public void i_enter_the_message(String inputMessage) {
        message = inputMessage;
        WebElement inputBox = driver.findElement(By.cssSelector("#user-message"));
        inputBox.clear();
        inputBox.sendKeys(message);
    }

    @And("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        driver.findElement(By.id("showInput")).click();
    }

    @Then("I should see the same message displayed")
    public void i_should_see_the_same_message_displayed() {
        WebElement output = driver.findElement(By.id("message"));
        assertEquals(message, output.getText());
        System.out.println(message);
        System.out.println(output.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
