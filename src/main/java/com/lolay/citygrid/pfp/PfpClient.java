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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolay.citygrid.Format;

/**
 * @see PfpInvoker
 */
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface PfpClient {
	public static final String WHAT = "what";
	public static final String WHERE = "where";
	public static final String LATITUDE = "lat";
	public static final String LONGITUDE = "lon";
	public static final String RADIUS = "radius";
	public static final String PUBLISHER = "publisher";
	public static final String CLIENT_IP = "client_ip";
	public static final String SIZE = "size";
	public static final String FORMAT = "format";
	public static final String THEME = "theme";
	public static final String MAX = "max";
	public static final String PLACEMENT = "placement";
	public static final String ROTATION = "rotation";
	public static final String TAGS = "tags";
	public static final String GEOGRAPHIES = "geographies";
	
	@GET
	@Path("/pfp")
	public Response query(
			@QueryParam(WHAT) String what,
			@QueryParam(WHERE) String where,
			@QueryParam(TAGS) String tags,
			@QueryParam(GEOGRAPHIES) String geographies,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(FORMAT) Format format,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement);
	
	@GET
	@Path("/pfp/location")
	public Response location(
			@QueryParam(WHAT) String what,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Float radius,
			@QueryParam(TAGS) String tags,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(FORMAT) Format format,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement);
	
	@GET
	@Path("/pfp/banner")
	public Response banner(
			@QueryParam(WHAT) String what,
			@QueryParam(WHERE) String where,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Float radius,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(SIZE) BannerSize size,
			@QueryParam(FORMAT) Format format,
			@QueryParam(THEME) BannerTheme theme,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(ROTATION) Boolean rotation);
}