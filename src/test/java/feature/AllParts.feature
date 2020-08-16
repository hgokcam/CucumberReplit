Feature: Second Homework

  Background: Login
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try to login in by username and password.

  Scenario: Successful the Part1 to complete.
    And I verify "8" items are displayed in the view all orders page
    Then I delete all items in the table
    And I verify item count is "0"

  Scenario: Successful the Part2 to complete.
    When I click on Order
    Then I fill the order form and confirm
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
      | ScreenSaver | 2        | Thomas Edison    | Devorastr. 10   | Koblenz      | Germany | 56400 | MasterCard      | 0987654321 | 01/21    |
      | MyMoney     | 5        | Nicola Tesla     | Am Gulser Weg 1 | Bassenheim   | Germany | 56100 | AmericanExpress | 2138472934 | 01/21    |
    And I click on View All Order button
    Then I verify my orders.
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
      | ScreenSaver | 2        | Thomas Edison    | Devorastr. 10   | Koblenz      | Germany | 56400 | MasterCard      | 0987654321 | 01/21    |
      | MyMoney     | 5        | Nicola Tesla     | Am Gulser Weg 1 | Bassenheim   | Germany | 56100 | AmericanExpress | 2138472934 | 01/21    |


# Verify your order is created in the the view all orders page(Verify Name , Product , Street , City , State , Zip , Card , Card number , Exp )
#
#  Verify items count are increased in the view all orders page
#
#  Create an orders with 3 different product type in the dropdown.