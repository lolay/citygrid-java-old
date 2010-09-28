package com.lolay.citygrid;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="event")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="id",required=true)
	private String id = null;
	@XmlElement(name="name",required=true)
	private String name = null;
	@XmlElement(name="performances",required=true)
	private String performances = null;
	@XmlElement(name="userreviewcount",required=true)
	private String reviewsCount = null;
	@XmlElement(name="samplecategories")
	private String sampleCategories = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPerformances() {
		return performances;
	}
	public void setPerformances(String performances) {
		this.performances = performances;
	}
	public String getReviewsCount() {
		return reviewsCount;
	}
	public void setReviewsCount(String reviewsCount) {
		this.reviewsCount = reviewsCount;
	}
	public String getSampleCategories() {
		return sampleCategories;
	}
	public void setSampleCategories(String sampleCategories) {
		this.sampleCategories = sampleCategories;
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