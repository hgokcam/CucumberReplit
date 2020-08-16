package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BaseDriver {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Random random;

    protected String username = "Tester";
    protected String password = "test";

    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        random = new Random();
    }

    public void waitAndClick(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitClickWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String waitAndGetText(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void clearTextBoxAndSendKeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
    }


}


