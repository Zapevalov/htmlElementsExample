package element;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public interface SearchForm extends ExtendedWebElement<SearchForm> {

    @FindBy("//input[contains(@class,\"input__control input__input\")]")
    HtmlElement input();

    @FindBy("//button[@class='button suggest2-form__button button_theme_websearch button_size_xl i-bem button_js_inited']")
    HtmlElement button();

}
