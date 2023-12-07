package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.BasePageObject;
import pageObjects.HomePageObject;
import pageObjects.NavigationBarPageObject;
import pageObjects.PricesPageObject;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private HomePageObject home;
    private BasePageObject base;
    private NavigationBarPageObject navbar;
    private PricesPageObject prices;
    private Logger log= Logger.getLogger(StepDefinitions.class.getName());


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        base = new BasePageObject(driver);
        if (scenario.isFailed()) {
            base.takeScreenshot();
            log.info("The '" + scenario.getName() + "' scenario is failed.");
        } else {
            log.info("The '" + scenario.getName() + "'scenario ran successfully.");
        }
        driver.close();
        driver.quit();
    }


    // 1. Scenario
    @Given("the Site is opened")
    public void the_site_is_opened() {
        driver.get("https://www.cleango.hu/");
        driver.manage().window().maximize();
        home = new HomePageObject(driver);
        navbar = new NavigationBarPageObject(driver);
        prices = new PricesPageObject(driver);
        log.info("the Site is opened succesfully");
    }
    @Then("the cleango logo is visible")
    public void the_cleango_logo_is_visible() {
        assertTrue("The cleango logo is not visible",navbar.checkCleangoLogo());
        log.info("the cleango logo is visible");
    }
    @Then("the email input field is visible")
    public void the_email_input_field_is_visible() {
        assertTrue("The Username field is not visible",home.checkEmailInput());
        log.info("the email input field is visible");
    }
    @Then("the phone number input field is visible")
    public void the_phone_number_input_field_is_visible() {
        assertTrue("The Password input field is not visible",home.checkPhoneNumberInput());
        log.info("the phone number input field is visible");
    }
    @Then("the register button is visible")
    public void the_register_button_is_visible() {
        assertTrue("The Login button is not visible",home.checkRegisterButton());
        log.info("the register button is visible");
    }


    @And("The user is navigated to Prices page")
    public void theUserIsNavigatedToPricesPage() {
        navbar.clickOnPrices();
        log.info("The user is navigated to prices page");
    }

    @When("^the (\\w+) brand is selected")
    public void theBrandBrandIsSelected(String brand) {
        prices.selectCarBrand(brand);
        log.info("The car brand is selected");
    }

    @And("^the (\\w+) model is selected")
    public void theModelModelIsSelected(String model) {
        prices.selectCarModel(model);
        log.info("The car model is selected");
    }

    @And("the Go Search button is clicked")
    public void theGoSearchButtonIsClicked() {
        prices.clickGoSearchButton();
        log.info("The Go Search! button is clicked");
    }

    @Then("^the (\\w+ \\w+) card with details is displayed")
    public void theCardWithResultDetailsIsDisplayed(String result) {
        assertTrue("Incorrect result is displayed",prices.checkResultCard(result));
        log.info("The correct result is displayed!");
    }
}