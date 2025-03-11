package pages;

import org.openqa.selenium.WebDriver;
import pagelocators.IndexLocators;

public class IndexPage extends BasePage { public IndexPage(WebDriver driver) {
    super(driver);
}

    public void clickOnAlertWindowMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsMenuElement);
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickLocator(IndexLocators.alertsElement);
    }

    public void clickOnFrameSubMenu() {
        elementHelper.clickLocator(IndexLocators.frameElement);
    }

    public void clickOnWindowSubMenu() {
        elementHelper.clickLocator(IndexLocators.browserWindowElement);
    }

    public void clickOnFormsMenu() {
        elementHelper.clickJsLocator(IndexLocators.formsMenuElement);
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJsLocator(IndexLocators.practiceFormsElement);
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJsLocator(IndexLocators.elementsMenuElement);
    }

    public void clickOnWebTableSubMenu(){
        elementHelper.clickJsLocator(IndexLocators.webTablesElement);
    }


}
