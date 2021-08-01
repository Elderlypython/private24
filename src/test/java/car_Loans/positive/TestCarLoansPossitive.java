package car_Loans.positive;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static constant_Variables.Constants.URLs.URL_For_Car_Leasing;

public class TestCarLoansPossitive extends BaseTest {

    @BeforeAll
    public void goToCarLeasingPage(){
        car_loan.navigateToNecessaryURL(URL_For_Car_Leasing);
    }

    @Test
    public void checkAuthFrameAppearenceInCarLeasingAgreementsWhenHaveNoAutorization(){
        car_loan.clickAgreementsButton().isAuthIframePresent();
    }
    @Test
    public void checkMaksAutoCost(){
        car_loan.dragAndDropMaximizeCarCost();
        Assertions.assertEquals("1500000.000",car_loan.getMaxCarCost());
    }
    @Test
    public void checkMaxPrepaidWithMaxCredit(){
        car_loan.dragAndDropMaximizeCarCost().dragAndDropMaximaizePrepaaid();
        Assertions.assertEquals("1400000.000",car_loan.getMaxCarPrepaid());
    }
    @Test
    public void checkAutorizationWindowAppearenceWhenTryToSubmitCredit(){
        car_loan.typeValidMobileNumber().clickreqestForCreditButton()
                .isAuthIframePresent();
    }
    @Test
    public void checkCreditPageUrlViaReference(){
        car_loan.clickRefToCreditPage();
      Assertions.assertTrue(car_loan.checkNewCreditPageOpened());
    }



}
