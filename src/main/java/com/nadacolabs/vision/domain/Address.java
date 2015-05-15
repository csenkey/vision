package com.nadacolabs.vision.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String zip;
	private String town;
	private String address;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	
	public static class AddressBuilder {
		private Address address;
		public AddressBuilder() {
			address = new Address();
		}
		public AddressBuilder setZip(String zip){
			address.setZip(zip);
			return this;
		}
		public AddressBuilder setTown(String town){
			address.setTown(town);
			return this;
		}
		public AddressBuilder setAddress(String address){
			this.address.setAddress(address);
			return this;
		}
		public Address build(){
			return address;
		}
	}

}
