package ru.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import ru.Steps.BaseStep;
public class BasePage {
    Actions builder;
    Wait wait;
    public BasePage() {

        PageFactory.initElements(BaseStep.getDriver(), this);

    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
