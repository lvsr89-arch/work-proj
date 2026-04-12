package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbsBasePage {

    @FindBy(css = "input[type='text']")
    private WebElement usernameInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".navbar-brand")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        super(driver, "login");
    }

    public void checkFormsLogin() {
        waiters.waitForElement(ExpectedConditions.visibilityOf(logo));
        usernameInput.isDisplayed();
        passwordInput.isDisplayed();
        loginButton.isDisplayed();
        logger.info("Проверил поля на странице");
    }

    public void login(String username, String password) {
        open();
        waiters.waitForElement(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}