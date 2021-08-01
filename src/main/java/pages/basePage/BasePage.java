package pages.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant_Variables.Constants.EXPLICIT_WAIT_TIME_IN_SEC;

public class BasePage {
    public WebDriver driver;
    private By frameForAuth = By.xpath("//iframe[@src=\"https://login-widget.privat24.ua/\"]");
     public BasePage(WebDriver driver){
        this.driver = driver;
     }
     /*
     *Переданный в параметре ЮРЛ будет использован браузером , текущей вкладкой
     */
     public void navigateToNecessaryURL(String URL){
        driver.navigate().to(URL);
     }
     /*
     *Отдаст элемент , как только он станет видим
     */
     public WebElement getElementIfItIsVisible(WebElement element){
         new WebDriverWait(driver,EXPLICIT_WAIT_TIME_IN_SEC).until(ExpectedConditions.visibilityOf(element));
         return element;
     }

    public void isAuthIframePresent(){
        getElementIfItIsVisible(driver.findElement(frameForAuth));

    }
    public void clearAndType(WebElement input, String strForInput){
        input.clear();
        input.sendKeys(strForInput);
    }
    public WebElement findElement(By elementBy){
         return driver.findElement(elementBy);
    }

}
