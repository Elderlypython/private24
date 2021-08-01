package car_Loans.negative;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static constant_Variables.Constants.URLs.URL_For_Car_Leasing;
import static pages.car_Loans_Page_Model.CarLoanLocators.amountInput;
import static pages.car_Loans_Page_Model.CarLoanLocators.prepaidInput;

public class TestCarLoansNegative extends BaseTest {
    @BeforeAll
    public void goToCarLeasingPage(){
        car_loan.navigateToNecessaryURL(URL_For_Car_Leasing);
    }

    @ParameterizedTest
    @ValueSource(strings = {amountInput,prepaidInput})
    public void checkMinusSumImpossibility(String xpath) throws InterruptedException {
    car_loan.sendKeysToInput(By.xpath(xpath),"-10000");
    Assertions.assertFalse(car_loan.checkElemIsDiabled());
    car_loan.navigateToNecessaryURL(URL_For_Car_Leasing);
    Thread.sleep(3000);
    }

    @Test
    public void checkImposibilityOfApplyWithoutMobileNum(){
    car_loan.clickreqestForCreditButton();
    car_loan.checkWarningText();
    }
}
