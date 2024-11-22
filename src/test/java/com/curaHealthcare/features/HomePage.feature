Feature: Make an appointment

  Scenario: User successfully fills in the appointment form
    Given the user is on the "Make Appointment" page
    When the user selects "Tokyo CURA Healthcare Center" from the facility dropdown
    And the user selects "Medicare" as the healthcare program
    And the user enters a valid visit date
    And the user writes a comment in the comment box
    Then the user should be able to book the appointment

