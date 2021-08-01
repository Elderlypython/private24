package junkTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class TestSecond {
    WebDriver driver = new ChromeDriver();

    @Test
    public void openSeveralPages(){

            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            driver.navigate().to("https://www.google.ru/");

            ((JavascriptExecutor)driver).executeScript("window.open()");
            ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
            System.out.println(tabs);


            driver.switchTo().window(tabs.get(1));
            driver.navigate().to("https://ru.iherb.com/");
            driver.navigate().to("https://youtube.com/");
        driver.navigate().back();

        Cookie authCookie0 = new Cookie(".AuthServer.Cookies","chunks-2");
        Cookie authCookie1 = new Cookie(".iHerbAuth.CookiesC2","ZnuguiA9jcYKqA%2BO7nqVOELgOXTA8WhK645jiUd1pvz83YoSF77D4GiHWHk5LAkU6Z7rON%2BGhNoXG8wgCCECfeAx3kli4Ow3yCM0A%2F6Rg8TNIzAIZz9LMHXMvtljAbS%2FmNcjMAW4S9kxA4LeyCkZx3vjnUy4rV5IWx%2BjgOnbxthCARj222Tt%2B0zDhMP%2FXW5ouZq9iaS5jtxnhJWjAS%2BipdsajbgI1hOK7GC2kGOOlaUsLjNt7VMPWtOPpmgCR36O6fQ%2B2t%2FazF%2FyQgyitsTVibz64d5L%2FNT4whMtHo4LxdifuB%2BG16sNBVG%2FopPlynMAZTkKgoaskG5thCboPBz3F74iEflHUjCXYlPwDnwpSmxXPXEv17ekLiwZ%2Ftgsp4jWFAJ4Bq17Cd3Mx%2FL51NYj287guwVEjPDKWCV51V9zdGEs7oLkFzjXRLLQ7h2tX%2BVmrIS%2BBdtVsCP8QCjprlEgQAzWbjusZhyi6fWeW3P%2FpIU0slEs%2FK5WBBEc%2BYkeyizB411KCD2Vu5mpdqM4RU40SzWh96xSTJSV1VT%2BKmATNvv0ixaxm3WXrr2hcdMW1GJapmhBAV2qxpyNKMMeO5LZKMEwPtzd0SbFDTE9l27%2Bbw6lGA6aRQd3NzqAFOMykTc0kjqvY3TkiBZRkJczTjchvcqeeK0QjpYWewjqB5gV%2BnsjZP%2BAbsTa7HwlXwQtozlcsrHY1cn1s%2FpEIvPql6%2BwrBW7rbT32BDJgeKrec%2FuTNLlqT3SSDOrXN2ucDI5o8vkvBE6%2B0scuqyvlraSPPuylOpChzYUpQD2JGSwR%2B%2FojvVxH3Lp9RajYhFjd4KGDSMsRbNJkimZP4nP5ymOS0fsndQ8hGX4N%2BFB2GDS0bQxTAQ3w40tRjxaIxtXlcMkVrHguD6FAj4IfYlzNpbaRxTpOvO5uL6lYDLmG43VQF12X3f1noxqmbfHOzJwUXaZWuj%2BU277Fsysief9Sk9DXqs%2BwYgM1mmV33tbjHojBc%2FQQJHFYi85EhRt5jgUOJQmFgoBtDM6jvK2Xi80YrnIY1P62fhyJzOFI3uZ92q%2FDTRa40eSyqqiOGabD1SpcCeHHTKY3GKTDwlv5xV8Y0h0UdWs9VBLjd9pE7ixMWxVHTOl2ZD4ulZfkJ4WCyzv2sqQngw5Lmf%2BTbsUg0fHfu6tiRFRyHfwi%2Bw9tHaF%2FPUo5MTt%2BxbZXp7sg8feLa%2FaklRnL2mvq1EmZMa8aGDY8z%2Fn7w1mYQ%3D%3D");
            driver.manage().addCookie(authCookie1);
            driver.manage().addCookie(authCookie0);

       //
            driver.navigate().refresh();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }


        driver.close();
        driver.quit();


    }
}
