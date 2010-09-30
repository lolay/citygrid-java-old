package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="urls")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Urls implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="profile_url",required=true)
	public URI profileUrl = null;
	@XmlElement(name="reviews_url",required=true)
	public URI reviewsUrl = null;
	@XmlElement(name="video_url",required=true)
	public URI videoUrl = null;
	@XmlElement(name="website_url",required=true)
	public URI websiteUrl = null;
	@XmlElement(name="menu_url",required=true)
	public URI menuUrl = null;
	@XmlElement(name="reservation_url",required=true)
	public URI reservationUrl = null;
	@XmlElement(name="map_url",required=true)
	public URI mapUrl = null;
	@XmlElement(name="send_to_friend_url",required=true)
	public URI sendToFriendUrl = null;
	@XmlElement(name="email_link",required=true)
	public URI email_link = null;
	@XmlElement(name="custom_link_1",required=true)
	public URI customLink1 = null;
	@XmlElement(name="custom_link_2",required=true)
	public URI customLink2 = null;
	
	public URI getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(URI profileUrl) {
		this.profileUrl = profileUrl;
	}
	public URI getReviewsUrl() {
		return reviewsUrl;
	}
	public void setReviewsUrl(URI reviewsUrl) {
		this.reviewsUrl = reviewsUrl;
	}
	public URI getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(URI videoUrl) {
		this.videoUrl = videoUrl;
	}
	public URI getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(URI websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public URI getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(URI menuUrl) {
		this.menuUrl = menuUrl;
	}
	public URI getReservationUrl() {
		return reservationUrl;
	}
	public void setReservationUrl(URI reservationUrl) {
		this.reservationUrl = reservationUrl;
	}
	public URI getMapUrl() {
		return mapUrl;
	}
	public void setMapUrl(URI mapUrl) {
		this.mapUrl = mapUrl;
	}
	public URI getSendToFriendUrl() {
		return sendToFriendUrl;
	}
	public void setSendToFriendUrl(URI sendToFriendUrl) {
		this.sendToFriendUrl = sendToFriendUrl;
	}
	public URI getEmail_link() {
		return email_link;
	}
	public void setEmail_link(URI email_link) {
		this.email_link = email_link;
	}
	public URI getCustomLink1() {
		return customLink1;
	}
	public void setCustomLink1(URI customLink1) {
		this.customLink1 = customLink1;
	}
	public URI getCustomLink2() {
		return customLink2;
	}
	public void setCustomLink2(URI customLink2) {
		this.customLink2 = customLink2;
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