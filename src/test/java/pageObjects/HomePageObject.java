package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePageObject {

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Regisztrálok')]")
    private WebElement registerButton;

    public boolean checkEmailInput() {
        waitForElement(emailInput);
        return emailInput.isDisplayed();
    }
    public boolean checkPhoneNumberInput() {
        waitForElement(phoneNumberInput);
        return phoneNumberInput.isDisplayed();
    }

    public boolean checkRegisterButton() {
        waitForElement(registerButton);
        return registerButton.isDisplayed();
    }
}