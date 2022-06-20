@create
Feature: Create User feature

  Scenario: Create user with name and job
    Given create user endpoint
    When hits create user endPoint with name "morpheus" and job "leader"
    Then expected status code is 201