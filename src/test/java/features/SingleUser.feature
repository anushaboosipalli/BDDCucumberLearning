#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@user
Feature: Single User feature

  @validId
  Scenario: Call Single User endPoint with valid id
    Given single User endPoint
    When hits single user endPoint with id "3"
    Then response code should be 200
    Then id in the response should be "3"


  @validIds
  Scenario Outline: Call Single User endPoint with valid id
    Given single User endPoint
    When hits single user endPoint with id "<id>"
    Then response code should be 200
    Examples:
      | id |
      | 3  |
      | 4  |
      | 5  |


  @invalidId
  Scenario: Call Single User endPoint with non-existent id
    Given single User endPoint
    When hits single user endPoint with id "a"
    Then response code should be 404
