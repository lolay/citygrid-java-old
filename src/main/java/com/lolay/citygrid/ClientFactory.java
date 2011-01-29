/*
 * Licensed to Lolay, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Lolay, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://github.com/lolay/citygrid/raw/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package com.lolay.citygrid;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.lolay.citygrid.ads.custom.CustomAdsClient;
import com.lolay.citygrid.ads.tracking.TrackingClient;
import com.lolay.citygrid.content.places.detail.DetailClient;
import com.lolay.citygrid.content.places.search.SearchClient;

public class ClientFactory {
	private String apiBaseUrl = null;
	private SearchClient search = null;
	private DetailClient profile = null;
	private TrackingClient tracking = null;
	private CustomAdsClient pfp = null;
	
	public ClientFactory(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}

	private <R> R getApiResource(Class<R> type) {
		return JAXRSClientFactory.create(apiBaseUrl, type);
	}
	
	private <R> R getPfpResource(Class<R> type) {
		return JAXRSClientFactory.create(apiBaseUrl, type);
	}
	
	public synchronized SearchClient getSearch() {
		if (search == null) {
			search = getApiResource(SearchClient.class);
		}
		return search;
	}
	
	public synchronized DetailClient getProfile() {
		if (profile == null) {
			profile = getApiResource(DetailClient.class);
		}
		return profile;
	}
	
	public synchronized TrackingClient getTracking() {
		if (tracking == null) {
			tracking = getApiResource(TrackingClient.class);
		}
		return tracking;
	}
	
	public synchronized CustomAdsClient getPfp() {
		if (pfp == null) {
			pfp = getPfpResource(CustomAdsClient.class);
		}
		return pfp;
	}
}