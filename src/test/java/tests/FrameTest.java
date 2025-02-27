package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        FrameHelper frameHelper = new FrameHelper(getDriver());

        By  windowsMenuElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(windowsMenuElement);

        By frameElement = By.xpath("//span[text()='Frames']");
        elementHelper.clickJsLocator(frameElement);

        frameHelper.switchToIFrame("frame1");

        By textElement = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement);

        frameHelper.switchToParentFame();

        frameHelper.switchToIFrame("frame2");

        By textElement2 = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement2);
    }
}



































