/**
 * 
 */
package com.gojek.server.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gojek.domain.GojekError;
import com.gojek.domain.Location;
import com.gojek.services.LocationService;

/**
 * @author abhineetkumar
 *
 */
@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/drivers/{id}/location", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<?> addAddress(@PathVariable(value = "id") int driverId, @RequestParam(value = "latitude", required = true) double latitude, 
			@RequestParam(value = "longitude", required = true) double longitude, @RequestParam(value = "accuracy", required = true) float accuracy, 
            HttpServletRequest request) throws Exception{
		
		if(driverId < 1 || driverId > 50000){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(90 < latitude || latitude < -90){
			GojekError e = new GojekError(Arrays.asList("Latitude should be between +/- 90"));
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if(180 < longitude || latitude < -180){
			GojekError e = new GojekError(Arrays.asList("Longitude should be between +/- 180"));
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		final Location address = new Location(driverId, latitude, longitude, accuracy);
		locationService.addAddress(address);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
