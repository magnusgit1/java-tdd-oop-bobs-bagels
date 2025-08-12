| Class     | Method                                     | Scenario                      | Output         |
|-----------|--------------------------------------------|-------------------------------|----------------|
| Member    | boolean addItemFromBasket(Item item)       | If basket is full             | false          |
| Basket    | boolean add(Item item)                     | If space in basket            | true           |
|           |                                            |                               |                |
| Member    | boolean removeItemFromBasket(Item item)    | If item doesn't exist         | false          |
| Basket    | boolean remove(Item item)                  | If item exists                | true           |
|           |                                            |                               |                |
| Basket    | boolean isFull()                           | If basket is full             | true           |
|           |                                            | If basket is not full         | false          |
|           |                                            |                               |                |
| Manager   | boolean changeBasketCapacity(int capacity) | If capacity is the same       | false          |
|           |                                            | If capacity is changed        | true           |
|           |                                            |                               |                |
| Customer  | double totalCostInBasket()                 | If no items in basket         | 0              |
| Basket    | double totalCost()                         | If items in basket            | sum            |
|           |                                            |                               |                |
| Customer  | double getPriceOfBagel(Bagel bagel)        | If bagel doesn't exist        | null           |
| Bagel     | double getPrice()                          | If bagel exists               | price          |
|           |                                            |                               |                |
| Customer  | boolean chooseFilling(Filling filling)     | If filling doesn't exist      | false          |
| Bagel     | boolean addFilling(Filling filling)        | If filling exists             | true           |
|           |                                            |                               |                |
| Customer  | double getPriceOfFilling(Filling filling)  | If filling doesn't exist      | null           |
| Filling   | double getPrice()                          | If filling exists             | price          |
|           |                                            |                               |                |
| Inventory | boolean doesItemExist(Item item)           | If item doesn't exist         | false          |
|           |                                            | If item exists                | true           |
|           |                                            |                               |                |
| Basket    | //updated// double totalCost()             | If no discounts are available | total          |
|           |                                            | If discounts are available    | total-discount |
|           |                                            |                               |                |
| Basket    | double findDiscount()                      | If discount is found          | discount       |
|           |                                            | If no discount is found       | 0.0            |
|           |                                            |                               |                |

