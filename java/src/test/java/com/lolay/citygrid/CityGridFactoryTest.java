package com.lolay.citygrid;

import junit.framework.TestCase;

public class CityGridFactoryTest extends TestCase {
	public void testSearch() throws Exception {
		CityGridFactory factory = new CityGridFactory("http://api2.citygridmedia.com");
		Search search1 = factory.getSearch();
		assertNotNull(search1);
		Search search2 = factory.getSearch();
		assertNotNull(search2);
		assertSame(search1, search2);
	}
}