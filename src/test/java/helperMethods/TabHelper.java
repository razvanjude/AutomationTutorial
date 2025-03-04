package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabHelper {

    private WebDriver driver;

    public TabHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //aflat cate taburi sunt deschise
        driver.switchTo().window(tabs.get(index)); // se afce switch pe tabul nr 2 deschs de noi
        System.out.println("Url curent este este: " + driver.getCurrentUrl());
    }

    public void closeCurrentTab() {
        driver.close();
    }
}
