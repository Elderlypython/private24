package telecomunication.positive;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constant_Variables.Constants.DataForMobileReplanishment.RUSSIA;
import static constant_Variables.Constants.URLs.URL_For_mobile;


public class TestPhoneReplanishmentPositive extends BaseTest {

    @Test
    void checkPresenceOfTipText(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage
                .getElementIfItIsVisible(phoneReplanishmentPage
                        .findElement(phoneReplanishmentPage.tipElementForMobreplanismentPage));
    }
    @Test
    void checkIsRedirectToAuth(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage.clickWalletButton();
        phoneReplanishmentPage.isAuthIframePresent();
    }
    @Test
    void checkUsabilityOfReplanishment(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage.sendAllNessesaryInputsForReplanishment();
        basePage.
                getElementIfItIsVisible(driver.findElement(phoneReplanishmentPage.submitReplanishmentButton))
                .click();
        Assertions.assertTrue(driver.findElement(phoneReplanishmentPage.finalTextWhenSubmit)
                .isDisplayed());
    }
    @Test
    void checkPresenceOfOperatorLabeles(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.operatorKievStarLabel);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.operatorLifecellLabel);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.operatorMobLabel);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.operatorVodafoneLabel);
    }

    @Test
    void checkChangeOfCountryCode(){
        basePage.navigateToNecessaryURL(URL_For_mobile);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.countryCodeChooseButton).click();
        phoneReplanishmentPage.sendKeysToInput(phoneReplanishmentPage.countryCodeChooseInput,RUSSIA);
        phoneReplanishmentPage.findElement(phoneReplanishmentPage.russiaInSelect).click();
        phoneReplanishmentPage
                .getElementIfItIsVisible(phoneReplanishmentPage
                        .findElement(phoneReplanishmentPage.russianCode));
    }

}
