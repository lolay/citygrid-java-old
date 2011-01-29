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
package com.lolay.citygrid.ads.custom;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.ClientFactory;
import com.lolay.citygrid.ads.custom.BannerAd;
import com.lolay.citygrid.ads.custom.BannerResults;
import com.lolay.citygrid.ads.custom.CustomAd;
import com.lolay.citygrid.ads.custom.CustomAdsClient;
import com.lolay.citygrid.ads.custom.CustomAdsInvoker;
import com.lolay.citygrid.ads.custom.CustomAdsResults;

import junit.framework.TestCase;

public class CustomAdsIntegration extends TestCase {
	private static final Log testBannerLog = LogFactory.getLog(CustomAdsIntegration.class.getName() + ".testBanner");
	private static final Log testWhereLog = LogFactory.getLog(CustomAdsIntegration.class.getName() + ".testWhere");
	private static final Log testLatLonLog = LogFactory.getLog(CustomAdsIntegration.class.getName() + ".testLatLon");
	private static final String baseUrl = "http://api.citygridmedia.com";
	
	public void disabledtestBanner() throws Exception {
		final Log log = testBannerLog;
		log.trace("ENTER");
		
		CustomAdsClient pfpProxy = new ClientFactory(baseUrl).getPfp();
		
		CustomAdsInvoker pfp = CustomAdsInvoker.builder().what("restaurant").where("90069").publisher("citysearch").rotation(true).build();
		BannerResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = pfp.banner(pfpProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("PFP Banner took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		
		assertNotNull(results);
		assertNotNull(results.getAds());
		assertEquals(10, results.getAds().size());
		for (BannerAd ad : results.getAds()) {
			assertNotNull(ad.getId());
			assertNotNull(ad.getListingId());
			assertNotNull(ad.getAdDestinationUrl());
			assertNotNull(ad.getAdImageUrl());
		}
	}
	
	public void testWhere() throws Exception {
		final Log log = testWhereLog;
		log.trace("ENTER");
		
		CustomAdsClient pfpProxy = new ClientFactory(baseUrl).getPfp();
		
		CustomAdsInvoker pfp = CustomAdsInvoker.builder().what("restaurant").where("90069").publisher("citysearch").build();
		CustomAdsResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = pfp.where(pfpProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("PFP took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		
		assertNotNull(results);
		assertNotNull(results.getAds());
		assertEquals(10, results.getAds().size());
		for (CustomAd ad : results.getAds()) {
			assertNotNull(ad.getType());
			assertNotNull(ad.getAdDestinationUrl());
			
			if (ad.getListingId() != null && ad.getListingId() != 0) {
				assertNotNull(ad.getId());
				assertNotNull(ad.getImpressionId());
				assertNotNull(ad.getName());
				assertNotNull(ad.getLatitude());
				assertNotNull(ad.getLongitude());
				assertNotNull(ad.getGrossPpe());
			} else {
				assertNotNull(ad.getTagline());
				assertNotNull(ad.getDescription());
			}
		}
		
	}

	public void testLatLon() throws Exception {
		final Log log = testLatLonLog;
		log.trace("ENTER");
		
		CustomAdsClient pfpProxy = new ClientFactory(baseUrl).getPfp();
		
		CustomAdsInvoker pfp = CustomAdsInvoker.builder().what("restaurant").latitude(34.0522222D).longitude(-118.2427778D).radius(50).publisher("citysearch").build();
		CustomAdsResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = pfp.latlon(pfpProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("PFP location took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		
		assertNotNull(results);
		assertNotNull(results.getAds());
		assertEquals(10, results.getAds().size());
		for (CustomAd ad : results.getAds()) {
			assertNotNull(ad.getType());
			assertNotNull(ad.getAdDestinationUrl());
			
			if (ad.getListingId() != null) {
				assertNotNull(ad.getId());
				assertNotNull(ad.getImpressionId());
				assertNotNull(ad.getName());
				assertNotNull(ad.getLatitude());
				assertNotNull(ad.getLongitude());
				assertNotNull(ad.getGrossPpe());
			} else {
				assertNotNull(ad.getTagline());
				assertNotNull(ad.getDescription());
			}
		}
		
	}
}