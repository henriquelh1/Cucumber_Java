$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into account",
  "description": "",
  "id": "login-into-account",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10331057100,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Log into account with correct credentials",
  "description": "",
  "id": "login-into-account;log-into-account-with-correct-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user navigates on website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User clicks on the login button on homepage",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters a valid username",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User enters a valid password",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks on the login button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should be taken to the successful login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_navigates_to_stackoverflow_website()"
});
formatter.result({
  "duration": 3495540900,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_clicks_on_the_login_button_on_homepage()"
});
formatter.result({
  "duration": 1163098900,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_enters_a_valid_username()"
});
formatter.result({
  "duration": 3222032700,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_enters_a_valid_password()"
});
formatter.result({
  "duration": 133634800,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_clicks_on_the_login_button()"
});
formatter.result({
  "duration": 1389291400,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_should_be_taken_to_the_successful_login_page()"
});
formatter.result({
  "duration": 67299400,
  "status": "passed"
});
formatter.uri("Login2.feature");
formatter.feature({
  "line": 1,
  "name": "Login into Account",
  "description": "",
  "id": "login-into-account",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9740817100,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Log into account with incorrect credentials",
  "description": "",
  "id": "login-into-account;log-into-account-with-incorrect-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user navigates on website2",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User clicks on the login button on homepage2",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters a valid username2",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User enters a valid password2",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks on the login button2",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should not be taken to the successful login page2",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 25
    }
  ],
  "location": "LoginSteps.user_navigates_to_stackoverflow_website(int)"
});
formatter.result({
  "duration": 3408433300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 43
    }
  ],
  "location": "LoginSteps.user_clicks_on_the_login_button_on_homepage(int)"
});
formatter.result({
  "duration": 972395300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 28
    }
  ],
  "location": "LoginSteps.user_enters_a_valid_username(int)"
});
formatter.result({
  "duration": 3183767600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 28
    }
  ],
  "location": "LoginSteps.user_enters_a_valid_password(int)"
});
formatter.result({
  "duration": 130323300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 31
    }
  ],
  "location": "LoginSteps.user_clicks_on_the_login_button(int)"
});
formatter.result({
  "duration": 1140707800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 53
    }
  ],
  "location": "LoginSteps.user_should_be_taken_to_the_successful_login_page(int)"
});
formatter.result({
  "duration": 57528200,
  "status": "passed"
});
});