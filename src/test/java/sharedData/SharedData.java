
package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;


    //inainte de fiecare metoda de test se executa aceastA secventa
    @BeforeMethod(alwaysRun = true)
    public void prepareEnviroment() {
        testName = this.getClass().getSimpleName();

        String remoteEnv = System.getProperty("cicd"); //Luam setarea "false" setat in POM.xml
        //conversie un String in Boolean
        if (Boolean.parseBoolean(remoteEnv)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new"); //setam ca testele noastre sa se ruleze headles(adica fara sa deschida browser) in github actions
            driver = new ChromeDriver(options);
            //deschidem un chrome browser}
        } else {
            driver = new ChromeDriver();
        }

        //accesam o pagina web
        driver.get("https://demoqa.com");

        //facem browserul in modul maximize
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(testName);

    }

    @AfterMethod(alwaysRun = true)
    public void clearEnviroment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }

    public WebDriver getDriver() {
        return driver;
    }
}