/**
 * 
 */
package com.gojek.domain;

/**
 * @author abhineetkumar
 *
 */
public class Driver {

	private int id;
	private double latitude;
	private double longitude;
	private int distance;

	public Driver(int driverId, double latitude, double longitude, int distance) {
		super();
		this.id = driverId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
