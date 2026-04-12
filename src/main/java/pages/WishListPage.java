package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WishListPage extends AbsBasePage {

    private final By wishlistContainer = By.cssSelector("div.g-4.row");
    private final By wishlistCards = By.cssSelector("div.g-4.row > div.col");
    private final By wishlistTitles = By.cssSelector(".card-title.h5");
    private final By viewButton = By.cssSelector(".btn.btn-primary");

    public WishListPage(WebDriver driver) {
        super(driver, "wishlists");
    }

    public void waitForPageLoad() {
        waiters.waitForElementToBeVisible(wishlistContainer);
    }

    public List<WebElement> getAllWishlistCards() {
        waiters.waitForElementsToBeVisible(wishlistCards);
        return driver.findElements(wishlistCards);
    }

    public List<String> getAllWishlistTitles() {
        waiters.waitForElementsToBeVisible(wishlistTitles);
        List<WebElement> titleElements = driver.findElements(wishlistTitles);
        return titleElements.stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickViewButtonOnFirstWishlist() {
        List<WebElement> buttons = driver.findElements(viewButton);
        if (!buttons.isEmpty()) {
            waiters.waitForElementToBeClickable(viewButton);
            buttons.get(0).click();
            logger.info("Клик по кнопке 'Просмотр' у первого вишлиста");
        } else {
            throw new RuntimeException("Нет кнопок 'Просмотр' на странице");
        }
    }

    public int getWishlistsCount() {
        return getAllWishlistCards().size();
    }
}