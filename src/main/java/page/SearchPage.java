package page;

import element.SearchArrow;
import element.SearchForm;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.extension.page.BaseUrl;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
@BaseUrl("https://ya.ru/")
public interface SearchPage extends WebPage {

    @Description("Поисковая форма")
    @FindBy("//form[contains(@class,'search2')]")
    SearchForm searchForm();
}
