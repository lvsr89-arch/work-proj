package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Waiters {

    private WebDriver driver;
    private final Duration defaultDuration;
    private final Duration longDuration;

    public Waiters(WebDriver driver) {
        this.driver = driver;
        this.defaultDuration = Duration.ofSeconds(5);
        this.longDuration = Duration.ofSeconds(10);
    }

    public WebElement waitForElement(ExpectedCondition<WebElement> condition) {
        return new WebDriverWait(driver, longDuration).until(condition);
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(driver, defaultDuration)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(driver, defaultDuration)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> waitForElementsToBeVisible(By locator) {
        return new WebDriverWait(driver, defaultDuration)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}