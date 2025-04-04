package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static util.Logger.logInfo;

@Getter
public class StartPage {
    private final SelenideElement buttonLogin = $x("//button[@type='submit']");

    @Step("Кликнуть по кнопке 'Login'")
    public <P> P clickButtonLogin(P page) {
        logInfo("Кликнуть по кнопке 'Login'");
        getButtonLogin().click();
        return page;
    }
}
