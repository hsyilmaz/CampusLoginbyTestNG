package LoginTest;

import Utilities.SoftWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPositive extends SoftWebDriver { // only XML-RUN

    @Parameters("browser")//yazmasak da calisiyor. Cunku extend ettigimiz class da geciyor.
    @Test(dataProvider = "getData")
        void PositiveScenario(String userName, String passWord){

        //driver.get("https://campus.techno.study");

        POM_Elements pm = new POM_Elements();

        pm.username.sendKeys(userName); pm.password.sendKeys(passWord);

        pm.loginButton.click();

        if(pm.cooky.isDisplayed()) pm.cooky.click();

        Assert.assertTrue(pm.loginSuccess.getText().contains("Merhaba"));
}

    @DataProvider
        public Object[][] getData(){
        Object[][] data = { {"hsyilmaz1979@gmail.com","Hy338"} };
        return data;
    }

}
