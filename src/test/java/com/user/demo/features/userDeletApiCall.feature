Feature: User creation post api call 

Background:
	* configure headers = read('classpath:websCommonHeaders.js')
@user-delete  
Scenario: Delete User
  Given url userDeleteUrl
  When method delete
  Then status 200
  And def userResponseHeader = responseHeaders
  And def userResponseBody = response