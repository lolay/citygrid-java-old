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
package com.lolay.citygrid.content.places.detail;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lolay.citygrid.DateAdapter;
import com.lolay.citygrid.UriAdapter;

@XmlRootElement(name="offer")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class DetailOffer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="offer_name",required=true)
	private String offerName = null;
	@XmlElement(name="offer_text",required=true)
	private String offerText = null;
	@XmlElement(name="offer_description",required=true)
	private String offerDescription = null;
	@XmlElement(name="offer_url",required=true)
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	private URI offerUrl = null;
	@XmlElement(name="offer_expiration_date",nillable=true)
	@XmlJavaTypeAdapter(value=DateAdapter.class)
	private Date offerExpirationDate = null;
	
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferText() {
		return offerText;
	}
	public void setOfferText(String offerText) {
		this.offerText = offerText;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public URI getOfferUrl() {
		return offerUrl;
	}
	public void setOfferUrl(URI offerUrl) {
		this.offerUrl = offerUrl;
	}
	public Date getOfferExpirationDate() {
		return offerExpirationDate;
	}
	public void setOfferExpirationDate(Date offerExpirationDate) {
		this.offerExpirationDate = offerExpirationDate;
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