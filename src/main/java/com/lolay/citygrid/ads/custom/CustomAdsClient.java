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
package com.lolay.citygrid.ads.custom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolay.citygrid.Format;

/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Custom+Ads+API
 * @see CustomAdsInvoker
 */
@Path("/ads/custom/v2")
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface CustomAdsClient {
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
	public static final String IMPRESSION_ID = "c";
	
	@GET
	@Path("/where")
	public Response where(
			@QueryParam(WHAT) String what,
			@QueryParam(WHERE) String where,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(RADIUS) Integer radius,
			@QueryParam(IMPRESSION_ID) String impressionId,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement);
	
	@GET
	@Path("/latlon")
	public Response latlon(
			@QueryParam(WHAT) String what,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Integer radius,
			@QueryParam(IMPRESSION_ID) String impressionId,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement);

	@GET
	@Path("/banner")
	public Response banner(
			@QueryParam(WHAT) String what,
			@QueryParam(WHERE) String where,
			@QueryParam(LATITUDE) Double latitude,
			@QueryParam(LONGITUDE) Double longitude,
			@QueryParam(RADIUS) Integer radius,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(CLIENT_IP) String clientIp,
			@QueryParam(SIZE) BannerSize size,
			@QueryParam(FORMAT) Format format,
			@QueryParam(THEME) BannerTheme theme,
			@QueryParam(MAX) Integer max,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(ROTATION) Boolean rotation);
}