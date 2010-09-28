package com.lolay.citygrid;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchInvoker implements Serializable {
	private static final long serialVersionUID = 1L;

	private SearchType type = null;
	private String what = null;
	private Integer tag = null;
	private Integer chain = null;
	private Character first = null;
	private String where = null;
	private Double latitude = null;
	private Double longitude = null;
	private Float radius = null;
	private Integer page = null;
	private Integer resultsPerPage = null;
	private SearchSort sort = null;
	private String publisher = null;
	private String apiKey = null;
	private String placement = null;

	private SearchType getType() {
		return type;
	}
	public void setType(SearchType type) {
		this.type = type;
	}

	private String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}

	private Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}

	private Integer getChain() {
		return chain;
	}
	public void setChain(Integer chain) {
		this.chain = chain;
	}

	private Character getFirst() {
		return first;
	}
	public void setFirst(Character first) {
		this.first = first;
	}

	private String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}

	private Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	private Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	private Float getRadius() {
		return radius;
	}
	public void setRadius(Float radius) {
		this.radius = radius;
	}

	private Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	private Integer getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	private SearchSort getSort() {
		return sort;
	}
	public void setSort(SearchSort sort) {
		this.sort = sort;
	}

	private String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	private String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	private String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public SearchResults locations(SearchClient search) {
		return search.locations(getType(), getWhat(), getTag(), getChain(), getFirst(), getWhere(), getLatitude(), getLongitude(),
				getRadius(), getPage(), getResultsPerPage(), getSort(), getPublisher(), getApiKey(), getPlacement(), SearchFormat.XML);
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
	
	public static Builder builder(SearchInvoker prototype) {
		return builder().type(prototype.getType()).what(prototype.getWhat()).tag(prototype.getTag()).chain(prototype.getChain())
				.first(prototype.getFirst()).where(prototype.getWhere()).latitude(prototype.getLatitude())
				.longitude(prototype.getLongitude()).radius(prototype.getRadius()).page(prototype.getPage())
				.resultsPerPage(prototype.getResultsPerPage()).sort(prototype.getSort()).publisher(prototype.getPublisher())
				.apiKey(prototype.getApiKey()).placement(prototype.getPlacement());
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