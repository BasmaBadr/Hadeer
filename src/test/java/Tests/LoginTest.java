package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;


    // when the page is initialized, the login button should be disabled
    @Test
    public void checkIfLogginButtonIsDisabled(){
        loginPage = new LoginPage(driver);
        loginPage.checkLoginButton();

    }
    // when the user tries to input invalid data type, the error label under the field appears
    //with an error message, and disappears once the data is valid
    @Test
    public void LoginwithvinalidUsernameandPassword(){
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.Loginbutton.isEnabled());
        loginPage.loginWithValidUsernameandPassword("basma.2@gmail.com","12345678");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        loginPage.loginWithValidUsernameandPassword("basma.2222@gmail.com","1234567899");
        Assert.assertTrue(loginPage.errorMessagePassword.isDisplayed());
        loginPage.loginWithValidUsernameandPassword("basma.2222@gmail.com","12345678");
        Assert.assertTrue(loginPage.chechmail.isDisplayed());
        loginPage.logOut();
    }
    // when the username|email and password is entered correctly, the login button turned
    //to be enabled
    @Test
    public void checkLoginIsEnabled(){
        loginPage = new LoginPage(driver);
        loginPage.loginWithValidUsernameandPassword("basma.2222@gmail.com","12345678");
        Assert.assertTrue(loginPage.Loginbutton.isDisplayed());
    }
    // when data is valid and the user pressed the login button, the user should be redirected
    //to requested page ex. 'user profile'
    @Test
    public void LoginwithvalidUsernameandPassword(){
        loginPage = new LoginPage(driver);
        loginPage.loginWithValidUsernameandPassword("basma.2222@gmail.com","12345678");
        Assert.assertTrue(loginPage.chechmail.isDisplayed());
        loginPage.logOut();
    }
    // in case of invalid password, forget password link should redirect the user to page with
    //an email input field and reset button
    @Test
    public void resetPassword(){
        loginPage = new LoginPage(driver);
        loginPage.forgotPass();
        loginPage.sendMail("basma.2222@gmail.com" );
        loginPage.sendNewPass("123456","12345678","12345678");
        Assert.assertTrue(loginPage.erroMessageForCode.isDisplayed());

    }

}
