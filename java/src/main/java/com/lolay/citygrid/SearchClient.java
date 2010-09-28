package com.lolay.citygrid;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/search")
@Consumes(MediaType.WILDCARD)
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public interface SearchClient {
	public static final String TYPE = "type";
	public static final String WHAT = "what";
	public static final String TAG = "tag";
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
	public SearchResults locations(
			@QueryParam(TYPE) SearchType type,
			@QueryParam(WHAT) String what,
			@QueryParam(TAG) Integer tag,
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
			@QueryParam(FORMAT) SearchFormat format);
	
	@GET
	@Path("/events")
	public SearchResults events(
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
			@QueryParam(FORMAT) SearchFormat format);
}