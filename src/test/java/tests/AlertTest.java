package tests;

import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;
import suites.TestSuite;
import suites.TestcaseSuite;

public class AlertTest extends SharedData {

    @Test (groups = {TestSuite.REGRESSION_SUITE,TestSuite.ALERT_FRAME_SUITE, TestcaseSuite.TICKET_123,TestcaseSuite.TC_4156})
    public void metodaTest() {

        AlertModel testData = new AlertModel("src/test/resources/testData/AlertData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interaptWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithValueAlert(testData);
    }
}