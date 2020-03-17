package ru.Steps;

import ru.Pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageStep {
    @Step("Выполнено наведение на Ипотека и выбор Ипотека на готовое жилье")
    public void getMouseToIpoteka(){
        new MainPage().goToAndWait();
    }
}
