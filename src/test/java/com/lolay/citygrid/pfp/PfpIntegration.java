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
package com.lolay.citygrid.pfp;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.ClientFactory;

import junit.framework.TestCase;

public class PfpIntegration extends TestCase {
	private static final Log testBannerLog = LogFactory.getLog(PfpIntegration.class.getName() + ".testBanner");
	private static final Log testPfpLog = LogFactory.getLog(PfpIntegration.class.getName() + ".testPfp");
	private static final String baseUrl = "http://pfp.citysearch.com";
	
	public void testBanner() throws Exception {
		final Log log = testBannerLog;
		log.trace("ENTER");
		
		PfpClient pfpProxy = new ClientFactory(null, baseUrl).getPfp();
		
		PfpInvoker pfp = PfpInvoker.builder().what("restaurant").where("90069").publisher("citysearch").rotation(true).build();
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
	
	public void testPfp() throws Exception {
		final Log log = testPfpLog;
		log.trace("ENTER");
		
		PfpClient pfpProxy = new ClientFactory(null, baseUrl).getPfp();
		
		PfpInvoker pfp = PfpInvoker.builder().what("restaurant").where("90069").publisher("citysearch").build();
		PfpResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = pfp.pfp(pfpProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("PFP took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		
		assertNotNull(results);
		assertNotNull(results.getAds());
		assertEquals(10, results.getAds().size());
		for (PfpAd ad : results.getAds()) {
			assertNotNull(ad.getType());
			assertNotNull(ad.getAdDestinationUrl());
			assertNotNull(ad.getAdImageUrl());
			
			if (ad.getListingId() != null) {
				assertNotNull(ad.getId());
				assertNotNull(ad.getName());
				assertNotNull(ad.getLatitude());
				assertNotNull(ad.getLongitude());
				assertNotNull(ad.getAdImageUrl());
				assertNotNull(ad.getNetPpe());
			} else {
				assertNotNull(ad.getTagline());
				assertNotNull(ad.getDescription());
			}
		}
		
	}
}