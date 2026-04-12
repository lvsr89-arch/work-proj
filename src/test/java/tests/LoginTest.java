package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends AbsBaseTest {

    @Test
    public void loginPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.checkFormsLogin();
    }
}
