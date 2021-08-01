package pages.telecomunications_page_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.basePage.BasePage;

import static constant_Variables.Constants.DataForMobileReplanishment.*;
import static pages.telecomunications_page_Model.MobileLocators.*;

public class MobilePhoneReplanishmentPage extends BasePage {
    public MobilePhoneReplanishmentPage(WebDriver driver) {
        super(driver);
    }
    private final By walletButton = By.xpath("//div[contains(text(),'Мій гаманець')]");
    public By mobileTelephoneInput = By.xpath(mobileTelephoneInputXpath);
    public By amountOfMoneyForMobileInput = By.xpath(amountOfMoneyForMobileInputXpath);
    public By cardNumberInput = By.xpath(cardNumberInputXpath);
    public By cardExpireDateInput = By.xpath(cardExpireDateInputXpath);
    public final By cardCVVInput = By.xpath(cardCVVInputXpath);
    public By cardIssuerFirstNameInput = By.xpath("//input[@data-qa-node=\"firstNamedebitSource\"]");
    public By cardIssuerLastNameInput = By.xpath("//input[@data-qa-node=\"lastNamedebitSource\"]");
    public By submitReplanishmentButton = By.xpath("//button[@data-qa-node=\"submit\"]");
    public By finalTextWhenSubmit = By.xpath("//span[contains(text(),'Поповне111ння телефону. На номер +380686979712')]");
    public By operatorKievStarLabel = By.xpath("//div[@title=\"Київстар\"]");
    public By operatorLifecellLabel = By.xpath("//div[@title=\"Lifecell\"]");
    public By operatorMobLabel = By.xpath("//div[@title=\"3 Mob\"]");
    public By operatorVodafoneLabel = By.xpath("//div[@title=\"Vodafone\"]");
    public By countryCodeChooseButton = By.xpath("//button[@data-qa-node=\"phone-code\"]");
    public By countryCodeChooseInput = By.xpath("//input[@placeholder=\"Пошук\"]");
    public By russiaInSelect = By.xpath("//div[text()=\"Росія\"]");
    public By russianCode = By.xpath("//div[text()=\"+7\"]");
    public By tipElementForMobreplanismentPage = By.xpath("//div[contains(text(),'Поповнюйте мобільний онлайн')]");
    public By tipWhenEmptyField = By.xpath("//div[contains(text(),'Параметр обов')]");
    public By tipWhenLowAmountOfMoney = By.xpath("//div[contains(text(),'Мінімальна сума поповнення 1 UAH')]");
    public By getTipWhenHighAmountOfMoney = By.xpath("//div[contains(text(),'Максимальна сума поповнення 8000 UAH')]");



    public MobilePhoneReplanishmentPage clickWalletButton(){
        driver.findElement(walletButton).click();
        return this;
    }
    public MobilePhoneReplanishmentPage sendKeysToInput(By input, String value){
        driver.findElement(input).sendKeys(value);
        return this;
    }
    public String getAttrFromElement(String xpath,String value){
        return driver.findElement(By.xpath(xpath)).getAttribute(value);
    }
    public MobilePhoneReplanishmentPage sendAllNessesaryInputsForReplanishment(){
        this.sendKeysToInput(mobileTelephoneInput,VALID_PHONE_NUMBER)
                .sendKeysToInput(cardNumberInput,VALID_CARD_NUMBER)
                .sendKeysToInput(cardCVVInput,VALID_CVV)
                .sendKeysToInput(cardExpireDateInput,VALID_ISSUE_DATE)
                .sendKeysToInput(amountOfMoneyForMobileInput,"1")
                .sendKeysToInput(cardIssuerFirstNameInput,VALID_NAME)
                .sendKeysToInput(cardIssuerLastNameInput,VALID_SURNAME);
        return this;
    }
}
