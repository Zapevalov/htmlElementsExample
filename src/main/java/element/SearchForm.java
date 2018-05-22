package element;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import org.openqa.selenium.WebElement;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public interface SearchForm extends ExtendedWebElement<SearchForm> {

    @FindBy("//input[contains(@class,\"input__control input__input\")]")
    WebElement input();

}
