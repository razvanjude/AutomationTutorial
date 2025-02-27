package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RadioButton {

    public WebDriver driver;

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void useRadioButton() throws InterruptedException {

        //deschidem un browser
        driver = new ChromeDriver();

        //Accesam o pagina web
        driver.get("https://demoqa.com/radio-button");

        //Facem browser in modul maximize
        driver.manage().window().maximize();

        //wait 2 seconds
        Thread.sleep(2000);

       // WebElement yesRadioButton = driver.findElement(By.name("like"));
        WebElement yesRadioButton = driver.findElement(By.className("custom-control-label"));
        yesRadioButton.click();

        //String actualresult = driver.findElement(By.className("text-success")).getText();
        String actualResult = driver.findElement(By.tagName("p")).getText();
        String expectedResult = "You have selected Yes";
        Assert.assertEquals(actualResult, expectedResult);

    }
}
