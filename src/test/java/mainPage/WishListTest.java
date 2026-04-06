package mainPage;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class WishListTest extends AbsBaseTest{
    /**
     * Ла ла ла
     */
    @Test
    public void mainPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.open();
        Thread.sleep(2000);
        loginPage.enterCreds();
        Thread.sleep(2000);
//        driver.close();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        Thread.sleep(2000);
        registerPage.enterCreds();
        Thread.sleep(2000);
        loginPage.open();
        Thread.sleep(2000);

    }
}
