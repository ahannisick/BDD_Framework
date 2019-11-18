$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FacebookLogin.feature");
formatter.feature({
  "line": 2,
  "name": "Facebook",
  "description": "",
  "id": "facebook",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FBTestSuite"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Login Process",
  "description": "",
  "id": "facebook;login-process",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@FacebookLogin"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enters a valid username",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters a valid password",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks the sign in button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user sign in is complete",
  "keyword": "Then "
});
formatter.match({
  "location": "FacebookLogin_Steps.user_is_on_the_login_page()"
});
formatter.result({
  "duration": 38995226839,
  "status": "passed"
});
formatter.match({
  "location": "FacebookLogin_Steps.user_enters_a_valid_username()"
});
formatter.result({
  "duration": 306325906,
  "status": "passed"
});
formatter.match({
  "location": "FacebookLogin_Steps.user_enters_a_valid_password()"
});
formatter.result({
  "duration": 160468824,
  "status": "passed"
});
formatter.match({
  "location": "FacebookLogin_Steps.user_clicks_the_sign_in_button()"
});
formatter.result({
  "duration": 8796470753,
  "status": "passed"
});
formatter.match({
  "location": "FacebookLogin_Steps.user_sign_in_is_complete()"
});
formatter.result({
  "duration": 208299082,
  "status": "passed"
});
});