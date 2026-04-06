package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Waiters;

public class LoginPage extends AbsBasePage {

    /** Локаторы     */

    private final By usernameLoc = By.cssSelector("input[type='text']");
    private final By passwordLoc = By.cssSelector("input[type='password']");
    private final By loginButtonLoc = By.cssSelector("button[type='submit']");
    private final By alertLoc = By.cssSelector("input[type='text']");
    private final By alertLo2c = By.className("navbar-brand");


    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver, "/login");
        waiters.waitForElementPresent(usernameLoc);
        logger.info("Открываю страницу");
    }

    public void enterCreds() {
        logger.info("Я открылся");
    }

    public void checkEnterButton() {
        logger.info("Проверяю кнопку");
    }

    public void login(){
        }
}
