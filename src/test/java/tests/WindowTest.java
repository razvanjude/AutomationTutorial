package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void metodaTest() {

        JavascriptExecutor js = (JavascriptExecutor) getDriver(); // obiect pt a apleta funtii cum ar fii CLick fortat

        WebElement windowsMenuElement = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", windowsMenuElement); // face un click fortat

        WebElement windowsElement = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();", windowsElement);


        //click new tab
        WebElement newTabButton = getDriver().findElement(By.id("tabButton"));
        newTabButton.click();

        System.out.println("Url curent este: " + getDriver().getCurrentUrl());

        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles()); //aflat cate taburi sunt deschise
        getDriver().switchTo().window(tabs.get(1)); // se afce switch pe tabul nr 2 deschs de noi
        System.out.println("Url al 2-lea este: " + getDriver().getCurrentUrl());

        getDriver().close(); // inchide tabul curent
        getDriver().switchTo().window(tabs.get(0));
        System.out.println("Url curent este: " + getDriver().getCurrentUrl());

        //click new window
        WebElement newWindowElement = getDriver().findElement(By.xpath("//button[@id='windowButton']"));
        newWindowElement.click();

        System.out.println("Url curent este: " + getDriver().getCurrentUrl());

        List<String> windows = new ArrayList<>(getDriver().getWindowHandles()); //aflat cate windows sunt deschise
        getDriver().switchTo().window(windows.get(1)); // se afce switch pe windows nr 2 deschs de noi
        System.out.println("Url al 2-lea este: " + getDriver().getCurrentUrl());
        getDriver().close(); // inchide tabul curent
        getDriver().switchTo().window(windows.get(0));
        System.out.println("Url curent este: " + getDriver().getCurrentUrl());



    }
}















