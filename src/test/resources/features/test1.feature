Feature: Test Apple Products

  Scenario Outline: Post Request for Apple Mac
    Given product details
      | name  | <name>  |
      | year  | <year>  |
      | price | <price> |
      | cpu   | <cpu>   |
      | disk  | <disk>  |
    When post the details to "base.url"
    Then validate the response

    Examples:
      | name                 | year | price   | cpu            | disk  |
      | Apple MacBook Pro 16 | 2019 | 1849.99 | Intel Core i9  | 1 TB  |
      | Apple MacBook Air    | 2020 | 999.99  | Intel Core i5  | 512GB |


