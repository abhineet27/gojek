/**
 * 
 */
package com.gojek.domain;

/**
 * @author abhineetkumar
 *
 */
public class Address implements Comparable<Address>{

	private int driverId;
	private double latitude;
	private double longitude;
	private double accuracy;
	
	public Address(int driverId, double latitude, double longitude, double accuracy) {
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
	public int compareTo(Address o) {
		if(this.driverId == o.driverId){
			return 0;
		}
		return this.latitude > o.latitude ? 1 : -1;
	}
	
	/*@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}*/
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("this.driverId:"+this.driverId);
		int did = ((Address)obj).driverId;
		System.out.println("did:"+did);
		return this.driverId == did ? false : true;
	}
}
