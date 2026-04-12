package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.AbsPageObject;
import java.time.Duration;

public abstract class AbsBasePage extends AbsPageObject {

    private String path;
    private final String baseUrl = System.getProperty("base.url");
    protected static final Logger logger = LoggerFactory.getLogger(AbsBasePage.class);


    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public void open() {
        driver.get(baseUrl + path);
        logger.info("Открыта страница: {} ", baseUrl + path);
    }

}
