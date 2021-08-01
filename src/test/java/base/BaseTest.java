package base;

import common_Methods.CommonActions;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.basePage.BasePage;
import pages.car_Loans_Page_Model.Car_Loan_Page;
import pages.telecomunications_page_Model.MobilePhoneReplanishmentPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

import static base.Listener.LOGGER;
import static common_Methods.CommonConfig.*;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected final Car_Loan_Page car_loan = new Car_Loan_Page(driver);
    protected final MobilePhoneReplanishmentPage phoneReplanishmentPage
            = new MobilePhoneReplanishmentPage(driver);

    /*
     * после каждого теста чистим куки
     */
    @AfterEach
    void clearCookiesAndLocalStorage() {
        if(IS_COOKIES_CLEAR){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear()");
        }
    }
    /*
     * после каждого отработки каждого пакета браузер закрывается , при запуске нового - открывается
     */

   @AfterAll
    void close(){
        if(IS_NEED_TO_CLOSE_BROWSER){
        driver.close();
        driver.quit();
        }
    }

    /*
    *удаляет старые отчеты из дирректории и скрины
    */
    {
        LOGGER.info("STARTING TIME : " + LocalDateTime.now());
        LOGGER.info("Start clearing reports : build/reports");
        File allurreResults = new File("allure-results");
        if (allurreResults.isDirectory()){
            for(File item : Objects.requireNonNull(allurreResults.listFiles())){
                item.delete();
            }
        }
        if (CLEAR_OLD_REPORTS){
            File screenshotDirectory = new File("build/reports/tests");
            for(File item : Objects.requireNonNull(screenshotDirectory.listFiles())){
                try {
                    FileUtils.deleteDirectory(item);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }}
    }
}
