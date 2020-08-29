Feature: User creation post api call 

Background:
	* configure headers = read('classpath:websCommonHeaders.js')
@user-get  
Scenario: get User
  Given url userGetUrl
  When method get
  Then status 200
  And def userResponseHeader = responseHeaders
  And def userResponseBody = response
  
  * match userResponseBody == '#present'