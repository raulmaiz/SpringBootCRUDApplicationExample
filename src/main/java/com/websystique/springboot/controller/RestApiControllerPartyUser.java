package com.websystique.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.PartyUser;
import com.websystique.springboot.model.User;
import com.websystique.springboot.service.PartyUserService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiControllerPartyUser {

	public static final Logger logger = LoggerFactory.getLogger(RestApiControllerPartyUser.class);

	@Autowired
	PartyUserService partyUserService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All PartyUsers---------------------------------------------

//	@RequestMapping(value = "/partyUser/getUsersFromParty", method = RequestMethod.GET)
//	public ResponseEntity getUsersFromParty(@RequestParam Map<String,String> requestParams) throws Exception{
//		Long idParty = Long.valueOf(requestParams.get("idParty"));
//		List<User> partyUsers = partyUserService.getUsersFromParty(idParty);
//		if (partyUsers.isEmpty()) {
//			return new ResponseEntity(new CustomErrorType("PartyUsers not found"), HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<PartyUser>>(partyUsers, HttpStatus.OK);
//	}

	// -------------------Retrieve Single PartyUser------------------------------------------


	// -------------------Retrieve All PartyUsers---------------------------------------------

	@RequestMapping(value = "/partyUser/", method = RequestMethod.GET)
	public ResponseEntity<List<PartyUser>> listAllPartyUsers() {
		List<PartyUser> partyUsers = partyUserService.findAllPartyUsers();
		if (partyUsers.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("PartyUsers not found"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PartyUser>>(partyUsers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/partyUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPartyUser(@PathVariable("id") long id) {
		logger.info("Fetching PartyUser with id {}", id);
		PartyUser partyUser = partyUserService.findById(id);
		if (partyUser == null) {
			logger.error("PartyUser with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("PartyUser with id " + id 
					+ " not found"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PartyUser>(partyUser, HttpStatus.OK);
	}

	// -------------------Create a PartyUser-------------------------------------------

	@RequestMapping(value = "/partyUser/createPartyUser", method = RequestMethod.POST)
	public ResponseEntity<?> createPartyUser(@RequestBody PartyUser partyUser, UriComponentsBuilder ucBuilder) {
		logger.info("Creating PartyUser : {}", partyUser);

		partyUserService.savePartyUser(partyUser);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/partyUser/{id}").buildAndExpand(partyUser.getId()).toUri());
		return new ResponseEntity(partyUser, HttpStatus.CREATED);
	}

	// ------------------- Update a PartyUser ------------------------------------------------

	@RequestMapping(value = "/partyUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePartyUser(@PathVariable("id") long id, @RequestBody PartyUser partyUser) {
		logger.info("Updating PartyUser with id {}", id);

		PartyUser currentPartyUser = partyUserService.findById(id);

		if (currentPartyUser == null) {
			logger.error("Unable to update. PartyUser with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. PartyUser with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentPartyUser.setAdmin(partyUser.isAdmin());
//		currentPartyUser.setIdParty(partyUser.getIdParty());
		currentPartyUser.setIdUser(partyUser.getIdUser());

		partyUserService.updatePartyUser(currentPartyUser);
		return new ResponseEntity<PartyUser>(currentPartyUser, HttpStatus.OK);
	}

	// ------------------- Delete a PartyUser-----------------------------------------

	@RequestMapping(value = "/partyUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePartyUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting PartyUser with id {}", id);

		PartyUser partyUser = partyUserService.findById(id);
		if (partyUser == null) {
			logger.error("Unable to delete. PartyUser with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. PartyUser with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		partyUserService.deletePartyUserById(id);
		return new ResponseEntity<PartyUser>(HttpStatus.NO_CONTENT);
	}

    @RequestMapping("/partyUser/info")
    public String home() {
    	
        return getFile("api/partyUser.html");
    }
    
    private String getFile(String fileName) {

    	StringBuilder result = new StringBuilder("");

    	//Get file from resources folder
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource(fileName).getFile());

    	try (Scanner scanner = new Scanner(file)) {

    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			result.append(line).append("\n");
    		}

    		scanner.close();

    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	return result.toString();

      }
//	// ------------------- Delete All PartyUsers-----------------------------
//
//	@RequestMapping(value = "/partyUser/", method = RequestMethod.DELETE)
//	public ResponseEntity<PartyUser> deleteAllPartyUsers() {
//		logger.info("Deleting All PartyUsers");
//
//		partyUserService.deleteAllPartyUsers();
//		return new ResponseEntity<PartyUser>(HttpStatus.NO_CONTENT);
//	}

}