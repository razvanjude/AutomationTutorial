package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import modelObject.WebTableModel;
import pagelocators.WebTableLocators;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {

        super(driver);
    }

    public void addNewEntry(WebTableModel testData) {
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator, testData.getNewTableSize()-1);
        elementHelper.clickJsLocator(WebTableLocators.addElement);
        elementHelper.fillLocator(WebTableLocators.firstNameElement, testData.getFirstnameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstnameValue());

        elementHelper.fillLocator(WebTableLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(WebTableLocators.userEmailElement, testData.getUserEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getUserEmailValue());

        elementHelper.fillLocator(WebTableLocators.ageElement, testData.getAgeValue());
        LoggerUtility.infoLog("The user fills Age with value: " + testData.getAgeValue());

        elementHelper.fillLocator(WebTableLocators.salaryElement, testData.getSalaryValue());
        LoggerUtility.infoLog("The user fills Salary with value: " + testData.getSalaryValue());

        elementHelper.fillLocator(WebTableLocators.departmentElement, testData.getDepartmentValue());
        LoggerUtility.infoLog("The user fills Department with value: " + testData.getDepartmentValue());

        elementHelper.clickJsLocator(WebTableLocators.submitElement);
        LoggerUtility.infoLog("The user clicks Submit button ");

        //validăm că avem 4 rânduri în tabel
        elementHelper.validateSizeList(WebTableLocators.addTableElementLocator, testData.getNewTableSize());
        //validăm conținutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElementLocator);
        String rowText = addTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstnameValue()));
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        Assert.assertTrue(rowText.contains(testData.getUserEmailValue()));
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
    }

    public void editNewEntry(modelObject.WebTableModel testData) {
        elementHelper.clickJsLocator(WebTableLocators.editElement);
        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement,testData.getEditSalaryValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement,testData.getEditDepartmentValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement,testData.getEditAgeValue());
        elementHelper.clickJsLocator(WebTableLocators.editSubmitElement);
        //validăm valorile modificate
        elementHelper.validateSizeList(WebTableLocators.editTableElementLocator, testData.getNewTableSize());
        //validăm conținutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElementLocator);
        String editRowText = editTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(editRowText.contains(testData.getEditDepartmentValue()));
        Assert.assertTrue(editRowText.contains(testData.getEditSalaryValue()));
        Assert.assertTrue(editRowText.contains(testData.getEditAgeValue()));
    }

    public void deleteNewEntry(modelObject.WebTableModel testData) {
        elementHelper.clickJsLocator(WebTableLocators.deleteElement);
        elementHelper.validateSizeList(WebTableLocators.deleteTableElementLocator, testData.getActualTableSize());
    }
}
