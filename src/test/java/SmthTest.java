import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SearchPage;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;

public class SmthTest {
    private WebPageFactory factory;
    private WebDriver driver;

    @BeforeTest
    public void initFactory() {
        ChromeDriverManager.getInstance().version("2.38").setup();
        this.driver = new ChromeDriver();
        this.factory = new WebPageFactory();

    }

    @Test
    void test() {
        SearchPage page = factory.get(driver, SearchPage.class);
        page.go();
        page.searchForm().waitUntil(displayed()).input().click();
        page.searchForm().waitUntil(displayed()).input().sendKeys("абракадабра");
        page.searchForm().waitUntil(displayed()).input().click();
    }
}
