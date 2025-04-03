package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LaunchesPage;
import page.StartPage;
import page.WidgetPage;
import runner.BaseTest;

public class DashboardWidgetCreationTest extends BaseTest {
    public StartPage startPage = new StartPage();
    public LaunchesPage launchesPage = new LaunchesPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public WidgetPage widgetPage = new WidgetPage();

    @Test
    void creatingNewWidget() {
        String expectResult = "Launches duration chart";

        String actualResult = startPage.clickButtonLogin(launchesPage)
                .clickDashboardsButton(dashboardPage)
                .clickDemoDashboard(widgetPage)
                .clickAddNewWidget(widgetPage)
                .clickWidgetRadio(widgetPage)
                .clickBtnNextStep(widgetPage)
                .clickInputRadioFilter(widgetPage)
                .clickBtnNextStep(widgetPage)
                .clickBigBtn(dashboardPage)
                .widgetNameValue();

        Assert.assertEquals(actualResult, expectResult);
    }
}
