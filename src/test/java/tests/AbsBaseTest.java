package tests;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

public abstract class AbsBaseTest {

    protected WebDriver driver = null;
    protected static final Logger logger = LoggerFactory.getLogger(AbsBaseTest.class);

    protected static final String username_test = System.getenv("login");
    protected static final String password_test = System.getenv("password");

    @BeforeEach
    public void init() {
        driver = new WebDriverFactory().create();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login() {
        login(username_test, password_test);
    }

    protected void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
}