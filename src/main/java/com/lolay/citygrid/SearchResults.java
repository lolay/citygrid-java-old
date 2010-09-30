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

/**
 * @see http://developer.citygridmedia.com/docs/search
 */
@XmlRootElement(name="results")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SearchResults implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="queryid")
	private String queryId = null;
	@XmlAttribute(name="firsthit",required=true)
	private Integer firstHit = null;
	@XmlAttribute(name="lasthit",required=true)
	private Integer lastHit = null;
	@XmlAttribute(name="totalhits",required=true)
	private Integer totalHits = null;
	@XmlElement(name="uri",required=true)
	private URI uri = null;
	@XmlElement(name="didyoumean")
	private String didYouMean = null;
	@XmlElement(name="region")
	private List<Region> regions = null;
	@XmlElement(name="location")
	private List<SearchLocation> locations = null;
	@XmlElement(name="engagement")
	private List<Engagement> engagements = null;
	@XmlElement(name="histogram")
	private List<Histogram> histograms = null;
	
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public Integer getFirst() {
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
	public void setTotal(Integer totalHits) {
		this.totalHits = totalHits;
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
	public List<Engagement> getEngagements() {
		return engagements;
	}
	public void setEngagements(List<Engagement> engagements) {
		this.engagements = engagements;
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