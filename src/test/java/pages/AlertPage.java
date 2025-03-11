package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pagelocators.AlertLocators;

public class AlertPage extends BasePage {

        public AlertPage(WebDriver driver) {
        super(driver);
        }

    public void interaptWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.alertTimerElement);
        alertHelper.acceptAlert();
    }

    public void  interactWithCancelAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkCancelElement);
        alertHelper.cancelAlert();
    }

    public void interactWithValueAlert(String value) {
        elementHelper.clickLocator(AlertLocators.alertTextElement);
        alertHelper.fillTextAlert(value);
    }
}
