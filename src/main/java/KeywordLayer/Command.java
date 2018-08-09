package KeywordLayer;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Command extends BaseClass {

    public static void GetURL(String URL) {
        Long PageLoadTimeOut = Long.parseLong(config.getProperty("PageLoadTimeOut"));
        driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MINUTES);
        driver.get(URL);
    }

    public static void Click(By Element) {
        driver.findElement(Element).click();
    }

    public static void MouseOver(By Element) {
        WebElement element = driver.findElement(Element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void SendKeys(By Element, CharSequence Text) {
        driver.findElement(Element).sendKeys(Text);
    }

    public static void WaitElementToBeClickable(By Element) throws Exception {
        Long WaitTimeOutSeconds = Long.parseLong(config.getProperty("WaitTimeOutSeconds"));
        ThreadSleep1Seconds();
        WebDriverWait wait = new WebDriverWait(driver, WaitTimeOutSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Element)));
    }

    public static void WaitElementVisible(By Element) {
        Long WaitTimeOutSeconds = Long.parseLong(config.getProperty("WaitTimeOutSeconds"));
        WebDriverWait wait = new WebDriverWait(driver, WaitTimeOutSeconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Element)));
    }

    public static void WaitElementNotVisible(By Element) {
        Long WaitTimeOutSeconds = Long.parseLong(config.getProperty("WaitTimeOutSeconds"));
        WebDriverWait wait = new WebDriverWait(driver, WaitTimeOutSeconds);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Element)));
    }

    public static void ThreadSleep1Seconds() throws Exception {
        Thread.sleep(1000);
    }

    public static void PageLoad() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public static void ImplicitlyWait() {
        long ImplicitlyWait = Long.parseLong(config.getProperty("ImplicitlyWait"));
        driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
    }


    public static void ScrollToElement(By element) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

}

