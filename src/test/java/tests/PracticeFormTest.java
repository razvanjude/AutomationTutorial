package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import modelObject.PracticeFormModel;
import suites.TestSuite;

public class PracticeFormTest extends SharedData {

    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.FORM_SUITE})
    public void metodaTest() {

        PracticeFormModel testData = new modelObject.PracticeFormModel("src/test/resources/testData/PracticeFormData.json");
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();


        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(testData);

        practiceFormPage.validateEntireContent(testData);
    }
}





























