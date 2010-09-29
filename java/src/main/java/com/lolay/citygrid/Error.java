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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="error")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Error implements Serializable {
	public static final String QUERY_UNDERSPECIFIED = "query.underspecified";
	public static final String QUERY_TYPE_UNKNOWN = "query.type.unknown";
	public static final String QUERY_OVERSPECIFIED = "query.overspecified";
	public static final String GEOGRAPHY_UNDERSPECIFIED = "geography.underspecified";
	public static final String GEOGRAPHY_OVERSPECIFIED = "geography.ovespecified";
	public static final String RADIUS_REQUIRED = "radius.required";
	public static final String DATE_PAST = "date.past";
	public static final String DATE_RANGE_INCOMPLETE = "date.range.incomplete";
	public static final String DATE_RANGE_TOO_LONG = "date.range.to.long";
	public static final String GEOCODE_FAILURE = "geocode.failure";
	public static final String TAG_ILLEGAL = "tag.illegal";
	public static final String CHAIN_ILLEGAL = "chain.illegal";
	public static final String FIRST_ILLEGAL = "first.illegal";
	public static final String LATITUDE_ILLEGAL = "latitude.illegal";
	public static final String RADIUS_ILLEGAL = "radius.illegal";
	public static final String PAGE_ILLEGAL = "page.illegal";
	
	private static final long serialVersionUID = 1L;
	@XmlValue
	private String code = null;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ErrorCode getErrorCode() {
		return ErrorCode.fromCode(getCode());
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