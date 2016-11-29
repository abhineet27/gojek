/**
 * 
 */
package com.gojek.services;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.gojek.domain.Location;

/**
 * @author abhineetkumar
 *
 */
@Service
public class LocationService {

	//private static Set<Location> sortedLocation = new TreeSet<>();
	
	private static Set<Location> sortedLocation = new TreeSet<>();
	private static Set<Integer> locationSet = new HashSet<>();
	public static Set<Location> getSortedLocation() {
		return sortedLocation;
	}

	public void addAddress(Location location){
		
		if(locationSet.add(location.getDriverId())){
			sortedLocation.add(location);
		}else{
			final Location loc = findNode(location.getDriverId());
			sortedLocation.remove(loc);
			sortedLocation.add(location);
		}
	}
	
	private Location findNode(int id) {  
		for(Location loc : sortedLocation){
			if(loc.getDriverId() == id){
				return loc;
			}
		}

        return null;                
    }
}
