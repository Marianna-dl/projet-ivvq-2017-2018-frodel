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
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.0 200 OK\n{\n\"request_id\": \"ad506913-a073-4d23-9f95-388d1c1e2c46\",\n\"result\": 0.3606252123151169\n}",
          "type": "js"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "C:/Users/Marianna/Projets/ivvq/projet-ivvq-2017-2018-frodel/src/main/java/com/frodel/controller/ArticleController.java",
    "groupTitle": "Article"
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
    "groupTitle": "Comment",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/comments/"
      }
    ]
  },
  {
    "type": "get",
    "url": "/comment/id/:idComment",
    "title": "",
    "name": "findCommentById",
    "group": "Comment",
    "description": "<p>find a comment with a given id</p>",
    "parameter": {
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
    "groupTitle": "Comment",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/comment/id/:idComment"
      }
    ]
  },
  {
    "type": "get",
    "url": "/travel/articles/:idTravel",
    "title": "",
    "name": "findAllArticles",
    "group": "Travel",
    "description": "<p>find all articles of a travel with a given travel id</p>",
    "parameter": {
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
    "groupTitle": "Travel",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/articles/:idTravel"
      }
    ]
  },
  {
    "type": "get",
    "url": "/travels/",
    "title": "",
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
    "groupTitle": "Travel",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travels/"
      }
    ]
  },
  {
    "type": "get",
    "url": "/travel/name/:travelName",
    "title": "",
    "name": "findAllTravelsByName",
    "group": "Travel",
    "description": "<p>find all travels with a given name</p>",
    "parameter": {
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
    "groupTitle": "Travel",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/name/:travelName"
      }
    ]
  },
  {
    "type": "get",
    "url": "/travel/id/:idTravel",
    "title": "",
    "name": "findTravelById",
    "group": "Travel",
    "description": "<p>find a travel with a given id</p>",
    "parameter": {
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
    "groupTitle": "Travel",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/travel/id/:idTravel"
      }
    ]
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
    "groupTitle": "User",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/users/"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/pseudo/:userPseudo",
    "title": "",
    "name": "findUserByPseudo",
    "group": "User",
    "description": "<p>find user with a given pseudo</p>",
    "parameter": {
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
    "groupTitle": "User",
    "sampleRequest": [
      {
        "url": "https://travex.herokuapp.com/user/pseudo/:userPseudo"
      }
    ]
  }
] });
