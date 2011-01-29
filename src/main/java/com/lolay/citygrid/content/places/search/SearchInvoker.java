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

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lolay.citygrid.BaseInvoker;
import com.lolay.citygrid.Format;
import com.lolay.citygrid.InvokerException;

/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Places+API#PlacesAPI-PlacesSearch
 * @see SearchClient
 */
public class SearchInvoker extends BaseInvoker {
	private static final long serialVersionUID = 1L;

	private SearchType type = null;
	private String what = null;
	private Integer tag = null;
	private Integer chain = null;
	private Character first = null;
	private String where = null;
	private Double latitude = null;
	private Double longitude = null;
	private Double latitude2 = null;
	private Double longitude2 = null;
	private Float radius = null;
	private Integer page = null;
	private Integer resultsPerPage = null;
	private SearchSort sort = null;
	private String publisher = null;
	private String apiKey = null;
	private String placement = null;
	private Boolean hasOffers = null;
	private Boolean histograms = null;

	public SearchType getType() {
		return type;
	}
	public void setType(SearchType type) {
		this.type = type;
	}

	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}

	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Integer getChain() {
		return chain;
	}
	public void setChain(Integer chain) {
		this.chain = chain;
	}

	public Character getFirst() {
		return first;
	}
	public void setFirst(Character first) {
		this.first = first;
	}

	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude2() {
		return latitude2;
	}
	public void setLatitude2(Double latitude2) {
		this.latitude2 = latitude2;
	}
	public Double getLongitude2() {
		return longitude2;
	}
	public void setLongitude2(Double longitude2) {
		this.longitude2 = longitude2;
	}
	
	public Float getRadius() {
		return radius;
	}
	public void setRadius(Float radius) {
		this.radius = radius;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public SearchSort getSort() {
		return sort;
	}
	public void setSort(SearchSort sort) {
		this.sort = sort;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	
	public Boolean getHasOffers() {
		return hasOffers;
	}
	public void setHasOffers(Boolean hasOffers) {
		this.hasOffers = hasOffers;
	}
	
	public Boolean getHistograms() {
		return histograms;
	}
	public void setHistograms(Boolean histograms) {
		this.histograms = histograms;
	}
	
	public SearchResults where(SearchClient search) throws InvokerException {
		return parseResults(SearchResults.class, search.where(getType(), getWhat(), getTag(), getChain(), getFirst(), getWhere(),
				getPage(), getResultsPerPage(), getSort(), getPublisher(), getApiKey(), getPlacement(), getHasOffers(), getHistograms(), Format.XML));
	}

	public SearchResults latlon(SearchClient search) throws InvokerException {
		return parseResults(SearchResults.class, search.latlon(getType(), getWhat(), getTag(), getChain(), getFirst(), getLatitude(), getLongitude(),
				getLatitude2(), getLongitude2(), getRadius(), getPage(), getResultsPerPage(), getSort(), getPublisher(), getApiKey(), getPlacement(),
				getHasOffers(), getHistograms(), Format.XML));
	}
	
	public static Builder builder(SearchInvoker prototype) {
		return builder().type(prototype.getType()).what(prototype.getWhat()).tag(prototype.getTag()).chain(prototype.getChain())
				.first(prototype.getFirst()).where(prototype.getWhere()).latitude(prototype.getLatitude())
				.longitude(prototype.getLongitude()).latitude2(prototype.getLatitude2()).longitude2(prototype.getLongitude2())
				.radius(prototype.getRadius()).page(prototype.getPage()).resultsPerPage(prototype.getResultsPerPage())
				.sort(prototype.getSort()).publisher(prototype.getPublisher()).apiKey(prototype.getApiKey())
				.placement(prototype.getPlacement()).hasOffers(prototype.getHasOffers()).histograms(prototype.getHistograms());
	}
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements Serializable {
		private static final long serialVersionUID = 1L;

		private SearchInvoker instance = new SearchInvoker();
		private Builder() { }
		
		public Builder type(SearchType type) {
			instance.setType(type);
			return this;
		}
		
		public Builder what(String what) {
			instance.setWhat(what);
			return this;
		}
		
		public Builder tag(Integer tag) {
			instance.setTag(tag);
			return this;
		}
		
		public Builder chain(Integer chain) {
			instance.setChain(chain);
			return this;
		}
		
		public Builder first(Character first) {
			instance.setFirst(first);
			return this;
		}
		
		public Builder where(String where) {
			instance.setWhere(where);
			return this;
		}
		
		public Builder latitude(Double latitude) {
			instance.setLatitude(latitude);
			return this;
		}
		
		public Builder longitude(Double longitude) {
			instance.setLongitude(longitude);
			return this;
		}
		
		public Builder latitude2(Double latitude2) {
			instance.setLatitude2(latitude2);
			return this;
		}
		
		public Builder longitude2(Double longitude2) {
			instance.setLongitude2(longitude2);
			return this;
		}
		
		public Builder radius(Float radius) {
			instance.setRadius(radius);
			return this;
		}
		
		public Builder page(Integer page) {
			instance.setPage(page);
			return this;
		}
		
		public Builder resultsPerPage(Integer resultsPerPage) {
			instance.setResultsPerPage(resultsPerPage);
			return this;
		}
		
		public Builder sort(SearchSort sort) {
			instance.setSort(sort);
			return this;
		}
		
		public Builder publisher(String publisher) {
			instance.setPublisher(publisher);
			return this;
		}
		
		public Builder apiKey(String apiKey) {
			instance.setApiKey(apiKey);
			return this;
		}
		
		public Builder placement(String placement) {
			instance.setPlacement(placement);
			return this;
		}
		
		public Builder hasOffers(Boolean hasOffers) {
			instance.setHasOffers(hasOffers);
			return this;
		}
		
		public Builder histograms(Boolean histograms) {
			instance.setHistograms(histograms);
			return this;
		}
		
		public SearchInvoker build() {
			return instance;
		}

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this);
		}
		@Override
		public boolean equals(Object obj) {
		   return EqualsBuilder.reflectionEquals(this, obj);
		}
		@Override
		public String toString() {
		   return ToStringBuilder.reflectionToString(this);
		}
	}
}