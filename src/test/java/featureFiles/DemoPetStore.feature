Feature: Demo pet Validations
	
Scenario: Find PetByStatus
	Given FindPetByStatus payload with status "available"
	When User Calls "GetPetByStatusAPI" with "GET" HTTP request
	Then the API call is successful with status code 200
	And User verifies the status of first "10" pets to be "available"
	
Scenario: Add Pet To Store
	Given Add Pet Payload with "Fluffy" , "available"
	When User Calls "AddPetAPI" with "POST" HTTP request
	Then the API call is successful with status code 200
	And "name" in the Response body is "Fluffy"
	
Scenario: Update Status of Pet
	Given Update Pet Payload of "Fluffy" to "sold"
	When User Calls "AddPetAPI" with "PUT" HTTP request
	Then the API call is successful with status code 200
	And "status" in the Response body is "sold"

Scenario: Delete the Pet and verify
	Given Delete Pet Payload
	When User Calls "DeletePetAPI" with "DELETE" HTTP request
	Then the API call is successful with status code 200
	And FindPetByID payload with petID
	When User Calls "GetPetByIDAPI" with "GET" HTTP request
	Then the API call is successful with status code 404
	And "message" in the Response body is "Pet not found"
	
	