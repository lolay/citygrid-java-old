package com.lolay.citygrid;

public enum SearchType {
	MOVIE,
	MOVIETHEATER,
	RESTAURANT,
	HOTEL,
	TRAVEL,
	BARCLUB,
	SPABEAUTY,
	SHOPPING;
	
	public String toString() {
		return super.toString().toLowerCase();
	}
}