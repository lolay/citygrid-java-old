package com.lolay.citygrid;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

public class SearchIntegration extends TestCase {
	private static final Log testLocationsLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testLocations");
	private static final Log testLocationsCorrectionLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testLocationsCorrection");
	private static final Log testEventsLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testEvents");
	private static final String baseUrl = "http://api.citygridmedia.com";
	
	public void testLocations() throws Exception {
		Log log = testLocationsLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.type(SearchType.RESTAURANT).where("90069").placement("junit").build();
		SearchResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = search.locations(searchProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("Location search took %s ms", end - start));
		} catch (WebApplicationException e) {
			log(log, e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotal());
		assertTrue(results.getTotal() > 0);
		assertNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirst());
		assertEquals((Integer) 20, results.getLast());
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		assertTrue(results.getRegions().size() > 0);
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getRadius());
		}
		
		assertNotNull(results.getLocations());
		assertTrue(results.getLocations().size() > 0);
		for (Location location : results.getLocations()) {
			assertNotNull(location.getId());
			assertNotNull(location.getFeatured());
			assertNotNull(location.getName());
			assertNotNull(location.getAddress());
			assertNotNull(location.getLatitude());
			assertNotNull(location.getLongitude());
			assertNotNull(location.getProfile());
			assertNotNull(location.getVideo());
			assertNotNull(location.getOffers());
			assertNotNull(location.getReviewsCount());
			assertNotNull(location.getSampleCategories());
		}
		
		assertNull(results.getEngagements());
		
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
	
	public void testLocationsCorrection() throws Exception {
		Log log = testLocationsCorrectionLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.what("computr parts").where("90069").placement("junit").build();
		SearchResults results = null;
		try {
			results = search.locations(searchProxy);
		} catch (WebApplicationException e) {
			log(log, e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotal());
		assertEquals((Integer) 0, results.getTotal());
		assertNotNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirst());
		assertEquals((Integer) 0, results.getLast());
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		assertTrue(results.getRegions().size() > 0);
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getRadius());
		}
	}
	
	public void testEvents() throws Exception {
		Log log = testEventsLog;
		log.trace("ENTER");
		SearchClient searchProxy = new ClientFactory(baseUrl).getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("acme")
			.type(SearchType.MOVIE).where("90069").placement("junit").build();
		SearchResults results = null;
		try {
			long start = System.currentTimeMillis();
			results = search.events(searchProxy);
			long end = System.currentTimeMillis();
			log.trace(String.format("Events search took %s ms", end - start));
		} catch (WebApplicationException e) {
			log(log, e);
			fail();
		}
		assertNotNull(results);
		assertNotNull(results.getTotal());
		assertTrue(results.getTotal() > 0);
		assertNull(results.getDidYouMean());
		assertEquals((Integer) 1, results.getFirst());
		assertNotNull(results.getLast());
		assertTrue(results.getLast() > 0);
		assertNotNull(results.getUri());
		assertNotNull(results.getRegions());
		assertTrue(results.getRegions().size() > 0);
		for (Region region : results.getRegions()) {
			assertNotNull(region.getType());
			assertNotNull(region.getLatitude());
			assertNotNull(region.getLongitude());
			assertNotNull(region.getRadius());
		}
		
		assertNull(results.getLocations());
		
		assertNotNull(results.getEngagements());
		assertTrue(results.getEngagements().size() > 0);
		for (Engagement engagement : results.getEngagements()) {
			assertNotNull(engagement.getEvent());
			Event event = engagement.getEvent();
			assertNotNull(event.getId());
			assertNotNull(event.getName());
			assertNotNull(event.getPerformances());
			assertNotNull(event.getReviewsCount());
			
			Location location = engagement.getLocation();
			assertNotNull(location.getId());
			assertNotNull(location.getName());
			assertNotNull(location.getAddress());
			assertNotNull(location.getLatitude());
			assertNotNull(location.getLongitude());
		}
		
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
	
	private void log(Log log, WebApplicationException e) throws Exception {
		Response response = e.getResponse();
		log.error(response);
	}
}