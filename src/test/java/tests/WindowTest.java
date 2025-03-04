package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        TabHelper tabHelper = new TabHelper(getDriver());

        //JavascriptExecutor js = (JavascriptExecutor) getDriver(); // obiect pt a apleta funtii cum ar fii CLick fortat

        By windowsMenuElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(windowsMenuElement);

        By windowsElement = By.xpath("//span[text()='Browser Windows']");
       elementHelper.clickJsLocator(windowsElement);


        //click new tab
        By newTabButton = By.id("tabButton");
        elementHelper.clickLocator(newTabButton);
        System.out.println("Url curent este: " + getDriver().getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //click new window
        By newWindowElement = By.xpath("//button[@id='windowButton']");
        elementHelper.clickLocator(newWindowElement);

        System.out.println("Url curent este: " + getDriver().getCurrentUrl());
    }
}















