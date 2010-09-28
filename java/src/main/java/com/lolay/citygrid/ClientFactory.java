package com.lolay.citygrid;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

public class ClientFactory {
	private String baseUrl = null;
	private SearchClient search = null;
	
	public ClientFactory(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	private <R> R getResource(Class<R> type) {
		return JAXRSClientFactory.create(baseUrl, type);
	}
	
	public synchronized SearchClient getSearch() {
		if (search == null) {
			search = getResource(SearchClient.class);
		}
		return search;
	}
}