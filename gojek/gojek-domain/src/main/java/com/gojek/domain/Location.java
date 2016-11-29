/**
 * 
 */
package com.gojek.domain;

/**
 * @author abhineetkumar
 *
 */
public class Location implements Comparable<Location>{

	private int driverId;
	private double latitude;
	private double longitude;
	private double accuracy;
	
	public Location(int driverId, double latitude, double longitude, double accuracy) {
		super();
		this.driverId = driverId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
	}
	
	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public int compareTo(Location o) {
		return this.driverId == o.driverId ? 0 : this.latitude > o.latitude ? 1 : -1;
	}
}
