# commons-oauth2
commons-oauth2 library allows OAuth 2.0 based access authorization

## Overview
commons-oauth2 library allows OAuth 2.0 based access authorization. The library is used for Google OAuth2 integration in web applications and internal Increff tools.

## Usage
### pom.xml
To use commons-oauth2, include the following dependency in the project's pom.xml
```xml
<dependency>
    <groupId>com.increff.commons</groupId>
    <artifactId>commons-oauth2</artifactId>
    <version>${increff-commons-oauth2}</version><
</dependency>
```

## Architecture
OAuth allows providing the authorization required by an Application (the Client) to access some Resource on a Resource Server, on behalf of the Resource Owner. The burden of security is on the Resource Server's owner to protect the stored resources. Thus, an Authorization Server (or Auth Server) is generally coupled with the Resource Server.

## OAuth2 flow
![OAuth Flow for gaining authorization](https://one.increff.com/wiki/images/5/59/OAuth2_flow.png)

Note: The application must have the following in their properties file, as they are populated in the redirect attributes:

- oauth2.clientId
- oauth2.clientSecret
- oauth2.redirectUri
- oauth2.appRedirectUri

After the Client has been authorized to access the in Steps 1 and 2 of the flow, a GET request is placed to the following API

`API: GET /oauth2/init`

The request Parameters passed are:`{ hd :"" }`

This clears the current HTTP session and populates the redirect attributes data and places a request to the google OAuth URL as given in Step 3.

This then redirects to

`API GET /oauth2/redirect{ error:"", code:"", scope:""}`

If there is an error then it redirects the application redirect URL else a request form of the format given below along with an authorization token obtained from code is sent to Google's authorization server
```
API POST accessTokenUrl {
  code: "",
  client_id: "",
  client_secret: "",
  grant_type: "",
  redirect_uri: ""
}
```

Google then returns an access token as given in Step 4. The access token is then decoded and the corresponding OAuth2 user details are set in the current HTTP session under the OAuth2User class. After this has been done, the user is authorized for the resource in Step 5. by the Resource Server and is granted access to the resource in Step 6.
## License
Copyright (c) Increff

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing permissions and limitations under
the License.
