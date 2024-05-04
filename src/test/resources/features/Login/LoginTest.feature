@LoginFunctionality
  Feature: Login Functionality Test

    @LoginPositive
    Scenario: Login Positive - Successfully Login with valid Credentials
      Given User open browser and navigate to Url
      When User input username with "tomsmith" and password with "SuperSecretPassword!"
      And User click button Login
      Then User successfully Login and direct to HomePage

    @LoginNegative
    Scenario: Login Negative - Failed Login with Invalid Credentials
      Given User open browser and navigate to Url
      When User input username with "johndoe" and password with "WrongPassword!"
      And User click button Login
      Then User failed Login and get error message