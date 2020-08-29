Feature: User creation post api call 

Background:
	* configure headers = read('classpath:websCommonHeaders.js')
  * def userRequest = read('classpath:requestJson/userRequest.json')
  * set userRequest.title = 'Updating thr title' 
@user-put  
Scenario: update User
  Given url userPutUrl
  And request userRequest
  When method put
  Then status 200
  And def userResponseHeader = responseHeaders
  And def userResponseBody = response
  
  * match userResponseBody == '#present'