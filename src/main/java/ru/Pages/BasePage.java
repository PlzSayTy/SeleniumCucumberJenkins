package ru.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.Steps.BaseStep;
public class BasePage {

    public BasePage() {

        PageFactory.initElements(BaseStep.getDriver(), this);

    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
