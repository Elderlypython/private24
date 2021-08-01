package junkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestFirst {

    WebDriver driver = new ChromeDriver();

    //@Test
    public void openMainPage() throws InterruptedException {


        try {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            driver.get("https://ru.iherb.com/");
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
            driver.getWindowHandle();
            driver.findElement(By.id("truste-consent-button")).click();
            driver.findElement(By.id("txtSearch")).sendKeys("Слава Украине !");
            driver.findElement(By.id("searchBtn")).click();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }


    }

}
