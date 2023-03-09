Feature:  check saucedemo login page working fine

Scenario: login https://www.saucedemo.com/

Given Move to saucedemo login page
When enter login credentials
|Username        |Password   |
|standard_user   |secret_sauce |

Then click login button ensure page mooved to dashboard


