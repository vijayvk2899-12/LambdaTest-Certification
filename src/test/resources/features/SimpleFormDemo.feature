Feature: Simple Form Demo Validation

  Scenario: Validate message display on Simple Form Demo page
    Given I open the LambdaTest Selenium Playground
    When I click on "Simple Form Demo"
    Then the URL should contain "simple-form-demo"
    And I enter the message "Welcome to LambdaTest"
    And I click the "Get Checked Value" button
    Then I should see the same message displayed
