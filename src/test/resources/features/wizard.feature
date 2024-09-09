Feature: feature file that tests WizardWorldApi

   Background: user is testing the wizerd-world-api
     Given user wants to access the wizard-world-api

  Scenario: retrieve list of all elixirs and validate response
  Given that user wants to use the Elixir endpoint
  When the user asks for a list of all elixirs
  Then the user receives a list of all elixirs and their ids
  And the user receives a successful http status code
