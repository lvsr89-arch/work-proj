package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends AbsBasePage {

    private final By menuButtonLoc = By.cssSelector("button[type='button']");
    private final By registerLink = By.cssSelector("a.nav-link:nth-child(2)");
    private final By usernameInp = By.cssSelector("input[type='text']");
    private final By emailInp = By.cssSelector("input[type='email']");
    private final By passwordInp = By.cssSelector("input[type='password']");
    private final By registerBtn = By.cssSelector("button[type='submit']");
    private final By errorMessageLoc = By.cssSelector(".alert-danger, .error, [role='alert']");

    public RegisterPage(WebDriver driver) {
        super(driver, "login");
    }

    public RegisterPage clickMenuButton() {
        WebElement menuButton = waiters.waitForElementToBeVisible(menuButtonLoc);
        menuButton.click();
        return this;
    }

    public RegisterPage clickRegisterLink() {
        WebElement register = waiters.waitForElementToBeVisible(registerLink);
        register.click();
        return this;
    }

    public RegisterPage enterUsername(String username) {
        WebElement usernameField = waiters.waitForElementToBeVisible(usernameInp);
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        WebElement emailField = waiters.waitForElementToBeVisible(emailInp);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        WebElement passwordField = waiters.waitForElementToBeVisible(passwordInp);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickRegisterButton() {
        WebElement registerButton = waiters.waitForElementToBeClickable(registerBtn);
        registerButton.click();
        logger.info("Нажата кнопка регистрации");
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessageLoc).isEmpty();
    }

    public String getErrorMessage() {
        WebElement error = waiters.waitForElementToBeVisible(errorMessageLoc);
        return error.getText();
    }
}