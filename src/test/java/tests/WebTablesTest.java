package tests;

import helperMethods.ElementHelper;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;
import suites.TestSuite;

public class WebTablesTest extends SharedData {
    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.ELEMENT_SUITE})
    public void metodaTest () {
        modelObject.WebTableModel testData = new modelObject.WebTableModel("src/test/resources/testData/WebTablesData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTableSubMenu();

        // add
        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(testData);

        //edit
        webTablePage.editNewEntry(testData);

        //delete
        webTablePage.deleteNewEntry(testData);

    }

}
