package com.lolay.citygrid;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

public class SearchIntegration extends TestCase {
	private static final Log testLocationsLog = LogFactory.getLog(SearchIntegration.class.getName() + ".testLocations");
	
	public void testLocations() throws Exception {
		Log log = testLocationsLog;
		log.trace("ENTER");
		Search searchProxy = new CityGridFactory("http://api.citygridmedia.com").getSearch();
		
		SearchInvoker search = SearchInvoker.builder().publisher("csmobile")
			.type(SearchType.RESTAURANT).where("93021").format(SearchFormat.XML).build();
		try {
			SearchResults results = search.locations(searchProxy);
			assertNotNull(results.getTotal());
		} catch (WebApplicationException e) {
			log(log, e);
			fail();
		}
	}
	
	private void log(Log log, WebApplicationException e) throws Exception {
		System.out.println("GARY1" + e.toString());
		System.out.println("GARY2" + e.getResponse());
		System.out.println("GARY3" + e.getResponse().getStatus());
		System.out.println("GARY4" + e.getResponse().getEntity());
		Response response = e.getResponse();
		log.error(response);
	}
}