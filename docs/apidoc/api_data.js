define({ "api": [
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/ArticleController.java",
    "groupTitle": "Article"
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CityController.java",
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CommentController.java",
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
            "field": "the",
            "description": "<p>list of comments</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CommentController.java",
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
            "field": "the",
            "description": "<p>comment</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CommentController.java",
    "groupTitle": "Comment"
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CountryController.java",
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/CountryController.java",
    "groupTitle": "Country"
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
            "field": "the",
            "description": "<p>list of articles related to the travel</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/TravelController.java",
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
            "field": "the",
            "description": "<p>list of travels</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/TravelController.java",
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
            "field": "the",
            "description": "<p>list of travels</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/TravelController.java",
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
            "field": "the",
            "description": "<p>travel</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/TravelController.java",
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
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/UserController.java",
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
            "field": "the",
            "description": "<p>list of users</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "get",
    "url": "/user/pseudo/{userPseudo}",
    "title": "",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/user/pseudo/toto"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"pseudo\" : [{\"toto\"}, {\"titi\"}]\n}",
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
            "field": "the",
            "description": "<p>user</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  }
] });
