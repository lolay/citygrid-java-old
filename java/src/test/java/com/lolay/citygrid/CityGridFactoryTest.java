package com.lolay.citygrid;

import junit.framework.TestCase;

public class CityGridFactoryTest extends TestCase {
	public void testSearch() throws Exception {
		ClientFactory factory = new ClientFactory("http://api2.citygridmedia.com");
		SearchClient search1 = factory.getSearch();
		assertNotNull(search1);
		SearchClient search2 = factory.getSearch();
		assertNotNull(search2);
		assertSame(search1, search2);
	}
}