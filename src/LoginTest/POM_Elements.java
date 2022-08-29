package LoginTest;

import Utilities.SoftWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Elements{
    public POM_Elements() {
        PageFactory.initElements(SoftWebDriver.driver, this);
    }

        @FindBy(xpath = "//button[text()='Accept all cookies']")
        public WebElement cooky;

        @FindBy(css = "[data-placeholder='Kullanıcı Adı']")
        public WebElement username;

        @FindBy(css = "[data-placeholder='Parola']")
        public WebElement password;

        @FindBy(xpath = "//span[text()=' GİRİŞ YAP ']")
        public WebElement loginButton;


        @FindBy(xpath = "//div[contains(text(),'Invalid')]")
        public WebElement loginFailure;

        @FindBy(xpath = "//span[contains(text(),'Merhaba')] ")
        public WebElement loginSuccess;

        @FindBy(css=".mat-button-wrapper img")
        public WebElement preSign_out;

        @FindBy(xpath = "//span[contains(text(),'Oturumu Kapat')]")
        public WebElement sign_out;


}
