Feature: User Registration
  Scenario: User registration for multiple data sets
    Given User login to application
    When When User enters valid credentials
      | Username | Password | acess |
      | Admin | admin123 | allacess |
      | RestrictedUser | user234 | noaccess |

    Then User registration successful

