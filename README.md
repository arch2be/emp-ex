#EMP-EX

###Use cases:
* Fetch user by provided unique login. Data are fetch from open Github's api. If user for provided login exists then application return response with proper calculations.
* Every correct request which return user's info from Github are stores in DB as record which contain (login, requestCount). Request count this is amount of requests for particular login. 

###API:
* GET /users/{login} \
{\
"id": number, \
"login": string, \
"name": string, \
"type": string, \
"avatarUrl": string, \
"createdAt": date as string \
"calculations": decimal number with precision: 2 \
}

###Property to set
* users.api.url - this is url for fetch user by particular login