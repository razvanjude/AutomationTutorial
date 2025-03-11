package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;
    public AlertHelper alertHelper;
    public ElementHelper elementHelper;
    public FrameHelper frameHelper;
    public TabHelper tabHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.alertHelper = new AlertHelper(driver);
        this.elementHelper = new ElementHelper(driver);
        this.frameHelper = new FrameHelper(driver);
        this.tabHelper = new TabHelper(driver);
    }
}
