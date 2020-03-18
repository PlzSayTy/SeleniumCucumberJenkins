package ru.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.Locale;

public class MainPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(), 'Ипотека')]")
    WebElement ipoteka;
    @FindBy(xpath = "//a[contains(text(), 'Ипотека на готовое жиль')]")
    WebElement clickAfterWait;
    public void goToAndWait(){
        //ipoteka.click();
        builder.moveToElement(ipoteka).perform();
        wait.until(ExpectedConditions.elementToBeClickable(clickAfterWait));
        clickAfterWait.click();
    }
}
