package ru.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Steps.BaseStep;
public class BasePage {
    Actions builder;
    Wait<WebDriver> wait;
    JavascriptExecutor executor;
    WebDriver driver;
    public BasePage() {
        driver = BaseStep.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10, 1000);
        builder = new Actions(driver);
        executor = (JavascriptExecutor)driver;
    }
    public void click(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        builder.click(driver.findElement(By.xpath(xpath))).perform();
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
