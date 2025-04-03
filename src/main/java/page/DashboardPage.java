package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static util.Logger.logInfo;

@Getter
public class DashboardPage{
    private final SelenideElement dashboardDemo = $x("//a[contains(text(),'DEMO DASHBOARD')]");
    private final SelenideElement launchDashboardName = $x("//*[contains(text(),'Launches duration chart')]");

    @Step("Выбрать 'DashboardDemo'")
    public <T> T clickDemoDashboard(T page){
        Selenide.executeJavaScript("arguments[0].click();", getDashboardDemo());
        logInfo("Выбрать 'DashboardDemo");
        return page;
    }

    @Step("Вернуть значение добавленного виджета")
    public String widgetNameValue() {
        logInfo("Вернуть значение добавленного виджета'");
        return getLaunchDashboardName().getText();
    }
}
