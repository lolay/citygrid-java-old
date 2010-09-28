package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URL;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="location")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="id",required=true)
	private Long id = null;
	@XmlElement(name="featured",required=true)
	private Boolean featured = null;
	@XmlElement(name="name",required=true)
	private String name = null;
	@XmlElement(name="address",required=true)
	private Address address = null;
	@XmlElement(name="neighborhood")
	private String neighborhood = null;
	@XmlElement(name="latitude",required=true)
	private Double latitude = null;
	@XmlElement(name="longitude",required=true)
	private Double longitude = null;
	@XmlElement(name="image")
	private URL image = null;
	@XmlElement(name="phonenumber")
	private String phoneNumber = null;
	@XmlElement(name="rating")
	private Float rating = null;
	@XmlElement(name="profile",required=true)
	private URL profile = null;
	@XmlElement(name="hasvideo",required=true)
	private Boolean video = null;
	@XmlElement(name="hasoffers",required=true)
	private Boolean offers = null;
	@XmlElement(name="userreviewcount",required=true)
	private Integer reviewsCount = null;
	@XmlElement(name="samplecategories",required=true)
	private String sampleCategories = null;
	@XmlElement(name="tagline")
	private String tagline = null;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getFeatured() {
		return featured;
	}
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
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
	public URL getImage() {
		return image;
	}
	public void setImage(URL image) {
		this.image = image;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public URL getProfile() {
		return profile;
	}
	public void setProfile(URL profile) {
		this.profile = profile;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	public Boolean getOffers() {
		return offers;
	}
	public void setOffers(Boolean offers) {
		this.offers = offers;
	}
	public Integer getReviewsCount() {
		return reviewsCount;
	}
	public void setReviewsCount(Integer reviewsCount) {
		this.reviewsCount = reviewsCount;
	}
	public String getSampleCategories() {
		return sampleCategories;
	}
	public void setSampleCategories(String sampleCategories) {
		this.sampleCategories = sampleCategories;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
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