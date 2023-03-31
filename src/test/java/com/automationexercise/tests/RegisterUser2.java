package com.automationexercise.tests;

import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utilities.Driver;
import org.junit.Test;

public class RegisterUser2 extends TestBase{
    @Test
    public void registerUser(){
        SignUpLoginPage signUpLoginPage= new SignUpLoginPage();
        signUpLoginPage.signUp();
    }
}
