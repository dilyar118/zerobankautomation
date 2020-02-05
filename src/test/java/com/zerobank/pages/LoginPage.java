package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }


        @FindBy(id = "signin_button")
        public WebElement signinButton;

        @FindBy(id = "user_login")
        public WebElement userLogin;

        @FindBy(id = "user_password")
        public WebElement userPassword;

        @FindBy(name = "submit")
        public WebElement signIn;

        public void login (String usernameStr, String passwordStr){

        //    signinButton.click();
            userLogin.sendKeys(usernameStr);
            userPassword.sendKeys(passwordStr);
            signIn.click();





    }
}
