package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pagelocators.AlertLocators;
import modelObject.AlertModel;

public class AlertPage extends BasePage {

        public AlertPage(WebDriver driver) {

            super(driver);
        }

    public void interaptWithAcceptAlert() {
        elementHelper.clickJsLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user checked first alert ");
    }

    public void interactWithTimerAlert() {
        elementHelper.clickJsLocator(AlertLocators.alertTimerElement);
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user checked 2nd alert ");
    }

    public void  interactWithCancelAlert() {
        elementHelper.clickJsLocator(AlertLocators.alertOkCancelElement);
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("The user checked 3rd alert ");
    }

    public void interactWithValueAlert(AlertModel testData) {
        elementHelper.clickJsLocator(AlertLocators.alertTextElement);
        alertHelper.fillTextAlert(testData.getPromptData());
        LoggerUtility.infoLog("The user checked 4th alert ");
    }
}
