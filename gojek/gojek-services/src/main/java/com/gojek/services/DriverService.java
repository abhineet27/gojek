/**
 * 
 */
package com.gojek.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gojek.domain.Driver;
import com.gojek.domain.Location;

/**
 * @author abhineetkumar
 *
 */
@Service
public class DriverService {

	public List<Driver> findDrivers(final double latitude, final double longitude, final long radius, final int limit){
		final Set<Location> sortedLocation = LocationService.getSortedLocation();
		List<Driver> driverList = new ArrayList<>();
		
		for(Location loc : sortedLocation){
			if(limit == driverList.size()){
				break;
			}
			final double lat = loc.getLatitude();
			final double longi = loc.getLongitude();
			
			if( lat < (latitude - radius) || lat > (latitude + radius) || longi < (longitude - radius) || longi > (longitude + radius)){
				continue;
			}
			double x = Math.abs(latitude - lat);
			double y = Math.abs(longitude - longi);
			double dist = x*x + y*y;
			if(radius*radius >= dist){
				final Driver d = new Driver(loc.getDriverId(), loc.getLatitude(), loc.getLongitude(), (int)Math.sqrt(dist)); 
				driverList.add(d);
			}
		}
		
		return driverList;
	}
}
