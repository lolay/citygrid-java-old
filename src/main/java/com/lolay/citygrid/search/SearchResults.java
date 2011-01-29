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

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lolay.citygrid.UriAdapter;

/**
 * @see http://developer.citygridmedia.com/docs/search
 */
@XmlRootElement(name="results")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SearchResults implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="first_hit",required=true)
	private Integer firstHit = null;
	@XmlAttribute(name="last_hit",required=true)
	private Integer lastHit = null;
	@XmlAttribute(name="total_hits",required=true)
	private Integer totalHits = null;
	@XmlAttribute(name="page",required=true)
	private Integer page = null;
	@XmlAttribute(name="rpp",required=true)
	private Integer resultsPerPage = null;
	@XmlElement(name="uri",required=true)
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	private URI uri = null;
	@XmlElement(name="did_you_mean",nillable=true)
	private String didYouMean = null;
	@XmlElementWrapper(name="regions")
	@XmlElement(name="region")
	private List<Region> regions = null;
	@XmlElementWrapper(name="locations")
	@XmlElement(name="location")
	private List<SearchLocation> locations = null;
	@XmlElementWrapper(name="histograms")
	@XmlElement(name="histogram")
	private List<Histogram> histograms = null;
	
	public Integer getFirstHit() {
		return firstHit;
	}
	public void setFirstHit(Integer firstHit) {
		this.firstHit = firstHit;
	}
	public Integer getLastHit() {
		return lastHit;
	}
	public void setLastHit(Integer lastHit) {
		this.lastHit = lastHit;
	}
	public Integer getTotalHits() {
		return totalHits;
	}
	public void setTotalHits(Integer totalHits) {
		this.totalHits = totalHits;
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
	public List<SearchLocation> getLocations() {
		return locations;
	}
	public void setLocations(List<SearchLocation> locations) {
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