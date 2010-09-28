package com.lolay.citygrid;

public enum SearchSort {
	DIST,
	ALPHA,
	HIGHESTRATED,
	MOSTREVIEWED,
	TOPMATCHES,
	OFFERS;
	
	public String toString() {
		return super.toString().toLowerCase();
	}
}