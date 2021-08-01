package common_Methods;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common_Methods.CommonConfig.WEBDRIVER_VARIANT;
import static constant_Variables.Constants.IMPLICIT_WAIT_TIME_IN_SEC;

public class CommonActions {

    @org.jetbrains.annotations.NotNull
    public static WebDriver createDriver(){
        WebDriver driver = null;

        switch(WEBDRIVER_VARIANT){
            case "CHROME" :
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver =  new ChromeDriver();
                break;
            case "GECKODRIVER" :
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
                driver =  new FirefoxDriver();
            default:
                Assertions.fail("Не вышло подтянуть драйвер !!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_IN_SEC, TimeUnit.SECONDS);
        return driver;
    }


}
