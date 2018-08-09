package LoginPage;

import BasePackage.BaseClass;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

import static KeywordLayer.Command.*;

public class ApsiyonLogin {

    private static By LoginButton = By.cssSelector(".login-button");
    private static By UserLoginButton = By.className("user-login-button");
    private static By Email = By.name("mail");
    private static By Password = By.name("pass");
    private static By PropertyOwnerLoginButton = By.id("loginsubmit");


    @Given("^Apsiyon System \"(.*?)\" and \"(.*?)\" Login$")
    public static void apsiyonLoginAction(String UserNameValue, String PasswordValue) throws Exception {
        GetURL(BaseClass.BaseURL);
        WaitElementToBeClickable(LoginButton);
        MouseOver(LoginButton);
        WaitElementToBeClickable(UserLoginButton);
        Click(UserLoginButton);
        WaitElementVisible(Email);
        SendKeys(Email, UserNameValue);
        SendKeys(Password, PasswordValue);
        Click(PropertyOwnerLoginButton);
    }
}
