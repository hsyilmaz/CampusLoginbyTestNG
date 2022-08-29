package LoginTest2;

import Utilities.GeneralWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveTest extends GeneralWebDriver {

    @Test(dataProvider = "getData")
    void PositiveScenario(String userName, String passWord){

        driver.get("https://campus.techno.study");

        POM_Elements pm = new POM_Elements();

        pm.username.sendKeys(userName);
        pm.password.sendKeys(passWord);

        if(pm.cooky.isDisplayed()) pm.cooky.click();

        pm.loginButton.click();

        Assert.assertTrue(pm.loginSuccess.getText().contains("Merhaba"));
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = { {"hsyilmaz1979@gmail.com","Hy338"} };
        return data;
    }

}

