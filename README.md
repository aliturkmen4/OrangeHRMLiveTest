# OrangeHRMlive Website Login & Dashboard Tests

## Test Scenarios and Test Cases

  @AllEmpty
  Scenario Outline:Empty username & Empty password
    Given User at home page
    When Click login button
    Then Check "<error>" message about username and "<error>" message about password
    Examples:
    |error     ||error     |
    |Required  ||Required  |

  @FalseLogin
  Scenario Outline: False username & False password
    Given User at home page
    When Write false "<username>" for username field
    When Write false "<password>" for password field
    When Click login button
    Then Check "<error>" message about false username and false password
    Examples:
      |username             ||password         ||error                  |
      |fdsfsdfsdfsdf        ||fdsfsdfdfs       ||Invalid credentials    |

  @CorrectLogin
  Scenario Outline: Correct username & Correct password
    Given User at home page
    When Write correct "<username>" for username field
    When Write correct "<password>" for password field
    When Click login button
    Then Check the url to understand success login
    Examples:
      |username       ||password    |
      |Admin          ||admin123    |

  @ChangeUsername
    Scenario: Change the username and save it
      Given User at home page
      When Write correct "<username>" for username field
      When Write correct "<password>" for password field
      When Click login button
      When Click the My Info area
      When Change the employee name and surname
      When Save the changes
      Then Check the username area
        

## Used Technologies

Selenium WebDriver, Cucumber BDD, TestNG

  
## Demo
![onlinehrm](https://github.com/aliturkmen4/OrangeHRMLiveTest/assets/84051961/98ba4bde-eecf-4a25-9535-c88ea01625ad)
**Yapılan Login Testlerinin Demosu**
