Feature: Apsiyon - Apsis -- User Create

  Background: Apsiyon -- Apsis Login Action
    Given Apsiyon System "testuser@test.com" and "1q2w3e4r" Login

  @Apsiyon @Apsis @UserCreate
  Scenario: Apsiyon - Apsis --- User Create
    Given Apsiyon System User Create
      | Name and Surname      | Enes Aydin                                        |
      | TC No                 | 93614812389                                       |
      | Phone Number 1        | 5340857823                                        |
      | Phone Number 2        | 5428546845                                        |
      | E Mail 1              | enes611998@gmail.com                              |
      | E Mail 2              | enesaydin@testkalite.com                          |
      | Addresses             | Tatlikuyu Mahallesi 1302 Sokak No 4 Gebze/Kocaeli |
      | Vehicle Plate Number  | 41U1824                                           |
      | Job                   | Software Test Engineer                            |
      | Gender                | Men                                               |
      | Opening Balance Entry | false                                             |