package com.facebook.qa.test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SignUpPageTest extends TestBase {
    SignUpPage signUpPage;
    LoginPage loginPage;
    LoginPage homePage;
    public SignUpPageTest() throws FileNotFoundException {
        super();
    }
    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        homePage= new LoginPage();
    }
    @Test(priority = 1)
    public void signUpPageTitleTest() {
        String title = signUpPage.ValidateSignUpPageTittle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }
    @Test(priority = 2)
    public void SignUpTest() {
        signUpPage.signUp(prop.getProperty("firstname"), prop.getProperty("lastname"),
                prop.getProperty("email1"), prop.getProperty("verifyEmail"), prop.getProperty("password"),
                prop.getProperty("birthDay"), prop.getProperty("birthMonth"), prop.getProperty("birthYear"),
                prop.getProperty("gender"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}