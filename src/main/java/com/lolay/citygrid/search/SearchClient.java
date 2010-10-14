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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolay.citygrid.Format;

/**
 * @see http://developer.citygridmedia.com/docs/search
 * @see SearchInvoker
 */
@Path("/search")
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface SearchClient {
	public static final Float MAX_RADIUS = 25F;
	public static final Integer MAX_RESULTS_PER_PAGE = 50;
	
	public static final String TYPE = "type";
	public static final String WHAT = "what";
	public static final String TAG = "tag";
	public static final String TAGS = "tags";
	public static final String CHAIN = "chain";
	public static final String FIRST = "first";
	public static final String WHERE = "where";
	public static final String LATITUDE = "lat";
	public static final String LONGITUDE = "lon";
	public static final String RADIUS = "radius";
	public static final String PAGE = "page";
	public static final String RESULTS_PER_PAGE = "rpp";
	public static final String SORT = "sort";
	public static final String PUBLISHER = "publisher";
	public static final String API_KEY = "api_key";
	public static final String FORMAT = "format";
	public static final String PLACEMENT = "placement";
	public static final String FROM = "from";
	public static final String TO = "to";
	
	@GET
	@Path("/locations")
	public Response locations(
			@QueryParam(TYPE) SearchType type,
			@QueryParam(WHAT) String what,
			@QueryParam(TAG) Integer tag,
			@QueryParam(TAGS) String tags,
			@QueryParam(CHAIN) Integer chain,
			@QueryParam(FIRST) Character first,
			@QueryParam(WHERE) String where,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Float radius,
			@QueryParam(PAGE) Integer page,
			@QueryParam(RESULTS_PER_PAGE) Integer resultsPerPage,
			@QueryParam(SORT) SearchSort sort,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(API_KEY) String apiKey,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(FORMAT) Format format);
	
	@GET
	@Path("/events")
	public Response events(
			@QueryParam(TYPE) SearchType type,
			@QueryParam(WHAT) String what,
			@QueryParam(FIRST) Character first,
			@QueryParam(WHERE) String where,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Float radius,
			@QueryParam(FROM) String from,
			@QueryParam(TO) String to,
			@QueryParam(PAGE) Integer page,
			@QueryParam(RESULTS_PER_PAGE) Integer resultsPerPage,
			@QueryParam(SORT) SearchSort sort,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(API_KEY) String apiKey,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(FORMAT) Format format);
}