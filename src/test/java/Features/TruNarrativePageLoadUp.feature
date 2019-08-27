Feature: TruNarrative Web Page Load up
  This features is based on page load up via google search.

  Scenario: Go on to google.com and search TruNarrative.
    Given I navigate to google homepage
    When I enter key term "TruNarrative" in the google search box
    Then I should see TruNarrative website as the first result
    And points to the TruNarrative website link "https://trunarrative.com/"

  Scenario: Use the web page link in the previous scenario to confirm TruNarrative web page load up.
    Given I navigate to the TruNarrative web page
    Then I should see the TrueNarrative strap line "Easy Onboarding.  Smooth Transactions.  Insightful Compliance."

  Scenario: Navigate to the TruNarrative team page and confirm there are three members having correct details.
    Given I am on the TruNarrative homepage
    When I navigate to the TruNarrative Team page
    Then I should see "John Lord" as "Founder and CEO"
    And I should see "Nicola Janney" as "Human Resources Manager"
    And I should see "David Eastaugh" as "CTO"

  Scenario: Whilst on the TruNarrative team page confirm there are eight members in the leadership team shown on page.
    Given that I am on the TruNarrative team page
    Then I should see eight members of leadership team

