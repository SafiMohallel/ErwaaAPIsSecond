Feature: Dummy Rest API Functionality Scenarios

  Scenario Outline: Check status for GET All posts Api
    Given GET all posts "<url>"
    Then Response Code "<responseMessage>" is validated

    Examples:
      | url       | responseMessage |
      | /posts    | 200             |


  Scenario Outline:  Check the totla number of posts
   Given GET all posts "<url>"
   Then the total number of posts is "<total>"

    Examples:
      | url      | total |
      | /posts   | 10    |

  Scenario Outline:  Check status for GET single post
   Given GET single post "<url>"
   Then Response Code "<responseMessage>" is validated

    Examples:
      | url                  | responseMessage |
      | /posts/193/comments  | 200             |

   Scenario Outline:  Check email for GET single post
   Given GET single post "<url>"
   Then email is "<email>" is validated

    Examples:
      | url                  | email                            |
      | /posts/193/comments  | gupta_ret_darshwana@hudson.io    |

   Scenario Outline:  Check the responce time for GET single post
   Given GET single post "<url>"
   Then responce time is less than 1000 milliseconds

    Examples:
      | url                  |
      | /posts/193/comments  |



