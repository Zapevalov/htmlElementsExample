package element;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface SearchResult extends ExtendedWebElement<HtmlElement> {
    @FindBy("//div[class='title']")
    HtmlElement title();
}
