package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class EditEntry {

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

        driver.get("https://demoqa.com/webtables");

        //Facem browser in modul maximize
        driver.manage().window().maximize();

        WebElement editButtonElement = driver.findElement(By.id("edit-record-1"));
        editButtonElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        firstNameElement.clear();
        String firstNameValue = "Vasile";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        lastNameElement.clear();
        String lastNameValue = "Vasilescu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        emailElement.clear();
        String emailValue = "User@tester.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        ageElement.clear();
        String ageValue = "200";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        salaryElement.clear();
        String salaryValue = "9999";
        salaryElement.sendKeys(salaryValue);

        WebElement departamentElement = driver.findElement(By.id("department"));
        departamentElement.clear();
        String departamentValue = "HR";
        departamentElement.sendKeys(departamentValue);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);

        String actualResult = driver.findElement(By.tagName("h1")).getText();
        String expectedResult = "Web Tables";
        Assert.assertEquals(actualResult, expectedResult);

        //delete
        WebElement deleteElement = driver.findElement(By.id("edit-record-3"));
        deleteElement.click();


    }
}
