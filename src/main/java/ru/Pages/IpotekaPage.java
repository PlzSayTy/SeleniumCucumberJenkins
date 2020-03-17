package ru.Pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import ru.Steps.BaseStep;

public class IpotekaPage extends BasePage {
    @FindBy(id = "iFrameResizer0")
    WebElement frame;
    JavascriptExecutor executor;
    Wait wait;
    WebDriver driver = BaseStep.getDriver();
    public void changeFrame() {
        driver.switchTo().frame(frame);
    }

    public void fullFill(String xpath, String yourKeys) {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(yourKeys);
    }

    public void waitUntilItChanges(String amountOfCredit, String mounthlyPayment, String requiredIncome, String rate) {
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'amountOfCredit')]"), amountOfCredit));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'monthlyPayment')]"), mounthlyPayment));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'requiredIncome')]"), requiredIncome));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'rate')]"), rate));
    }

    public void JSclick(String xpath) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
    }

    public void assertAllOfThem() {
        Assertions.assertAll("Тест упал из-за процента", (Executable) () ->{
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'amountOfCredit')]")).getText().equals("2 122 000 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'monthlyPayment')]")).getText().equals("17 535 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'requiredIncome')]")).getText().equals("29 224 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'rate')]")).getText().equals("9,4 %"));
        });
    }
    public void clickWaitAndAssert(String clickAfterWait){

        Assert.assertTrue(driver.findElement(By.xpath(clickAfterWait)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(clickAfterWait)).isEnabled());
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(clickAfterWait)));
        JSclick(clickAfterWait);
    }
}
