import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.htmlelements.WebPageFactory;
import listener.AllureListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SearchPage;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static io.qameta.htmlelements.matcher.HasTextMatcher.hasText;

public class SmthTest {
    private WebPageFactory factory;
    private WebDriver driver;

    @BeforeTest
    public void initFactory() {
        ChromeDriverManager.getInstance().version("2.38").setup();
        this.driver = new ChromeDriver();
        this.factory = new WebPageFactory();
        factory.listener(new AllureListener());

    }

    @Test
    void test() {
        SearchPage page = factory.get(driver, SearchPage.class);
        page.go();
        page.searchForm().waitUntil(displayed()).input().click();
        page.searchForm().waitUntil(displayed()).input().sendKeys("абракадабра");
        page.searchForm().button().should(hasText("Найти"));
        page.searchForm().waitUntil(displayed()).input().click();
    }
}
