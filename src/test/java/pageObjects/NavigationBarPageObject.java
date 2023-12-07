package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBarPageObject extends BasePageObject {

    public NavigationBarPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//header//img[contains(@src,'logo')]")
    private WebElement cleangoLogo;

    @FindBy(xpath = "//nav//a[contains(@href,'prices')]")
    private WebElement pricesMenuItem;


    public boolean checkCleangoLogo() {
        waitForElement(cleangoLogo);
        return cleangoLogo.isDisplayed();
    }

    public boolean checkPrices() {
        waitForElement(pricesMenuItem);
        return pricesMenuItem.isDisplayed();
    }

    public void clickOnPrices() {
        waitForElement(pricesMenuItem);
        pricesMenuItem.click();
    }



}
