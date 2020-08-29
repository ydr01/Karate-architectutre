Feature: User creation post api call 

Background:
	* configure headers = read('classpath:websCommonHeaders.js')
  * def userRequest = read('classpath:requestJson/userRequest.json')
@user-create  
Scenario: Create User
  Given url userPostUrl
  And request userRequest
  When method post
  Then status 201
  And def userResponseHeader = responseHeaders
  And def userResponseBody = response
  
  * match userResponseBody == '#present'