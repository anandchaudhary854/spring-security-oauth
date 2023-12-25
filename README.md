# This repo will be used to understand spring Authorization server:

# 23 Dec 2023 update

1. For now this is a very basic setup in application.yml of auth server.
2. Auth server generates a jwt token which can be found by hitting /oauth2/token endpoint.
3. Then we can specify the issues URI which will be the localhost: and the port auth server is running on.
4. Now take the token from auth server and use it to hit the resource server by providing auth token in header and token type will be Bearer.

# 24-25 dec 2023 update:
1. Added oauth client server with spring cloud gateway to redirect any unauthenticated request to auth server.
2. Auth server will redirect to login screen and after login you will be asked for consent.
3. After authentication you will be redirected to resource server path.




![alt text](https://github.com/anandchaudhary854/spring-security-oauth/blob/main/authCodeFlow.png)