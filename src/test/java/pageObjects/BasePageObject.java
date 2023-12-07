package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BasePageObject {

    public WebDriver driver;

    public BasePageObject (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    void waitForElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }
    void waitForElements(List<WebElement> list){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(list));
    }


    public void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(file, new File("src\\test\\resources\\screenshots"));
    }



}