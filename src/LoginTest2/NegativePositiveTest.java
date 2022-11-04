package LoginTest2;

import Utilities.GeneralWebDriver;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativePositiveTest extends GeneralWebDriver {


        @Test(dataProvider = "getDataNegative",priority = 1)
        void NegativeScenario (String userName, String passWord){

           driver.get("https://campus.techno.study");// GeneralWebDriver BeforeClass da var ama data provider 3 ciftin sadece ilkini gonderebildi.
            POM_Elements pm = new POM_Elements();

            pm.username.sendKeys(userName);
            pm.password.sendKeys(passWord);

            if (pm.cooky.isDisplayed()) pm.cooky.click();
            pm.loginButton.click();

            wait.until(ExpectedConditions.visibilityOf(pm.loginFailure));
            Assert.assertTrue(pm.loginFailure.getText().contains("Invalid"));
        }

        @Test(dataProvider = "getDataPositive",priority = 2)
        void PositiveScenario (String userName, String passWord){

            driver.get("https://campus.techno.study");
            POM_Elements pm = new POM_Elements();

            pm.username.sendKeys(userName);
            pm.password.sendKeys(passWord);

            pm.loginButton.click();
            if (pm.cooky.isDisplayed()) pm.cooky.click();

            Assert.assertTrue(pm.loginSuccess.getText().contains("Merhaba"));

        }

        @DataProvider
        public Object[][] getDataNegative() {
            Object[][] data = {
                    {"hsy@gmail", "Hy338"},
                    {"hsyilmaz1979@gmail.com", "hy338"},
                    {"hs@gmail.com", "HY338"}
            };
            return data;
        }
        @DataProvider
        public Object[][] getDataPositive() {
            Object[][] data = {{"hsyilmaz1979@gmail.com","Hy338"}};
            return data;
        }
    }


