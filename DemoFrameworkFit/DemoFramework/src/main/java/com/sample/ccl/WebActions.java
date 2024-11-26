package com.sample.ccl;

import com.sample.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebActions {

    public WebElement waitForVisible_MilliSeconds(By locator) throws IllegalAccessException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(500));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void openURL(String URL) throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().get(URL);
        System.out.println("Successfully Entered URL - " + URL);
    }

    public WebDriver.Timeouts implicitWait() throws IllegalAccessException {
        return DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void maximizeWindow() throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().manage().window().maximize();
    }

    public void Click(By locator) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        if (!elm.isSelected()) {
            elm.click();
        }
        elm.click();
        System.out.println("Successfully clicked on " + locator);
    }

    public void sendKeys(By locator, String text) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        elm.sendKeys(text);
        System.out.println("Successfully entered text - " + text);
    }

    public void clear(By locator) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        elm.clear();
        System.out.println("Successfully Cleared text");
    }

    public void clickAndHoldMoveByOffSet(By locator, int xCord, int yCord) throws IllegalAccessException {
        Actions act = new Actions(DriverFactory.getInstance().getDriver());
        WebElement elm = waitForVisible_MilliSeconds(locator);
        act.clickAndHold(elm).moveByOffset(xCord, yCord).perform();
    }

    public void scrollUntilElementIsVisible(By locator) throws IllegalAccessException {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        while (true) {
            // Scroll down the page
            js.executeScript("window.scrollBy(0, window.innerHeight);");
            WebElement elm = waitForVisible_MilliSeconds(locator);
            // Check if the element is visible in the viewport
            if (elm.isDisplayed()) {
                System.out.println("Element is now visible!");
                break;  // Exit the loop when the element is visible
            }

            try {
                // Adding a small delay to prevent overwhelming the browser
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void totalEstimationValidation(By locator, String txt) throws IllegalAccessException {
        WebElement totalEstimate = waitForVisible_MilliSeconds(locator);
        if (totalEstimate.getText().contains(txt)) {
            System.out.println("Validation success");
        } else {
            System.out.println();
        }
    }

    public void navigateToURL(String url) throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().navigate().to(url);
        String currentURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
        System.out.println("Successfully navigated to URL: " + currentURL);
    }

    public void pageRefresh() throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().navigate().refresh();
    }

    public void scroll_up(By element) throws IllegalAccessException {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
