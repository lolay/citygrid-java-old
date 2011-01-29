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

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lolay.citygrid.UriAdapter;

@XmlRootElement(name="ad")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class CustomAd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="id")
	private Integer id = null;
	@XmlElement(name="type",required=true)
	private String type = null;
	@XmlElement(name="impression_id",required=true)
	private String impressionId = null;
	@XmlElement(name="listing_id",nillable=true)
	private Integer listingId = null;
	@XmlElement(name="name",nillable=true)
	private String name = null;
	@XmlElement(name="street",nillable=true)
	private String street = null;
	@XmlElement(name="city",nillable=true)
	private String city = null;
	@XmlElement(name="state",nillable=true)
	private String state = null;
	@XmlElement(name="zip",nillable=true)
	private String zip = null;
	@XmlElement(name="latitude",nillable=true)
	private Double latitude = null;
	@XmlElement(name="longitude",nillable=true)
	private Double longitude = null;
	@XmlElement(name="phone",nillable=true)
	private String phone = null;
	@XmlElement(name="tagline",nillable=true)
	private String tagline = null;
	@XmlElement(name="description",nillable=true)
	private String description = null;
	@XmlElement(name="overall_review_rating",nillable=true)
	private Integer overallReviewRating = null;
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	@XmlElement(name="ad_destination_url",required=true)
	private URI adDestinationUrl = null;
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	@XmlElement(name="ad_display_url",required=true)
	private URI adDisplayUrl = null;
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	@XmlElement(name="ad_image_url")
	private URI adImageUrl = null;
	@XmlElement(name="gross_ppe",nillable=true)
	private Float grossPpe = null;
	@XmlElement(name="reviews",nillable=true)
	private Integer reviews = null;
	@XmlElement(name="offers",nillable=true)
	private String offers = null;
	@XmlElement(name="distance",nillable=true)
	private Double distance = null;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImpressionId() {
		return impressionId;
	}
	public void setImpressionId(String impressionId) {
		this.impressionId = impressionId;
	}
	public Integer getListingId() {
		return listingId;
	}
	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOverallReviewRating() {
		return overallReviewRating;
	}
	public void setOverallReviewRating(Integer overallReviewRating) {
		this.overallReviewRating = overallReviewRating;
	}
	public URI getAdDestinationUrl() {
		return adDestinationUrl;
	}
	public void setAdDestinationUrl(URI adDestinationUrl) {
		this.adDestinationUrl = adDestinationUrl;
	}
	public URI getAdDisplayUrl() {
		return adDisplayUrl;
	}
	public void setAdDisplayUrl(URI adDisplayUrl) {
		this.adDisplayUrl = adDisplayUrl;
	}
	public URI getAdImageUrl() {
		return adImageUrl;
	}
	public void setAdImageUrl(URI adImageUrl) {
		this.adImageUrl = adImageUrl;
	}
	public Float getGrossPpe() {
		return grossPpe;
	}
	public void setGrossPpe(Float grossPpe) {
		this.grossPpe = grossPpe;
	}
	public Integer getReviews() {
		return reviews;
	}
	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
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