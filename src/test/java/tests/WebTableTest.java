package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void metodaTest() throws InterruptedException {

        //deschidem un browser
        driver = new ChromeDriver();

        //Accesam o pagina web

        driver.get("https://demoqa.com");

        //Facem browser in modul maximize
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement FormMenuElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        js.executeScript("arguments[0].click();", FormMenuElement); // face un click fortat

        WebElement FormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        js.executeScript("arguments[0].click();", FormElement);

        //Identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Razvan";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Jude";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@tester.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "20";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "10000";
        salaryElement.sendKeys(salaryValue);

        WebElement departamentElement = driver.findElement(By.id("department"));
        String departamentValue = "IT";
        departamentElement.sendKeys(departamentValue);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);

        String actualResult = driver.findElement(By.tagName("h1")).getText();
        String expectedResult = "Web Tables";
        Assert.assertEquals(actualResult, expectedResult);

        //Edit function
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();
    }
}
