package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterPage extends AbsBasePage {

    private static final Logger logger = LoggerFactory.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver) {
        super(driver, "/Register");
        logger.info("Открываю страницу");
    }

    public void enterCreds() {
        logger.info("Я открылся");
    }
}
