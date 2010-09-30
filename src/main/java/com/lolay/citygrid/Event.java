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
	private String userReviewCount = null;
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
	public String getUserReviewCount() {
		return userReviewCount;
	}
	public void setUserReviewCount(String userReviewCount) {
		this.userReviewCount = userReviewCount;
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