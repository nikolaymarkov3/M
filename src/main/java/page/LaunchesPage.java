package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static util.Logger.logInfo;

@Getter
public class LaunchesPage {
    private final SelenideElement dashboardsButton = $x("//*[@fill-rule='evenodd']");

    @Step("Выбрать кнопку 'DASHBOARD'")
    public <T> T clickDashboardsButton(T page){
        logInfo("Выбрать кнопку 'DASHBOARD'");
        getDashboardsButton().click();
        return page;
    }
}