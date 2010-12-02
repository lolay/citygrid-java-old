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

import com.lolay.citygrid.pfp.PfpClient;
import com.lolay.citygrid.profile.ProfileClient;
import com.lolay.citygrid.search.SearchClient;
import com.lolay.citygrid.tracking.TrackingClient;

public class ClientFactory {
	private String apiBaseUrl = null;
	private String pfpBaseUrl = null;
	private SearchClient search = null;
	private ProfileClient profile = null;
	private TrackingClient tracking = null;
	private PfpClient pfp = null;
	
	public ClientFactory(String apiBaseUrl, String pfpBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
		this.pfpBaseUrl = pfpBaseUrl;
	}

	private <R> R getApiResource(Class<R> type) {
		return JAXRSClientFactory.create(apiBaseUrl, type);
	}
	
	private <R> R getPfpResource(Class<R> type) {
		return JAXRSClientFactory.create(pfpBaseUrl, type);
	}
	
	public synchronized SearchClient getSearch() {
		if (search == null) {
			search = getApiResource(SearchClient.class);
		}
		return search;
	}
	
	public synchronized ProfileClient getProfile() {
		if (profile == null) {
			profile = getApiResource(ProfileClient.class);
		}
		return profile;
	}
	
	public synchronized TrackingClient getTracking() {
		if (tracking == null) {
			tracking = getApiResource(TrackingClient.class);
		}
		return tracking;
	}
	
	public synchronized PfpClient getPfp() {
		if (pfp == null) {
			pfp = getPfpResource(PfpClient.class);
		}
		return pfp;
	}
}