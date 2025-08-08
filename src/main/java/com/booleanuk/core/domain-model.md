| Class     | Method                                     | Scenario                 | Output |
|-----------|--------------------------------------------|--------------------------|--------|
| Member    | boolean addItem(Item item)                 | If basket is full        | false  |
|           |                                            | If space in basket       | true   |
|           |                                            |                          |        |
| Member    | boolean removeItem(Item item)              | If item doesn't exist    | false  |
|           |                                            | If item exists           | true   |
|           |                                            |                          |        |
| Basket    | boolean isFull()                           | If basket is full        | true   |
|           |                                            | If basket is not full    | false  |
|           |                                            |                          |        |
| Manager   | boolean changeBasketCapacity(int capacity) | If capacity is the same  | false  |
|           |                                            | If capacity is changed   | true   |
|           |                                            |                          |        |
| Inventory | boolean doesItemExist(Bagel bagel)         | If item doesn't exist    | false  |
|           |                                            | If item exists           | true   |
|           |                                            |                          |        |
| Customer  | void totalCost()                           | If no items in basket    | 0      |
|           |                                            | If items in basket       | sum    |
|           |                                            |                          |        |
| Customer  | int getPriceOfBagel(Bagel bagel)           | If bagel doesn't exist   | null   |
|           |                                            | If bagel exists          | price  |
|           |                                            |                          |        |
| Customer  | boolean chooseFilling(Filling filling)     | If filling doesn't exist | false  |
|           |                                            | If filling exists        | true   |
|           |                                            |                          |        |
| Customer  | int getPriceOfFilling(Filling filling)     | If filling doesn't exist | null   |
|           |                                            | If filling exists        | price  |
|           |                                            |                          |        |
| Inventory | boolean doesItemExist(Item item)           | If item doesn't exist    | false  |
|           |                                            | If item exists           | true   |

