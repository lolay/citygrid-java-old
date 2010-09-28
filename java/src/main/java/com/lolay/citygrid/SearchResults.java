package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="results")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SearchResults implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="queryid")
	private String queryId = null;
	@XmlAttribute(name="firsthit",required=true)
	private Integer first = null;
	@XmlAttribute(name="lasthit",required=true)
	private Integer last = null;
	@XmlAttribute(name="totalhits",required=true)
	private Integer total = null;
	@XmlElement(name="uri",required=true)
	private URI uri = null;
	@XmlElement(name="didyoumean")
	private String didYouMean = null;
	@XmlElement(name="region")
	private List<Region> regions = null;
	@XmlElement(name="location")
	private List<Location> locations = null;
	@XmlElement(name="histogram")
	private List<Histogram> histograms = null;
	
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}	
	public String getDidYouMean() {
		return didYouMean;
	}
	public void setDidYouMean(String didYouMean) {
		this.didYouMean = didYouMean;
	}
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}	
	public List<Histogram> getHistograms() {
		return histograms;
	}
	public void setHistograms(List<Histogram> histograms) {
		this.histograms = histograms;
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