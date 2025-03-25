package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pagelocators.IndexLocators;

public class IndexPage extends BasePage {



    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertWindowMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsMenuElement);
        LoggerUtility.infoLog("The user clicks on Alert Window Menu");
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsElement);
        LoggerUtility.infoLog("The user clicks on Alert Sub Menu");
    }

    public void clickOnFrameSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.frameElement);
        LoggerUtility.infoLog("The user clicks on Frame Sub Menu");
    }

    public void clickOnWindowSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.browserWindowElement);
        LoggerUtility.infoLog("The user clicks on Window Sub Menu");
    }

    public void clickOnFormsMenu() {
        elementHelper.clickJsLocator(IndexLocators.formsMenuElement);
        LoggerUtility.infoLog("The user clicks on Forms Menu");
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJsLocator(IndexLocators.practiceFormsElement);
        LoggerUtility.infoLog("The user clicks on Form Sub Menu");
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJsLocator(IndexLocators.elementsMenuElement);
        LoggerUtility.infoLog("The user clicks on Elements Menu");
    }

    public void clickOnWebTableSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.webTablesElement);
        LoggerUtility.infoLog("The user clicks on Table Sub Menu");
    }

}
