package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FacebookLogin;

public class FacebookLogin_Steps {
    FacebookLogin fblogin = new FacebookLogin();

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        fblogin.fbhomepageFetch();
    }

    @When("^user enters a valid username$")
    public void user_enters_a_valid_username() throws AssertionError, Exception {
        fblogin.fbusernameInput();
    }

    @And("^user enters a valid password$")
    public void user_enters_a_valid_password() throws AssertionError, Exception {
        fblogin.fbpasswordInput();
    }

    @And("^user clicks the sign in button$")
    public void user_clicks_the_sign_in_button() throws Exception {
        fblogin.fbloginBtnClick();
    }

    @Then("^user sign in is complete$")
    public void user_sign_in_is_complete() throws AssertionError, Exception {
        fblogin.fbhomepageLanding();
    }

}
