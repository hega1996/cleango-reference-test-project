package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricesPageObject extends BasePageObject {

    public PricesPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='searchVehicleBrand']")
    private WebElement brandInput;

    @FindBy(xpath = "//input[@id='searchVehicleModel']")
    private WebElement modelInput;

    @FindBy(xpath = "//button[contains(.,'Go search!') or contains(.,'Megkeresem')]")
    private WebElement goSearchButton;

    public void selectCarBrand(String carbrand) {
        waitForElement(brandInput);
        brandInput.sendKeys(carbrand);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='brand["+carbrand+"]']")));
        driver.findElement(By.xpath("//input[@id='brand["+carbrand+"]']")).click();
    }

    public void selectCarModel(String model) {
        waitForElement(modelInput);
        modelInput.sendKeys(model);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='brand[" + model + "]']")));
        driver.findElement(By.xpath("//input[@id='brand[" + model + "]']")).click();
    }

    public void clickGoSearchButton() {
        waitForElement(goSearchButton);
        goSearchButton.click();
    }

    public boolean checkResultCard(String result) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(.,'"+result+"')]")));
        WebElement result_card = driver.findElement(By.xpath("//h3[contains(.,'"+result+"')]"));
        return result_card.isDisplayed();
    }

}
