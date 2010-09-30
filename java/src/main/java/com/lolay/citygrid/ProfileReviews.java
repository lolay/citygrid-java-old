package com.lolay.citygrid;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="reviews")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class ProfileReviews implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="overall_review_rating",required=true)
	private Integer overallReviewRating = null;
	@XmlElement(name="total_user_reviews",required=true)
	private Integer totalUserReviews = null;
	@XmlElement(name="total_user_reviews_shown",required=true)
	private Integer totalUserReviewsShown = null;
	@XmlElement(name="review")
	private List<ProfileReview> reviews = null;
	
	public Integer getOverallReviewRating() {
		return overallReviewRating;
	}
	public void setOverallReviewRating(Integer overallReviewRating) {
		this.overallReviewRating = overallReviewRating;
	}
	public Integer getTotalUserReviews() {
		return totalUserReviews;
	}
	public void setTotalUserReviews(Integer totalUserReviews) {
		this.totalUserReviews = totalUserReviews;
	}
	public Integer getTotalUserReviewsShown() {
		return totalUserReviewsShown;
	}
	public void setTotalUserReviewsShown(Integer totalUserReviewsShown) {
		this.totalUserReviewsShown = totalUserReviewsShown;
	}
	public List<ProfileReview> getReviews() {
		return reviews;
	}
	public void setReviews(List<ProfileReview> reviews) {
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