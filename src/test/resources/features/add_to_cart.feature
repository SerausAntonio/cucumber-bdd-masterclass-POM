# mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main

Feature: Add to Cart
  Rule: Add from Store


    Scenario Outline: Add one quantity to the cart
      Given I am on the store page
      When I add a "<product_name>" to the Cart
      Then I see 1 "<product_name>" in the Cart

      Examples:
        | product_name |
        | Blue Shoes   |
