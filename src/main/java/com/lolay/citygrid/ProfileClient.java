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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @see http://developer.citygridmedia.com/docs/profile
 * @see ProfileInvoker
 */
@Path("/profile")
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface ProfileClient {
	public static final Float MAX_RADIUS = 25F;
	public static final Integer MAX_RESULTS_PER_PAGE = 50;
	
	public static final String LISTING_ID = "listing_id";
	public static final String INFO_USA_ID = "infousa_id";
	public static final String PHONE = "phone";
	public static final String PUBLISHER = "publisher";
	public static final String API_KEY = "api_key";
	public static final String CUSTOMER_ONLY = "customer_only";
	public static final String ALL_RESULTS = "all_results";
	public static final String REVIEW_COUNT = "review_count";
	public static final String PLACEMENT = "placement";
	public static final String CLIENT_IP = "client_ip";
	public static final String FORMAT = "format";
	public static final String NOLOG = "nolog";

	@GET
	public Response profile(
			@QueryParam(LISTING_ID) Integer listingId,
			@QueryParam(INFO_USA_ID) Integer infoUsaId,
			@QueryParam(PHONE) String phone,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(API_KEY) String apiKey,
			@QueryParam(CUSTOMER_ONLY) Boolean customerOnly,
			@QueryParam(ALL_RESULTS) Boolean allResults,
			@QueryParam(REVIEW_COUNT) Integer reviewCount,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(FORMAT) Format format,
			@QueryParam(NOLOG) Integer noLog);
}