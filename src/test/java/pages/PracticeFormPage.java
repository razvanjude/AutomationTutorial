package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagelocators.PracticeFormLocators;

import java.io.File;
import java.util.List;
public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(String firstNameValue, String lastNameValue,
                                   String emailValue, String genderValue,
                                   String mobileValue, List<String> subjectValues,
                                   List<String> hobbiesValues, String pictureValue,
                                   String addressValue, String stateValue, String cityValue) {
        elementHelper.fillLocator(PracticeFormLocators.firstnameElement, firstNameValue);

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, lastNameValue);

        elementHelper.fillLocator(PracticeFormLocators.emailElement, emailValue);

        List<WebElement> genderElement = elementHelper.getListElements(PracticeFormLocators.genderLocator);
        switch (genderValue) {
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

        elementHelper.fillLocator(PracticeFormLocators.mobileNumber, mobileValue);

        for (String subject : subjectValues) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (hobbiesValues.contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
            }
        }

        File file = new File(pictureValue);
        elementHelper.fillLocator(PracticeFormLocators.pictureElement, file.getAbsolutePath());

        elementHelper.fillLocator(PracticeFormLocators.addressElement, addressValue);

        elementHelper.clickJsLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.stateInput, stateValue, Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.cityInput, cityValue, Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.submitButton);
    }

    public void validateEntireContent(String expectedMessage, String firstNameValue, String lastNameValue,
                                      String emailValue, String genderValue,
                                      String mobileValue, List<String> subjectValues,
                                      List<String> hobbiesValues, String uploadFile,
                                      String addressValue, String stateValue, String cityValue) {
        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, expectedMessage);

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), firstNameValue + ' ' + lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), genderValue);

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), mobileValue);

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", hobbiesValues);
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(uploadFile);
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), addressValue);

        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), stateValue + ' ' + cityValue);
    }
}
