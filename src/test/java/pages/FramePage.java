package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
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
    }

    public void interactSecondIFrame(){
        frameHelper.switchToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.text2Element);
    }
}
