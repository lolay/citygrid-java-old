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
public class BannerAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name="id",required=true)
	private Integer id = null;
	
	@XmlElement(name="listingId",required=true)
	private Integer listingId = null;

	@XmlJavaTypeAdapter(value=UriAdapter.class)
	@XmlElement(name="ad_destination_url",required=true)
	private URI adDestinationUrl = null;

	@XmlJavaTypeAdapter(value=UriAdapter.class)
	@XmlElement(name="ad_image_url",required=true)
	private URI adImageUrl = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getListingId() {
		return listingId;
	}

	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}

	public URI getAdDestinationUrl() {
		return adDestinationUrl;
	}

	public void setAdDestinationUrl(URI adDestinationUrl) {
		this.adDestinationUrl = adDestinationUrl;
	}

	public URI getAdImageUrl() {
		return adImageUrl;
	}

	public void setAdImageUrl(URI adImageUrl) {
		this.adImageUrl = adImageUrl;
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