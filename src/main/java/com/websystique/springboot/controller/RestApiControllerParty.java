package com.websystique.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.Party;
import com.websystique.springboot.service.PartyService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiControllerParty {

	public static final Logger logger = LoggerFactory.getLogger(RestApiControllerParty.class);

	@Autowired
	PartyService partyService; //Service which will do all data retrieval/manipulation work


	// -------------------Create a Party-------------------------------------------

	@RequestMapping(value = "/party/createParty", method = RequestMethod.POST)
	public ResponseEntity<?> createParty(@RequestBody Party party, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Party : {}", party);

		partyService.saveParty(party);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/party/{id}").buildAndExpand(party.getId()).toUri());
		return new ResponseEntity(party, HttpStatus.CREATED);
	}
	
	// -------------------Retrieve All Gyms---------------------------------------------

	@RequestMapping(value = "/party/", method = RequestMethod.GET)
	public ResponseEntity<List<Party>> listAllPartys() {
		List<Party> partys = partyService.findAllPartys();
		if (partys.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Party>>(partys, HttpStatus.OK);
	}

	// -------------------Retrieve Single Party------------------------------------------

	@RequestMapping(value = "/party/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getParty(@PathVariable("id") long id) {
		logger.info("Fetching Party with id {}", id);
		Party party = partyService.findById(id);
		if (party == null) {
			logger.error("Party with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Party with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Party>(party, HttpStatus.OK);
	}

	// -------------------Create a Party-------------------------------------------

	@RequestMapping(value = "/party/", method = RequestMethod.POST)
	public ResponseEntity<?> createPartyBase(@RequestBody Party party, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Party : {}", party);

		partyService.saveParty(party);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/party/{id}").buildAndExpand(party.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Party ------------------------------------------------

	@RequestMapping(value = "/party/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateParty(@PathVariable("id") long id, @RequestBody Party party) {
		logger.info("Updating Party with id {}", id);

		Party currentParty = partyService.findById(id);

		if (currentParty == null) {
			logger.error("Unable to update. Party with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Party with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentParty.setName(party.getName());
		currentParty.setCapacity(party.getCapacity());
		currentParty.setDuration(party.getDuration());
		currentParty.setLatitude(party.getLatitude());
		currentParty.setLevel(party.getLevel());
		currentParty.setLongitude(party.getLongitude());
		currentParty.setPrice(party.getPrice());
		currentParty.setStarts(party.getStarts());
		currentParty.setStatus(party.getStatus());


		partyService.updateParty(currentParty);
		return new ResponseEntity<Party>(currentParty, HttpStatus.OK);
	}

	// ------------------- Delete a Party-----------------------------------------

	@RequestMapping(value = "/party/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteParty(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Party with id {}", id);

		Party party = partyService.findById(id);
		if (party == null) {
			logger.error("Unable to delete. Party with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Party with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		partyService.deletePartyById(id);
		return new ResponseEntity<Party>(HttpStatus.NO_CONTENT);
	}
	

    @RequestMapping("/party/info")
    public String home() {
    	
        return getFile("api/party.html");
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

	// ------------------- Delete All Partys-----------------------------

//	@RequestMapping(value = "/party/", method = RequestMethod.DELETE)
//	public ResponseEntity<Party> deleteAllPartys() {
//		logger.info("Deleting All Partys");
//
//		partyService.deleteAllPartys();
//		return new ResponseEntity<Party>(HttpStatus.NO_CONTENT);
//	}

}