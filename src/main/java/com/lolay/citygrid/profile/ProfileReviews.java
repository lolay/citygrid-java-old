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

@XmlRootElement(name="review_info")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class ProfileReviews implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="overall_review_rating",required=true)
	private Integer overallReviewRating = null;
	@XmlElement(name="total_user_reviews",required=true)
	private Integer totalUserReviews = null;
	@XmlElement(name="total_user_reviews_shown",required=true)
	private Integer totalUserReviewsShown = null;
	@XmlElementWrapper(name="reviews")
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