package tests;

import helperMethods.ElementHelper;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();

        String firstNameValue = "Gabriel";
        String lastNameValue = "Turcu";
        String emailValue = "t.g@test.ro";
        String genderValue = "Male";
        String mobileValue = "0740123456";
        List<String> subjectValues = Arrays.asList("Arts", "Accounting", "Maths");
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        String pictureValue = "src/test/resources/Screenshot.bmp";
        String addressValue = "Avram Iancu";
        String stateValue = "NCR";
        String cityValue = "Noida";
        String expectedMessage = "Thanks for submitting the form";


        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(firstNameValue,lastNameValue,emailValue,
                genderValue,mobileValue,subjectValues,hobbiesValues,
                pictureValue,addressValue,stateValue,cityValue);

        practiceFormPage.validateEntireContent(expectedMessage,firstNameValue,lastNameValue,
                emailValue,genderValue,mobileValue,subjectValues,hobbiesValues,pictureValue,
                addressValue,stateValue,cityValue);
    }
}





























