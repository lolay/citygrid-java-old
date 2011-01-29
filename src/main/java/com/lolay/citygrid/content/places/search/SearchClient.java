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
package com.lolay.citygrid.content.places.search;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolay.citygrid.Format;

/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Places+API#PlacesAPI-PlacesSearch
 * @see SearchInvoker
 */
@Path("/content/places/v2/search")
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface SearchClient {
	public static final Float MAX_RADIUS = 25F;
	public static final Integer MAX_RESULTS_PER_PAGE = 50;
	
	public static final String TYPE = "type";
	public static final String WHAT = "what";
	public static final String TAG = "tag";
	public static final String CHAIN = "chain";
	public static final String FIRST = "first";
	public static final String WHERE = "where";
	public static final String LATITUDE = "lat";
	public static final String LONGITUDE = "lon";
	public static final String LATITUDE2 = "lat2";
	public static final String LONGITUDE2 = "lon2";
	public static final String RADIUS = "radius";
	public static final String PAGE = "page";
	public static final String RESULTS_PER_PAGE = "rpp";
	public static final String SORT = "sort";
	public static final String PUBLISHER = "publisher";
	public static final String API_KEY = "api_key";
	public static final String FORMAT = "format";
	public static final String PLACEMENT = "placement";
	public static final String HAS_OFFERS = "has_offers";
	public static final String HISTOGRAMS = "histograms";
	
	@GET
	@Path("/where")
	public Response where(
			@QueryParam(TYPE) SearchType type,
			@QueryParam(WHAT) String what,
			@QueryParam(TAG) Integer tag,
			@QueryParam(CHAIN) Integer chain,
			@QueryParam(FIRST) Character first,
			@QueryParam(WHERE) String where,
			@QueryParam(PAGE) Integer page,
			@QueryParam(RESULTS_PER_PAGE) Integer resultsPerPage,
			@QueryParam(SORT) SearchSort sort,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(API_KEY) String apiKey,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(HAS_OFFERS) Boolean hasOffers,
			@QueryParam(HISTOGRAMS) Boolean histograms,
			@QueryParam(FORMAT) Format format);
	
	@GET
	@Path("/latlon")
	public Response latlon(
			@QueryParam(TYPE) SearchType type,
			@QueryParam(WHAT) String what,
			@QueryParam(TAG) Integer tag,
			@QueryParam(CHAIN) Integer chain,
			@QueryParam(FIRST) Character first,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(LATITUDE2) Double latitude2,
			@QueryParam(LONGITUDE2) Double longitude2,
			@QueryParam(RADIUS) Float radius,
			@QueryParam(PAGE) Integer page,
			@QueryParam(RESULTS_PER_PAGE) Integer resultsPerPage,
			@QueryParam(SORT) SearchSort sort,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(API_KEY) String apiKey,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(HAS_OFFERS) Boolean hasOffers,
			@QueryParam(HISTOGRAMS) Boolean histograms,
			@QueryParam(FORMAT) Format format);
}