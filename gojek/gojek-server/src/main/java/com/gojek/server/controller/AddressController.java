/**
 * 
 */
package com.gojek.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gojek.domain.Address;
import com.gojek.services.AddressService;

/**
 * @author abhineetkumar
 *
 */
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/drivers/{id}/location", method = RequestMethod.PUT, produces = { "application/json" })
	public void addAddress(@PathVariable(value = "id") int driverId, @RequestParam(value = "latitude", required = true) double latitude, 
			@RequestParam(value = "longitude", required = true) double longitude, @RequestParam(value = "accuracy", required = true) float accuracy, 
            HttpServletRequest request) throws Exception{
		Address address = new Address(driverId, latitude, longitude, accuracy);
		addressService.addAddress(address);
	}
}
