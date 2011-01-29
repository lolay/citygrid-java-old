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
package com.lolay.citygrid.profile;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@XmlRootElement(name="location")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class ProfileLocation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="id",required=true)
	private Integer id = null;
	@XmlElement(name="reference_id",required=true)
	private Integer referenceId = null;
	@XmlElement(name="impression_id",required=true)
	private String impressionId = null;
	@XmlElement(name="display_ad",required=true)
	private Boolean displayAd = null;
	@XmlElement(name="infousa_id",required=true)
	private Integer infoUsaId = null;
	@XmlElement(name="name",required=true)
	private String name = null;
	@XmlElement(name="teaser",required=true)
	private String teaser = null;
	@XmlElement(name="address",required=true)
	private ProfileAddress address = null;
	@XmlElement(name="contact_info",required=true)
	private ContactInfo contactInfo = null;
	@XmlElementWrapper(name="markets")
	@XmlElement(name="market")
	private List<String> markets = null;
	@XmlElementWrapper(name="neighborhoods")
	@XmlElement(name="neighborhood")
	private List<String> neighborhoods = null;
	@XmlElement(name="urls",required=true)
	private Urls urls = null;
	@XmlElement(name="customer_content",required=true)
	private CustomerContent customerContent = null;
	@XmlElementWrapper(name="offers")
	@XmlElement(name="offer")
	private List<Offer> offers = null;
	@XmlElementWrapper(name="categories")
	@XmlElement(name="category")
	private List<Category> categories = null;
	@XmlElementWrapper(name="attributes")
	@XmlElement(name="attribute")
	private List<Attribute> attributes = null;
	@XmlElement(name="business_hours",nillable=true)
	private String businessHours = null;
	@XmlElement(name="parking",nillable=true)
	private String parking = null;
	@XmlElementWrapper(name="tips")
	@XmlElement(name="tip")
	private List<Tip> tips = null;
	@XmlElementWrapper(name="images")
	@XmlElement(name="image")
	private List<Image> images = null;
	@XmlElementWrapper(name="editorials")
	@XmlElement(name="editorial")
	private List<Editorial> editorials = null;
	@XmlElement(name="reviews",required=true)
	private ProfileReviews reviews = null;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}
	public String getImpressionId() {
		return impressionId;
	}
	public void setImpressionId(String impressionId) {
		this.impressionId = impressionId;
	}
	public Boolean getDisplayAd() {
		return displayAd;
	}
	public void setDisplayAd(Boolean displayAd) {
		this.displayAd = displayAd;
	}
	public Integer getInfoUsaId() {
		return infoUsaId;
	}
	public void setInfoUsaId(Integer infoUsaId) {
		this.infoUsaId = infoUsaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeaser() {
		return teaser;
	}
	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}
	public ProfileAddress getAddress() {
		return address;
	}
	public void setAddress(ProfileAddress address) {
		this.address = address;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public List<String> getMarkets() {
		return markets;
	}
	public void setMarkets(List<String> markets) {
		this.markets = markets;
	}
	public List<String> getNeighborhoods() {
		return neighborhoods;
	}
	public void setNeighborhoods(List<String> neighborhoods) {
		this.neighborhoods = neighborhoods;
	}
	public Urls getUrls() {
		return urls;
	}
	public void setUrls(Urls urls) {
		this.urls = urls;
	}
	public CustomerContent getCustomerContent() {
		return customerContent;
	}
	public void setCustomerContent(CustomerContent customerContent) {
		this.customerContent = customerContent;
	}
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public List<Tip> getTips() {
		return tips;
	}
	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<Editorial> getEditorials() {
		return editorials;
	}
	public void setEditorials(List<Editorial> editorials) {
		this.editorials = editorials;
	}
	public ProfileReviews getReviews() {
		return reviews;
	}
	public void setReviews(ProfileReviews reviews) {
		this.reviews = reviews;
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