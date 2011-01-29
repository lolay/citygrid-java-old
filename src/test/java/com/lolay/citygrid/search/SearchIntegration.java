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
package com.lolay.citygrid.search;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.ClientFactory;
import com.lolay.citygrid.ErrorCode;
import com.lolay.citygrid.InvokerException;

import junit.framework.TestCase;

public class SearchIntegration extends TestCase {
	private static final Log testWhereLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testWhere");
	private static final Log testWhereCorrectionLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testWhereCorrection");
	private static final Log testErrorsLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testErrors");
	private static final Log testLatLonLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testLatLon");
	private static final String baseUrl = "http://api.citygridmedia.com";
	
	public void testWhere() throws Exception {
		Log log = testWhereLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.type(SearchType.RESTAURANT).where("90069").placement("junit").histograms(true).build();
		SearchResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = search.where(searchProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("Location search took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotalHits());
		assertTrue(results.getTotalHits() > 0);
		assertNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirstHit());
		assertEquals((Integer) 20, results.getLastHit());
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		assertTrue(results.getRegions().size() > 0);
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getDefaultRadius());
		}
		
		assertNotNull(results.getLocations());
		assertTrue(results.getLocations().size() > 0);
		boolean ratingChecked = false;
		boolean imageChecked = false;
		for (SearchLocation location : results.getLocations()) {
			assertNotNull(location.getId());
			assertNotNull(location.getImpressionId());
			assertNotNull(location.getFeatured());
			assertNotNull(location.getName());
			assertNotNull(location.getAddress());
			assertNotNull(location.getLatitude());
			assertNotNull(location.getLongitude());
			assertNotNull(location.getProfile());
			assertNotNull(location.getHasVideo());
			assertNotNull(location.getHasOffers());
			assertNotNull(location.getUserReviewCount());
			assertNotNull(location.getSampleCategories());
			if (location.getId().equals(101344)) {
				assertNotNull(location.getRating());
				ratingChecked = true;
			}
			if (location.getId().equals(101409)) {
				assertNotNull(location.getImage());
				imageChecked = true;
			}
		}
		assertTrue(ratingChecked);
		assertTrue(imageChecked);
		
		assertNotNull(results.getHistograms());
		assertTrue(results.getHistograms().size() > 0);
		for (Histogram histogram : results.getHistograms()) {
			assertNotNull(histogram.getName());
			assertNotNull(histogram.getItems());
			assertTrue(histogram.getItems().size() > 0);
			for (HistogramItem item : histogram.getItems()) {
				assertNotNull(item.getName());
				assertNotNull(item.getCount());
				assertTrue(item.getCount() > 0);
				assertNotNull(item.getUri());
			}
		}
	}
	
	public void testWhereCorrection() throws Exception {
		Log log = testWhereCorrectionLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.what("computr parts").where("90069").placement("junit").build();
		SearchResults results = null;
		try {
			results = search.where(searchProxy);
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotalHits());
		assertEquals((Integer) 0, results.getTotalHits());
		assertNotNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirstHit());
		assertEquals((Integer) 0, results.getLastHit());
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		assertTrue(results.getRegions().size() > 0);
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getDefaultRadius());
		}
	}
	
	public void testError() throws Exception {
		Log log = testErrorsLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.type(SearchType.RESTAURANT).where("abcdefghijklmnopqrstuvwxyz").placement("junit").build();
		try {
			search.where(searchProxy);
			fail();
		} catch (InvokerException e) {
			assertNotNull(e.getErrorCodes());
			assertEquals(1, e.getErrorCodes().size());
			assertEquals(ErrorCode.GEOCODE_FAILURE, e.getErrorCodes().get(0));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
	}
	
	public void testLatLon() throws Exception {
		Log log = testLatLonLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.type(SearchType.RESTAURANT).latitude(34.0522222D).longitude(-118.2427778D)
			.placement("junit").histograms(true).build();
		SearchResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = search.latlon(searchProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("Location search took %s ms", end - start));
		} catch (WebApplicationException e) {
			log.error(e.getResponse(), e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotalHits());
		assertTrue(results.getTotalHits() > 0);
		assertNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirstHit());
		assertEquals((Integer) 20, results.getLastHit());
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getDefaultRadius());
		}
		
		assertNotNull(results.getLocations());
		assertTrue(results.getLocations().size() > 0);
		boolean ratingChecked = false;
		boolean imageChecked = false;
		for (SearchLocation location : results.getLocations()) {
			assertNotNull(location.getId());
			assertNotNull(location.getImpressionId());
			assertNotNull(location.getFeatured());
			assertNotNull(location.getName());
			assertNotNull(location.getAddress());
			assertNotNull(location.getLatitude());
			assertNotNull(location.getLongitude());
			assertNotNull(location.getProfile());
			assertNotNull(location.getHasVideo());
			assertNotNull(location.getHasOffers());
			assertNotNull(location.getUserReviewCount());
			assertNotNull(location.getSampleCategories());
			if (location.getId().equals(46312464)) {
				assertNotNull(location.getRating());
				ratingChecked = true;
			}
			if (location.getId().equals(46312464)) {
				assertNotNull(location.getImage());
				imageChecked = true;
			}
		}
		assertTrue(ratingChecked);
		assertTrue(imageChecked);
		
		assertNotNull(results.getHistograms());
		assertTrue(results.getHistograms().size() > 0);
		for (Histogram histogram : results.getHistograms()) {
			assertNotNull(histogram.getName());
			assertNotNull(histogram.getItems());
			assertTrue(histogram.getItems().size() > 0);
			for (HistogramItem item : histogram.getItems()) {
				assertNotNull(item.getName());
				assertNotNull(item.getCount());
				assertTrue(item.getCount() > 0);
				assertNotNull(item.getUri());
			}
		}
	}
}