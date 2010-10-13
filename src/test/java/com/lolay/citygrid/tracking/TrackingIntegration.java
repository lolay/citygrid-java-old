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
package com.lolay.citygrid.tracking;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.ClientFactory;
import com.lolay.citygrid.InvokerException;

public class TrackingIntegration extends TestCase {
	private static final Log testImpressionLog = LogFactory.getLog(TrackingIntegration.class.getName() + ".testImpression");
	private static final String baseUrl = "http://api.citysearch.com";

	public void testImpression() throws Exception {
		Log log = testImpressionLog;
		
		log.trace("ENTER");
		
		TrackingClient client = new ClientFactory(baseUrl).getTracking();
		TrackingInvoker invoker = TrackingInvoker.builder().listingId(1).referenceId(1).actionTarget(ActionTarget.LISTING_PROFILE)
				.mobileType("junit").muid("1234567890abcdef1234567890abcdef12345678").ua("Integratin/1.0").publisher("4214549098")
				.placement("junit").build();

		try {
			long start = System.currentTimeMillis();
			invoker.impression(client);
			long end = System.currentTimeMillis();
			log.trace(String.format("Impression tracking took %s ms", end - start));
		} catch (InvokerException e) {
			log.error(e.getErrorCodes(), e);
			fail();
		}
	}
}