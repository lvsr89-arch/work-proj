package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.WishListPage;

public class WishListPageTest extends AbsBaseTest {

    @Test
    public void wishListPageShouldBeAccessibleAfterLogin() throws InterruptedException {
        login();
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.waitForPageLoad();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("wishlists"),
                "Ожидался редирект на /wishlists");

        int count = wishListPage.getWishlistsCount();
        logger.info("Найдено вишлистов: {}", count);

        var titles = wishListPage.getAllWishlistTitles();
        logger.info("Названия вишлистов: {}", titles);

        Assertions.assertFalse(titles.isEmpty(), "Список вишлистов не должен быть пустым");

        wishListPage.createNewWishList();
        wishListPage.clickViewButtonOnFirstWishlist();
        wishListPage.addNewGift();

        Thread.sleep(10000);
    }
}