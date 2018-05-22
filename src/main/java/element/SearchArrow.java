package element;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.ExtendedWebElement;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public interface SearchArrow extends ExtendedWebElement<SearchArrow> {

    @Description("Форма поисковой строки")
    @FindBy("//form[contains(@class,'search2')]")
    SearchForm form(String className);

}
