package junkTests;


import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestThird {
    WebDriver driver = new ChromeDriver();

    //@Test
    public void testOfExpCondition(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.youtube.com/");
        driver.findElement(By.id("search")).sendKeys("Кама Пуля лучшее");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        driver.findElement
                (By.xpath("//yt-formatted-string[contains(@aria-label," +
                        "'Кама Пуля лучшее Автор: Видеоархив Сергея Памфилова')]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        Boolean boo = webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By
                .xpath("//div[@id='container']/ytd-badge-supported-renderer" +
                        "[@class='style-scope ytd-video-primary-info-renderer']"))));
        Assert.check(boo);


    }

}
