package pages.car_Loans_Page_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.basePage.BasePage;

import java.util.Set;

import static constant_Variables.Constants.DataForMobileReplanishment.VALID_PHONE_NUMBER;
import static pages.car_Loans_Page_Model.CarLoanLocators.*;

public class Car_Loan_Page extends BasePage {
    public WebDriver driver;


    public Car_Loan_Page(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    Actions action = null;

    By agreementsButton = By.xpath(agreementsButtonXpath);
    By moneyCangeButton = By.xpath(carCostButtonXpath);
    By percentInfoText = By.xpath(percentInfoTextXpath);
    By carCostInput = By.xpath(carCostInputXpath);
    By carPrepaidButton = By.xpath(carPrepaidButtonXpath);
    By carPrepaidInput = By.xpath(carPrepaidInputXpath);
    By telephoneInput = By.xpath(telephoneInputXpath);
    By entranceButton = By.xpath(entranceButtonXpath);
    By reqestForCreditButton = By.xpath(requestForCreditButtonXpath);
    By passwordFieldInput = By.xpath(passwordFieldInputXpath);
    By refToCreditPage = By.xpath(refToCreditPageXpath);
    By warningText = By.xpath(warningTextXpath);
    public WebElement findWebElemend(By by){
        return driver.findElement(by);

    }

    public Car_Loan_Page clickAgreementsButton(){
        driver.findElement(agreementsButton).click();
        return this;
    }
    public Car_Loan_Page dragAndDropMaximizeCarCost(){
        action = new Actions(driver);
        action.dragAndDrop(findWebElemend(moneyCangeButton),findElement(percentInfoText))
                .build().perform();
        return this;
    }
    public String getMaxCarCost(){
        return this.findWebElemend(carCostInput).getAttribute("value");
    }

    public void dragAndDropMaximaizePrepaaid(){
        action = new Actions(driver);
        action.dragAndDrop(findWebElemend(carPrepaidButton),findElement(percentInfoText))
                .build().perform();
    }
    public String getMaxCarPrepaid(){
        return this.findWebElemend(carPrepaidInput).getAttribute("value");
    }
    public Car_Loan_Page typeValidMobileNumber(){
        this.findWebElemend(telephoneInput).sendKeys(VALID_PHONE_NUMBER);
        return this;
    }
    public Car_Loan_Page clickreqestForCreditButton(){
        this.findWebElemend(reqestForCreditButton).click();
        return this;
    }
    public Car_Loan_Page typePassword(){
        this.findWebElemend(passwordFieldInput).sendKeys("12323");
        return this;
    }

    public Car_Loan_Page findEntranceButton(){
        this.findWebElemend(entranceButton);
        return  this;
    }
    public Car_Loan_Page clickRefToCreditPage(){
        findWebElemend(refToCreditPage).click();
        return this;
    }
    public boolean checkNewCreditPageOpened(){
        Set<String> allWindows = this.driver.getWindowHandles();
        for (String i:allWindows) {
            String currentUrl = this.driver.switchTo().window(i).getCurrentUrl();
            if(currentUrl.equalsIgnoreCase("https://privatbank.ua/kredity/avto-v-kredit")){
                return true;
            }
        }
        return false;
    }
    public Car_Loan_Page sendKeysToInput(By input, String value){
        driver.findElement(input).click();
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        driver.findElement(input).sendKeys(selectAll);
        driver.findElement(input).sendKeys(Keys.DELETE);
        driver.findElement(input).sendKeys(value);
        return this;
    }
    public boolean checkElemIsDiabled(){
        return this.findWebElemend(reqestForCreditButton).isEnabled();
    }

    public void checkWarningText(){
        driver.findElement(warningText).isDisplayed();
    }

}
