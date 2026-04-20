package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WishListPage extends AbsBasePage {

    private final Random random = new Random();
    private final By wishlistContainer = By.cssSelector("div.g-4.row");
    private final By wishlistCards = By.cssSelector("div.g-4.row > div.col");
    private final By wishlistTitles = By.cssSelector(".card-title.h5");
    private final By viewButton = By.cssSelector(".card .btn.btn-primary");
    private final By createNewWishlistButton = By.cssSelector("button.btn.btn-primary");
    private final By newWishListInputName = By.cssSelector("div.modal-body input[type='text']");
    private final By newWishListSubmitButton = By.cssSelector("div.modal-body button[type='submit']");
    private final By addGiftButton = By.cssSelector(".btn.btn-primary");
    private final By giftNameInput = By.cssSelector("div.modal-body input[type='text'].form-control");
    private final By giftDescriptionInput = By.cssSelector("textarea.form-control");
    private final By addButtonModal = By.cssSelector("div.modal-body button[type='submit']");
    private final By priceInput = By.cssSelector("div.mb-3 input[type='number']");

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
        List<String> titles = new ArrayList<>();
        for (WebElement element : titleElements) {
            titles.add(element.getText());
        }
        return titles;
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

    public void createNewWishList() {
        WebElement createButton = waiters.waitForElementToBeClickable(createNewWishlistButton);
        createButton.click();
        WebElement wishListInputField = waiters.waitForElementToBeVisible(newWishListInputName);
        wishListInputField.sendKeys("Тест " + random.nextInt(1000));
        WebElement wishListSubmitButton = waiters.waitForElementToBeClickable(newWishListSubmitButton);
        wishListSubmitButton.click();
        logger.info("Создаю новый список");
    }

    public void addNewGift() {
        WebElement addNewGift = waiters.waitForElementToBeVisible(addGiftButton);
        addNewGift.click();
        WebElement addNewGiftInputField = waiters.waitForElementToBeVisible(giftNameInput);
        addNewGiftInputField.sendKeys("Тестовый подарок " + random.nextInt(1000));
        WebElement addNewGiftInputDescriptionField = driver.findElement(giftDescriptionInput);
        addNewGiftInputDescriptionField.sendKeys("Ла ла ла " + random.nextInt(1000));
        WebElement priceInputField = waiters.waitForElementToBeVisible(priceInput);
        priceInputField.clear();
        priceInputField.sendKeys(String.valueOf(random.nextInt(1000)));
        WebElement addButton = waiters.waitForElementToBeClickable(addButtonModal);
        addButton.click();
        logger.info("Подарок добавлен");
    }

    public int getWishlistsCount() {
        return getAllWishlistCards().size();
    }
}