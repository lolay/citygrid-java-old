package com.lolay.citygrid;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

public class CityGridFactory {
	private String baseUrl = null;
	private Search search = null;
	
	public CityGridFactory(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	private <R> R getResource(Class<R> type) {
		return JAXRSClientFactory.create(baseUrl, type);
	}
	
	public synchronized Search getSearch() {
		if (search == null) {
			search = getResource(Search.class);
		}
		return search;
	}
}