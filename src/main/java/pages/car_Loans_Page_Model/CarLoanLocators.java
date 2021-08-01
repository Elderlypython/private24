package pages.car_Loans_Page_Model;

public class CarLoanLocators {
    public static final String carCostButtonXpath = "//input[@type=\"text\"]//following-sibling::div//button";
    public static final String percentInfoTextXpath = "//div[contains(text(),'Ставка за розстрочкою')]";
    public static final String agreementsButtonXpath = "//a[@href=\"/auto-credit/my\"]";
    public static final String carCostInputXpath = "//input[@name=\"amount\"]";
    public static final String carPrepaidButtonXpath = "//input[@name=\"prepaid\"]//following-sibling::div//button";
    public static final String carPrepaidInputXpath = "//input[@name=\"prepaid\"]";
    public static final String telephoneInputXpath = "//input[@data-qa-node=\"phone-number\"]";
    public static final String entranceButtonXpath = "//button[contains(text(),'Увійти')]";
    public static final String requestForCreditButtonXpath = "//button[contains(text(),'Подати заявку')]";
    public static final String passwordFieldInputXpath = "//input[@data-qa-node=\"password\"]";
    public static final String refToCreditPageXpath = "//a[@href=\"https://pb.ua/avto\"]";
    public static final String amountInput ="//input[@data-qa-node=\"amount\"]";
    public static final String prepaidInput ="//input[@data-qa-node=\"prepaid\"]";
    public static final String warningTextXpath = "//div[contains(text(),\"Введено некоректне значення\")]";

}
