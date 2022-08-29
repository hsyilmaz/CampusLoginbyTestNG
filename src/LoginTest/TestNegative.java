package LoginTest;

import Utilities.SoftWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNegative extends SoftWebDriver {

    @Parameters("browser")//yazmasak da calisiyor. Cunku extend ettigimiz class da geciyor.
    @Test(dataProvider = "getData")
    void NegativeScenario(String userName, String passWord) {

        driver.get("https://campus.techno.study");

        POM_Elements pm = new POM_Elements();

        pm.username.sendKeys(userName);
        pm.password.sendKeys(passWord);

        if (pm.cooky.isDisplayed()) pm.cooky.click();

        pm.loginButton.click();

        Assert.assertTrue(pm.loginFailure.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = {{"hsy@gmail", "Hy338"}, {"hsyilmaz1979@gmail.com", "hy338"},
                {"hs@gmail.com", "HY338"}};
        return data;
    }

}
