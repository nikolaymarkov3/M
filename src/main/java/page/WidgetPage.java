package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static util.Logger.logInfo;

@Getter
public class WidgetPage {
    private final SelenideElement widgetRadio = $x("//*[contains(text(),'Launches duration chart')]");
    private final SelenideElement btnNextStep = $x("//*[contains(text(),'Next step')]");
    private final SelenideElement inputRadioFilter = $x("//*[contains(@class,'filterName__name--B4z4P')]");
    private final SelenideElement addNewWidget = $x("//*[contains(text(),'Add new widget')]");
    private final SelenideElement bigBtn = $x("//*[contains(@class,'bigButton__big-button')]");

    @Step("Выбрать виджет")
    public <T> T clickWidgetRadio(T page) {
        logInfo("Выбрать виджет");
        getWidgetRadio().click();
        return page;
    }

    @Step("Выбрать 'Next step'")
    public <T> T clickBtnNextStep(T page) {
        logInfo("Выбрать 'Next step'");
        getBtnNextStep().click();
        return page;
    }

    @Step("Выбрать 'Filter'")
    public <T> T clickInputRadioFilter(T page) {
        Selenide.executeJavaScript("arguments[0].click();", getInputRadioFilter());
        logInfo("Выбрать 'Filter");
        return page;
    }

    @Step("Выбрать 'Widget'")
    public <T> T clickAddNewWidget(T page) {
        Selenide.executeJavaScript("arguments[0].click();", getAddNewWidget());
        logInfo("Выбрать 'Widget");
        return page;
    }

    @Step("Выбрать 'Add'")
    public <T> T clickBigBtn(T page){
        getBigBtn().click();
        logInfo("Выбрать 'Add'");
        return page;
    }
}
