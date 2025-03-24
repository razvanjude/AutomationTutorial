package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagelocators.PracticeFormLocators;
import modelObject.PracticeFormModel;

import java.io.File;
import java.util.List;
public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(PracticeFormModel testData) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstNameValue());

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(PracticeFormLocators.emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getEmailValue());

        List<WebElement> genderElement = elementHelper.getListElements(PracticeFormLocators.genderLocator);
        switch (testData.getGenderValue()) {
            case "Male":
                elementHelper.clickJsLocator(genderElement.get(0));
                break;
            case "Female":
                elementHelper.clickJsLocator(genderElement.get(1));
                break;
            case "Other":
                elementHelper.clickJsLocator(genderElement.get(3));
                break;
            default:
                System.out.println("Nu există alte valori");
                break;
        }
        LoggerUtility.infoLog("The user checks Gender box: " + testData.getGenderValue());

        elementHelper.fillLocator(PracticeFormLocators.mobileElement, testData.getMobileValue());
        LoggerUtility.infoLog("The user fills Mobile with value: " + testData.getMobileValue());

        for (String subject : testData.getSubjectValues()) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
            LoggerUtility.infoLog("The user fills Subject with value: " + subject);
        }


        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (testData.getHobbiesValues().contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
                LoggerUtility.infoLog("The user checks Hobbies box: " + hobby.getText());
            }
        }

        File file = new File(testData.getPictureValue());
        elementHelper.fillLocator(PracticeFormLocators.pictureElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads Picture with file: " + testData.getPictureValue());

        elementHelper.fillLocator(PracticeFormLocators.addressElement, testData.getAddressValue());
        LoggerUtility.infoLog("The user fills Address with value: " + testData.getAddressValue());

        elementHelper.clickJsLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.stateInputElement, testData.getStateValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user selects States: " + testData.getStateValue());

        elementHelper.clickJsLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.cityInputElement, testData.getCityValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user selects Cities: " + testData.getCityValue());

        elementHelper.clickJsLocator(PracticeFormLocators.submitElement);
    }

    public void validateEntireContent(PracticeFormModel testData) {
        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, testData.getExpectedMessage());
        LoggerUtility.infoLog("The user validate the presence of the Thank you message");

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() + ' ' + testData.getLastNameValue());
        LoggerUtility.infoLog("The user validate the presence of First Name: "+ testData.getFirstNameValue() + " and the Last Name: "+ testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());
        LoggerUtility.infoLog("The user validates the presence of the Email: " + testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());
        LoggerUtility.infoLog("The user validates the presence of the Gender: " + testData.getGenderValue());


        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileValue());
        LoggerUtility.infoLog("The user validates the presence of the Mobile: " + testData.getMobileValue());


        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);
        LoggerUtility.infoLog("The user validates the presence of the Subjects: " + testData.getSubjectValues());


        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbiesValues());
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);
        LoggerUtility.infoLog("The user validates the presence of the Hobbies: " + testData.getHobbiesValues());


        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(testData.getPictureValue());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);
        LoggerUtility.infoLog("The user validates the presence of the Picture uploaded: " + testData.getPictureValue());


        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), testData.getAddressValue());
        LoggerUtility.infoLog("The user validates the presence of the Address: " + testData.getAddressValue());


        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getStateValue() + ' ' + testData.getCityValue());
        LoggerUtility.infoLog("The user validates the presence of the States: " + testData.getStateValue() + " and Cities " + testData.getCityValue());

    }
}
