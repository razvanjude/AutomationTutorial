package pages;

import org.openqa.selenium.WebDriver;
import pagelocators.TabWindowLocators;
import modelObject.PracticeFormModel;

public class TabWindowPage extends BasePage{


    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTab(){
        elementHelper.clickLocator(TabWindowLocators.newTabElement);
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void interactWithWindow(){
        elementHelper.clickJsLocator(TabWindowLocators.newWindowElement);
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
