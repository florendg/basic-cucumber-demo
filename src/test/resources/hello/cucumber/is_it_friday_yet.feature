Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is "Sunday"
    When I ask whether it is Friday
    Then the answer should be "Nope"

  Scenario:
    Given today is "Friday"
    When I ask whether it is Friday
    Then the answer should be "TGIF"