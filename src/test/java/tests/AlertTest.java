package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertTest extends SharedData {


    @Test
    public void metodaTest() {

        AlertHelper alertHelper = new AlertHelper(getDriver());//facem un obiect care are acces la metodele mele de ajutor-->Alerthelper
        ElementHelper elementHelper = new ElementHelper(getDriver());

        By AlertsElementsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(AlertsElementsMenu);

        By alerts = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJsLocator(alerts);

        By AlertOKElement = By.id("alertButton");
        elementHelper.clickLocator(AlertOKElement);
        alertHelper.acceptAlert();

        By alertTimerElement = By.id("timerAlertButton");
        elementHelper.clickLocator(alertTimerElement);
        //asteptam 10 secunde pana apare alerta
        alertHelper.acceptAlert();

        //facem alerta 3
        By alertOKCancelElement = By.id("confirmButton");
        elementHelper.clickLocator(alertOKCancelElement);
        alertHelper.cancelAlert();

        //facem alerta nr 4
        By alertTextElement = By.id("promtButton");
        elementHelper.clickLocator(alertTextElement);
        alertHelper.fillTextAlert("Razvan");

    }
}

































