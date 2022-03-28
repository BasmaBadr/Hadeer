package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    public WebElement Email;
    @FindBy(id = "password-field")
    WebElement Password;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement Loginbutton;
    @FindBy(xpath = "//p[contains(text(),'The selected email is invalid.')]")
    public WebElement errorMessage;
    @FindBy(xpath = "//p[contains(text(),'Password mismatch')]")
    public WebElement errorMessagePassword;
    @FindBy(xpath = "//p[contains(text(),'basma.2222@gmail.com')]")
    public WebElement chechmail;
    @FindBy(xpath = "//li/a[@id='navbardrop']")
    WebElement dropDown;
    @FindBy(xpath = "//a[@href='https://shoppn.io/public/en/affiliate/dashboard/logout']")
    WebElement Logout;
    @FindBy(xpath = "//a[@href='https://shoppn.io/public/en/affiliate/forgot-password']")
    WebElement forgotPassword;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailfogot;
    @FindBy(xpath = "//button[@class='btn btn-filled']")
    WebElement sendbutton;
    @FindBy(name = "confirmation_code")
    WebElement confCode;
    @FindBy(id = "password-field")
    WebElement newPass;
    @FindBy(id = "password-confirmation-field")
    WebElement confPass;
    @FindBy(xpath = "//button[contains(text(),'Change password')]")
    WebElement changePassButton;
    @FindBy(xpath = "//p[contains(text(),'The selected confirmation code is invalid.')]")
   public WebElement erroMessageForCode;



    public void checkLoginButton() {

        if (Loginbutton.isEnabled()) {
            System.out.println("Login Button is enabled");
        } else {
            System.out.println("Login Button is disabled");

        }
    }


        public void loginWithValidUsernameandPassword(String email , String password)
        {
            setTextElmentText(Email, email);
//            setTextElmentText(Email, email);
            setTextElmentText(Password, password);
            clickButton(Loginbutton);
            Email.clear();
            Password.clear();
            setTextElmentText(Email, email);
            setTextElmentText(Password, password);
            clickButton(Loginbutton);

        }
        public void logOut () {
            clickButton(dropDown);
            clickButton(Logout);
        }
        public void forgotPass(){
        forgotPassword.click();

}
        public void sendMail(String emailforgot){
            setTextElmentText(emailfogot, emailforgot);
            clickButton(sendbutton);

}
    public void sendNewPass(String confcode,String newPassw,String confPassw){

        setTextElmentText(confCode,confcode);
        setTextElmentText(newPass,newPassw);
        setTextElmentText(confPass, confPassw);
        clickButton(changePassButton);

    }
//    public void sendNewPassword( String newPassw,String confPassw){
//
//
//        setTextElmentText(newPass,newPassw);
//        setTextElmentText(confPass, confPassw);
//    }
    }

