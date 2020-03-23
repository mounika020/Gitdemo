$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/sampleprogram.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mounika sengaran"
    },
    {
      "line": 2,
      "value": "#Feature Scenarios: 1)To verify clientletter login"
    }
  ],
  "line": 5,
  "name": "To verify Export Results Functionality",
  "description": "",
  "id": "to-verify-export-results-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15375282900,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "Login the ELGS UI",
  "keyword": "Given "
});
formatter.match({
  "location": "Elgsui.login_the_ELGS_UI()"
});
formatter.result({
  "duration": 548188200,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Test case is used to verify login funcyinoality.",
  "description": "",
  "id": "to-verify-export-results-functionality;test-case-is-used-to-verify-login-funcyinoality.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Elgs Login Screen should be displayed",
  "keyword": "When "
});
formatter.match({
  "location": "Elgsui.elgs_Login_Screen_should_be_displayed()"
});
formatter.result({
  "duration": 33500,
  "status": "passed"
});
formatter.after({
  "duration": 6787998100,
  "status": "passed"
});
});