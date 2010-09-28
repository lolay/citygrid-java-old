package com.lolay.citygrid;

public enum SearchFormat {
	JSON,
	XML;
	
	public String toString() {
		return super.toString().toLowerCase();
	}
}