package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pagelocators.FrameLocators;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }
    public void interactFirstIFrame(){
        frameHelper.switchToIFrame("frame1");
        elementHelper.printLocatorText(FrameLocators.textElement);
        frameHelper.switchToParentFrame();
        LoggerUtility.infoLog("The user opened first frame ");
    }

    public void interactSecondIFrame(){
        frameHelper.switchToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.text2Element);
        LoggerUtility.infoLog("The user opened second frame ");
    }
}
