package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By formsMenuElement = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJsLocator(formsMenuElement);

        By practiceFormElement =By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJsLocator(practiceFormElement);

        By firstnameElement = By.xpath("//input[@placeholder= 'First Name']");
        String firstNameValue = "Razvan";
        elementHelper.fillLocator(firstnameElement,firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder= 'Last Name']");
        String lastNameValue = "Jude";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement = By.xpath("//input[@placeholder= 'name@example.com']");
        String emailValue= "test@gmail.com";
        elementHelper.fillLocator(emailElement,emailValue);


        String genderValue = "Male";
        By genderLocator = By.xpath("//label[contains(@for,'gender-radio')]");
        List<WebElement> genderElement = elementHelper.getListElements(genderLocator);
        switch (genderValue) {
            case "Male" :
                elementHelper.clickJsLocator(genderElement.get(0));
                break;
            case "Female" :
                elementHelper.clickJsLocator(genderElement.get(1));
                break;
            case "Other" :
                elementHelper.clickJsLocator(genderElement.get(3));
                break;
        }

        By mobileNumber = By.xpath("//input[@placeholder= 'Mobile Number']");
        String mobileValue = "0744123321";
        elementHelper.fillLocator(mobileNumber,mobileValue);


        By subjectElement = By.id("subjectsInput");
        List<String> subjectValues = Arrays.asList("Arts", "Maths", "Biology");
        for (String subject: subjectValues) {
            elementHelper.fillPressLocator(subjectElement,subject,Keys.ENTER);
        }

        By hobbiesLocator = By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']");
        List<WebElement> hobbiesElement= elementHelper.getListElements(hobbiesLocator);
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        for (WebElement hobby:hobbiesElement){
            if (hobbiesValues.contains(hobby.getText())){
                elementHelper.clickJsLocator(hobby);
            }
        }

        //inserare fisier
        By pictureElement = By.cssSelector("input[type = 'file']");
        String pictureValue = "src/test/resources/Selenium text.txt";
        File file = new File(pictureValue);
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By addressElement = By.cssSelector("#currentAddress");
        String addressValues = "Str. Ion Creanga";
        elementHelper.fillLocator(addressElement,addressValues);

        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJsLocator(stateElement);

        By stateInput = By.cssSelector("#react-select-3-input");
        String stateValue = "NCR";
        elementHelper.fillPressLocator(stateInput,stateValue,Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJsLocator(cityElement);

        By cityInput = By.cssSelector("#react-select-4-input");
        String cityValue = "Noida";
        elementHelper.fillPressLocator(cityInput,cityValue,Keys.ENTER);

        By submitButton = By.cssSelector("#submit");
        elementHelper.clickJsLocator(submitButton);

//        //facem un wait ca sa descopere elementul cu textul -->Thanks for submitting the form
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#example-modal-sizes-title-lg")));

        By thankYouElement = By.cssSelector("#example-modal-sizes-title-lg");
        String expectedMessage = "Thanks for submitting the form";
        elementHelper.validateElementText(thankYouElement,expectedMessage);

        By tableContentListLocator = By.cssSelector(".table.table-dark>tbody>tr");
        List<WebElement> tableContentList = elementHelper.getListElements(tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0),firstNameValue + ' ' +lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1),emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbiesValue = String.join(", ", hobbiesValues);
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbiesValue);

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9),cityValue);

        //Assert.assertTrue(tableContentList.get(0).getText().contains("Student Name"));
        //Assert.assertTrue(tableContentList.get(0).getText().contains(firstNameValue + ' ' +lastNameValue));

        //Assert.assertTrue(tableContentList.get(1).getText().contains("Student Email"));
       // Assert.assertTrue(tableContentList.get(1).getText().contains(emailValue));

//        Assert.assertTrue(tableContentList.get(5).getText().contains("Subjects"));
//        String subjectValue = String.join(", ", subjectValues);
//        Assert.assertTrue(tableContentList.get(5).getText().contains(subjectValue));

//        Assert.assertTrue(tableContentList.get(6).getText().contains("Hobbies"));
//        String hobbiesValue = String.join(", ", hobbiesValues);
//        Assert.assertTrue(tableContentList.get(6).getText().contains(hobbiesValue));

//        Assert.assertTrue(tableContentList.get(7).getText().contains("Picture"));
//        String fileName = file.getName();
//        Assert.assertTrue(tableContentList.get(7).getText().contains(fileName));
//
//        Assert.assertTrue(tableContentList.get(9).getText().contains("State and City"));
//        Assert.assertTrue(tableContentList.get(9).getText().contains(cityValue));

    }
}





























