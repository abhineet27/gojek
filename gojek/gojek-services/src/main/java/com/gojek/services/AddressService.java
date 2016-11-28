/**
 * 
 */
package com.gojek.services;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.gojek.domain.Address;

/**
 * @author abhineetkumar
 *
 */
@Service
public class AddressService {

	private static Set<Address> sortedAddress = new TreeSet<>();
	public void addAddress(Address address){
		if(!sortedAddress.add(address)){
			sortedAddress.remove(address);
			sortedAddress.add(address);
		}
		System.out.println(sortedAddress.size());
		for(Address add : sortedAddress){
			System.out.println(add.getLatitude());
		}
	}
}
