package tests;

import org.junit.jupiter.api.Test;
import pages.RegisterPage;

public class RegisterPageTest extends AbsBaseTest {

    @Test
    public void registerNegativeTestWithCyrillicUsername() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickRegisterLink();
        registerPage.enterUsername("ЛаЛа");
        registerPage.enterEmail("test@mail.ru");
        registerPage.enterPassword("securepassword123");
        registerPage.clickRegisterButton();

        // Проверяем, что появилось сообщение об ошибке
        org.junit.jupiter.api.Assertions.assertTrue(
                registerPage.isErrorMessageDisplayed(),
                "Должно быть сообщение об ошибке при регистрации с кириллицей в имени"
        );
        logger.info("Негативный сценарий с кириллицей отработал");
    }
}