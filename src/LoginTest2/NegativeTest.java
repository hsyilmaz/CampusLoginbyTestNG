package LoginTest2;

import Utilities.GeneralWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTest extends GeneralWebDriver {

    @Test(dataProvider = "getData")
    void NegativeScenario(String userName, String passWord) {

        //driver.get("https://campus.techno.study");

        POM_Elements pm = new POM_Elements();

        pm.username.sendKeys(userName);
        pm.password.sendKeys(passWord);

        if (pm.cooky.isDisplayed()) pm.cooky.click();

        pm.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(pm.loginFailure));
        Assert.assertTrue(pm.loginFailure.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = {{"hsy@gmail", "Hy338"}, {"hsyilmaz1979@gmail.com", "hy338"},
                {"hs@gmail.com", "HY338"}};
        return data;
    }
}
