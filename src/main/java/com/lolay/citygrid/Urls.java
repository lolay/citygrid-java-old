package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;
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
	public URI emailLink = null;
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
	public URI getAmmendedProfileUrl(Integer referenceId, String publisher) {
		return ammendUri(getProfileUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedProfileUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getProfileUrl(), referenceId, publisher, placement);
	}
	public URI getReviewsUrl() {
		return reviewsUrl;
	}
	public void setReviewsUrl(URI reviewsUrl) {
		this.reviewsUrl = reviewsUrl;
	}
	public URI getAmmendedReviewsUrl(Integer referenceId, String publisher) {
		return ammendUri(getReviewsUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedReviewsUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getReviewsUrl(), referenceId, publisher, placement);
	}
	public URI getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(URI videoUrl) {
		this.videoUrl = videoUrl;
	}
	public URI getAmmendedVideoUrl(Integer referenceId, String publisher) {
		return ammendUri(getVideoUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedVideoUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getVideoUrl(), referenceId, publisher, placement);
	}
	public URI getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(URI websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public URI getAmmendedWebsiteUrl(Integer referenceId, String publisher) {
		return ammendUri(getWebsiteUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedWebsiteUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getWebsiteUrl(), referenceId, publisher, placement);
	}
	public URI getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(URI menuUrl) {
		this.menuUrl = menuUrl;
	}
	public URI getAmmendedMenuUrl(Integer referenceId, String publisher) {
		return ammendUri(getMenuUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedMenuUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getMenuUrl(), referenceId, publisher, placement);
	}
	public URI getReservationUrl() {
		return reservationUrl;
	}
	public void setReservationUrl(URI reservationUrl) {
		this.reservationUrl = reservationUrl;
	}
	public URI getAmmendedReservationUrl(Integer referenceId, String publisher) {
		return ammendUri(getReservationUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedReservationUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getReservationUrl(), referenceId, publisher, placement);
	}
	public URI getMapUrl() {
		return mapUrl;
	}
	public void setMapUrl(URI mapUrl) {
		this.mapUrl = mapUrl;
	}
	public URI getAmmendedMapUrl(Integer referenceId, String publisher) {
		return ammendUri(getMapUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedMapUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getMapUrl(), referenceId, publisher, placement);
	}
	public URI getSendToFriendUrl() {
		return sendToFriendUrl;
	}
	public void setSendToFriendUrl(URI sendToFriendUrl) {
		this.sendToFriendUrl = sendToFriendUrl;
	}
	public URI getAmmendedSendToFriendUrl(Integer referenceId, String publisher) {
		return ammendUri(getSendToFriendUrl(), referenceId, publisher, null);
	}
	public URI getAmmendedSendToFriendUrl(Integer referenceId, String publisher, String placement) {
		return ammendUri(getSendToFriendUrl(), referenceId, publisher, placement);
	}
	public URI getEmailLink() {
		return emailLink;
	}
	public void setEmailLink(URI email_link) {
		this.emailLink = email_link;
	}
	public URI getAmmendedEmailLink(Integer referenceId, String publisher) {
		return ammendUri(getEmailLink(), referenceId, publisher, null);
	}
	public URI getAmmendedEmailLink(Integer referenceId, String publisher, String placement) {
		return ammendUri(getEmailLink(), referenceId, publisher, placement);
	}
	public URI getCustomLink1() {
		return customLink1;
	}
	public void setCustomLink1(URI customLink1) {
		this.customLink1 = customLink1;
	}
	public URI getAmmendedCustomLink1(Integer referenceId, String publisher) {
		return ammendUri(getCustomLink1(), referenceId, publisher, null);
	}
	public URI getAmmendedCustomLink1(Integer referenceId, String publisher, String placement) {
		return ammendUri(getCustomLink1(), referenceId, publisher, placement);
	}
	public URI getCustomLink2() {
		return customLink2;
	}
	public void setCustomLink2(URI customLink2) {
		this.customLink2 = customLink2;
	}
	public URI getAmmendedCustomLink2(Integer referenceId, String publisher) {
		return ammendUri(getCustomLink2(), referenceId, publisher, null);
	}
	public URI getAmmendedCustomLink2(Integer referenceId, String publisher, String placement) {
		return ammendUri(getCustomLink2(), referenceId, publisher, placement);
	}
	
	private URI ammendUri(URI uri, Integer referenceId, String publisher, String placement) {
		UriBuilder builder = UriBuilder.fromUri(uri);
		if (referenceId != null) {
			builder.queryParam("reference_id", referenceId);
		}
		if (publisher != null) {
			builder.queryParam("publisher", publisher);
		}
		if (placement != null) {
			builder.queryParam("placement", placement);
		}
		return builder.build();
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