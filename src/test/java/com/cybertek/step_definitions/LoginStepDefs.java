package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefs {

    LoginPage logObj=new LoginPage();




    @Given("User is on the login page as a user with {string} and {string} credentials")
    public void user_is_on_the_login_page_as_a_user_with_and_credentials(String email, String password) {
        logObj.homepage.click();
        logObj.email.sendKeys(email);
        logObj.pwd.sendKeys(password);
        logObj.loginBtn.click();
    }

    @Given("User is on the login page as a manager with {string} and {string} credentials")
    public void user_is_on_the_login_page_as_a_manager_with_and_credentials(String email, String password) {
        logObj.homepage.click();
        logObj.email.sendKeys(email);
        logObj.pwd.sendKeys(password);
        logObj.loginBtn.click();
    }




    @Then("Navigates to events module")
    public void navigates_to_events_module() {
        BrowserUtils.wait(5);
        logObj.EventsModule.click();
    }
}
