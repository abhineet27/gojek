/**
 * 
 */
package com.gojek.server.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gojek.domain.Driver;
import com.gojek.domain.GojekError;
import com.gojek.services.DriverService;

/**
 * @author abhineetkumar
 *
 */
@RestController
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value = "/drivers", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> findDrivers(@RequestParam(value = "latitude", required = true) double latitude, 
			@RequestParam(value = "longitude", required = true) double longitude, @RequestParam(value = "radius", defaultValue="500") long radius,
			@RequestParam(value = "limit", defaultValue="10") int limit){

		if(90 < latitude || latitude < -90){
			GojekError e = new GojekError(Arrays.asList("Latitude should be between +/- 90"));
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if(180 < longitude || latitude < -180){
			GojekError e = new GojekError(Arrays.asList("Longitude should be between +/- 180"));
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if(radius < 0 || radius >10000){
			GojekError e = new GojekError(Arrays.asList("Unacceptable radius value"));
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		List<Driver> driverList = driverService.findDrivers(latitude, longitude, radius, limit);
		return new ResponseEntity<>(driverList, HttpStatus.OK);
	}
}
