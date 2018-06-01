define({ "api": [
  {
    "type": "get",
    "url": "/answers",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/answers"
      }
    ],
    "name": "findAllAnswers",
    "group": "Answer",
    "description": "<p>find all the answers</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Answer[]",
            "optional": false,
            "field": "Answers",
            "description": "<p>the list of answer</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/AnswerController.java",
    "groupTitle": "Answer"
  },
  {
    "type": "get",
    "url": "/answers/pseudo/{pseudo}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/answers/pseudo/titi"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"pseudo\" : [{\"titi\"}, {\"toto\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pseudoAnswerer",
            "description": "<p>The pseudo of the answerer</p>"
          }
        ]
      }
    },
    "name": "findAllAnswersByAnswerer",
    "group": "Answer",
    "description": "<p>find all the answers for an answerer</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Answer[]",
            "optional": false,
            "field": "Answers",
            "description": "<p>the list of answers</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/AnswerController.java",
    "groupTitle": "Answer"
  },
  {
    "type": "get",
    "url": "/answers/questionId/{questionId}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/answers/questionId/1"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"questionId\" : [{\"1\"}, {\"2\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "questionId",
            "description": "<p>The id of the question</p>"
          }
        ]
      }
    },
    "name": "findAllAnswersByQuestionId",
    "group": "Answer",
    "description": "<p>find all the answers for a questionId</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Answer[]",
            "optional": false,
            "field": "Answers",
            "description": "<p>the list of answers</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/AnswerController.java",
    "groupTitle": "Answer"
  },
  {
    "type": "get",
    "url": "/articles/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/articles/"
      }
    ],
    "name": "findAllArticles",
    "group": "Article",
    "description": "<p>find all articles</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Article[]",
            "optional": false,
            "field": "articles",
            "description": "<p>the list of articles</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/ArticleController.java",
    "groupTitle": "Article"
  },
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "./docs/apidoc/main.js",
    "group": "C__Users_Marianna_Projets_ivvq_projet_ivvq_2017_2018_frodel_docs_apidoc_main_js",
    "groupTitle": "C__Users_Marianna_Projets_ivvq_projet_ivvq_2017_2018_frodel_docs_apidoc_main_js",
    "name": ""
  },
  {
    "type": "get",
    "url": "/cities/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/cities/"
      }
    ],
    "name": "findAllCities",
    "group": "City",
    "description": "<p>Find all cities</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "City[]",
            "optional": false,
            "field": "cities",
            "description": "<p>All cities</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CityController.java",
    "groupTitle": "City"
  },
  {
    "type": "get",
    "url": "/city/{name}/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/city/Kyoto"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Kyoto\"}, {\"Tokyo\"}, {\"Galway\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of city</p>"
          }
        ]
      }
    },
    "name": "findCityByName",
    "group": "City",
    "description": "<p>Find a city by its name</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "City",
            "optional": false,
            "field": "city",
            "description": "<p>The city found</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CityController.java",
    "groupTitle": "City"
  },
  {
    "type": "post",
    "url": "/comment/",
    "title": "",
    "name": "addComment",
    "group": "Comment",
    "description": "<p>Add a Comment</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>The content of comment</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idCommentator",
            "description": "<p>The id of the user who created the Comment</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Comment",
            "optional": false,
            "field": "comment",
            "description": "<p>The new Comment</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CommentController.java",
    "groupTitle": "Comment",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/comment/"
      }
    ]
  },
  {
    "type": "get",
    "url": "/comments/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/comments/"
      }
    ],
    "name": "findAllComments",
    "group": "Comment",
    "description": "<p>find all comments</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Comment[]",
            "optional": false,
            "field": "Comments",
            "description": "<p>the list of comments</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CommentController.java",
    "groupTitle": "Comment"
  },
  {
    "type": "get",
    "url": "/comment/id/{idComment}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/comment/id/1"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"idComment\" : [{\"1\"}, {\"2\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Long",
            "optional": false,
            "field": "idComment",
            "description": "<p>The id of searched comment</p>"
          }
        ]
      }
    },
    "name": "findCommentById",
    "group": "Comment",
    "description": "<p>find a comment with a given id</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Comment",
            "optional": false,
            "field": "Comment",
            "description": "<p>the comment</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CommentController.java",
    "groupTitle": "Comment"
  },
  {
    "type": "get",
    "url": "/continents",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/continents/"
      }
    ],
    "name": "findAllContinents",
    "group": "Continent",
    "description": "<p>Find all continents</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Continent[]",
            "optional": false,
            "field": "continents",
            "description": "<p>All continents</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/ContinentController.java",
    "groupTitle": "Continent"
  },
  {
    "type": "get",
    "url": "/countries/{name}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/countries/Asie"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Asie\"}, {\"Europe\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of the continent</p>"
          }
        ]
      }
    },
    "name": "findCountriesOfContinent",
    "group": "Continent",
    "description": "<p>Find countries of a continent</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Country[]",
            "optional": false,
            "field": "countries",
            "description": "<p>All countries of a continent</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/ContinentController.java",
    "groupTitle": "Continent"
  },
  {
    "type": "get",
    "url": "/continent/{name}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/continent/Asie"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Asie\"}, {\"Europe\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of the continent</p>"
          }
        ]
      }
    },
    "name": "getContinent",
    "group": "Continent",
    "description": "<p>Find a continent by its name</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Continent",
            "optional": false,
            "field": "continent",
            "description": "<p>The continent found</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/ContinentController.java",
    "groupTitle": "Continent"
  },
  {
    "type": "get",
    "url": "/countries/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/countries/"
      }
    ],
    "name": "findAllCountries",
    "group": "Country",
    "description": "<p>Find all countries</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Country[]",
            "optional": false,
            "field": "Countries",
            "description": "<p>All countries</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CountryController.java",
    "groupTitle": "Country"
  },
  {
    "type": "get",
    "url": "/cities/{name}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/cities/Japon"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Japon\"}, {\"Irelande\"}, {\"France\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of country</p>"
          }
        ]
      }
    },
    "name": "findCitiesOfCountry",
    "group": "Country",
    "description": "<p>find cities of country</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "City[]",
            "optional": false,
            "field": "cities",
            "description": "<p>Cities found for the country</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CountryController.java",
    "groupTitle": "Country"
  },
  {
    "type": "get",
    "url": "/country/{name}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/country/Japon"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Japon\"}, {\"Irelande\"}, {\"France\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of country to find</p>"
          }
        ]
      }
    },
    "name": "findCountryByName",
    "group": "Country",
    "description": "<p>find a country by its name</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Country",
            "optional": false,
            "field": "country",
            "description": "<p>the country found</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/CountryController.java",
    "groupTitle": "Country"
  },
  {
    "type": "get",
    "url": "/questions",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/questions"
      }
    ],
    "name": "findAllQuestions",
    "group": "Question",
    "description": "<p>find all the questions</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Question[]",
            "optional": false,
            "field": "Questions",
            "description": "<p>the list of questions</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "get",
    "url": "/questions/pseudo/{pseudo}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/questions/pseudo/titi"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"pseudo\" : [{\"titi\"}, {\"toto\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pseudoInterrogator",
            "description": "<p>The name of the interrogator</p>"
          }
        ]
      }
    },
    "name": "findAllQuestionsByInterrogator",
    "group": "Question",
    "description": "<p>find all the questions for an interrogator</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Question[]",
            "optional": false,
            "field": "Questions",
            "description": "<p>the list of questions</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "get",
    "url": "/travel/articles/{idTravel}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/articles/1"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"id\" : [{\"1\"}, {\"2\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Long",
            "optional": false,
            "field": "idTravel",
            "description": "<p>The id of the travel</p>"
          }
        ]
      }
    },
    "name": "findAllArticles",
    "group": "Travel",
    "description": "<p>find all articles of a travel with a given travel id</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Article[]",
            "optional": false,
            "field": "Articles",
            "description": "<p>the list of articles related to the travel</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/TravelController.java",
    "groupTitle": "Travel"
  },
  {
    "type": "get",
    "url": "/travels/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travels/"
      }
    ],
    "name": "findAllTravels",
    "group": "Travel",
    "description": "<p>find all travels</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Travel[]",
            "optional": false,
            "field": "Travels",
            "description": "<p>the list of travels</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/TravelController.java",
    "groupTitle": "Travel"
  },
  {
    "type": "get",
    "url": "/travel/name/{travelName}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/name/Japan"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\" : [{\"Japan\"}, {\"Ireland\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "travelName",
            "description": "<p>The name of searched travel</p>"
          }
        ]
      }
    },
    "name": "findAllTravelsByName",
    "group": "Travel",
    "description": "<p>find all travels with a given name</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Travel[]",
            "optional": false,
            "field": "Travels",
            "description": "<p>the list of travels</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/TravelController.java",
    "groupTitle": "Travel"
  },
  {
    "type": "get",
    "url": "/travel/id/{idTravel}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/id/1"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"id\" : [{\"1\"}, {\"2\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Long",
            "optional": false,
            "field": "idTravel",
            "description": "<p>The id of searched travel</p>"
          }
        ]
      }
    },
    "name": "findTravelById",
    "group": "Travel",
    "description": "<p>find a travel with a given id</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Travel",
            "optional": false,
            "field": "Travel",
            "description": "<p>the travel</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/TravelController.java",
    "groupTitle": "Travel"
  },
  {
    "type": "post",
    "url": "/inscriptions/",
    "title": "",
    "name": "addUser",
    "group": "User",
    "description": "<p>Add an user</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pseudo",
            "description": "<p>The pseudo of new user</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mdp",
            "description": "<p>The password of new user</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>The email of new user</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "User",
            "optional": false,
            "field": "User",
            "description": "<p>The new user</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/inscriptions/"
      }
    ]
  },
  {
    "type": "get",
    "url": "/users/",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/users/"
      }
    ],
    "name": "findAllUsers",
    "group": "User",
    "description": "<p>find all users</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "User[]",
            "optional": false,
            "field": "User",
            "description": "<p>the list of users</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "get",
    "url": "/user/userPseudo/{userPseudo}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/user/userPseudo/toto"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"userPseudo\" : [{\"toto\"}, {\"titi\"}]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "userPseudo",
            "description": "<p>The pseudo of searched user</p>"
          }
        ]
      }
    },
    "name": "findUserByPseudo",
    "group": "User",
    "description": "<p>find user with a given pseudo</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "User",
            "optional": false,
            "field": "User",
            "description": "<p>the user</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  }
] });
