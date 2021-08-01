package telecomunication.negative;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static constant_Variables.Constants.DataForMobileReplanishment.VALID_PHONE_NUMBER;
import static constant_Variables.Constants.DataForNegativeReplanishmentTest.TOO_HIGH_SUM;
import static constant_Variables.Constants.DataForNegativeReplanishmentTest.TOO_LOW_SUM;
import static constant_Variables.Constants.URLs.URL_For_mobile;
import static pages.telecomunications_page_Model.MobileLocators.*;

public class TestPhoneReplanishmentNegative extends BaseTest {


    @Test
    void checkImpossibilityPayWitoutCard(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage
                .sendKeysToInput(phoneReplanishmentPage.mobileTelephoneInput,VALID_PHONE_NUMBER);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.mobileTelephoneInput)
                .sendKeys(Keys.ENTER);
       int tipCount =  phoneReplanishmentPage.driver.findElements(phoneReplanishmentPage.tipWhenEmptyField).size();
        Assertions.assertEquals(3,tipCount);
    }
    @Test
    void checkImpossibilityPayLowAmountOfMoney(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage
                .sendKeysToInput(phoneReplanishmentPage.mobileTelephoneInput,VALID_PHONE_NUMBER);
        phoneReplanishmentPage
                .sendKeysToInput(phoneReplanishmentPage.amountOfMoneyForMobileInput,TOO_LOW_SUM);
        phoneReplanishmentPage
                .findElement(phoneReplanishmentPage.amountOfMoneyForMobileInput)
                .sendKeys(Keys.ENTER);
        phoneReplanishmentPage
                .getElementIfItIsVisible(phoneReplanishmentPage
                        .findElement(phoneReplanishmentPage.tipWhenLowAmountOfMoney));
    }
    @Test
    void checkImpossibilityPayHighAmountOfMoney(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage
                .sendKeysToInput(phoneReplanishmentPage.mobileTelephoneInput,VALID_PHONE_NUMBER);
        phoneReplanishmentPage
                .sendKeysToInput(phoneReplanishmentPage.amountOfMoneyForMobileInput,TOO_HIGH_SUM);
        phoneReplanishmentPage
                .findElement(phoneReplanishmentPage.amountOfMoneyForMobileInput)
                .sendKeys(Keys.ENTER);
        phoneReplanishmentPage
                .getElementIfItIsVisible(phoneReplanishmentPage
                        .findElement(phoneReplanishmentPage.getTipWhenHighAmountOfMoney));
    }
    @ParameterizedTest
    @ValueSource(strings = {cardNumberInputXpath
            ,amountOfMoneyForMobileInputXpath,cardExpireDateInputXpath
            ,cardCVVInputXpath,mobileTelephoneInputXpath})
    void checkImpossibilitySendLettersToInputs(String xpath){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        String randomStr = "qwerty@#!";
        phoneReplanishmentPage.sendKeysToInput(By.xpath(xpath),randomStr);
        String valueOfInput = phoneReplanishmentPage.getAttrFromElement(xpath,"value");
        Assertions.assertEquals("",valueOfInput);
    }}

