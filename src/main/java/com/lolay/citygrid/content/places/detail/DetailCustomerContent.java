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
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lolay.citygrid.UriAdapter;

@XmlRootElement(name="customer_content")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class DetailCustomerContent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="customer_message",required=true)
	private DetailCustomerMessage customerMessage = null;
	@XmlElementWrapper(name="bullets")
	@XmlElement(name="bullet",required=true)
	private List<String> bullets = null;
	@XmlElement(name="customer_message_url",required=true)
	@XmlJavaTypeAdapter(value=UriAdapter.class)
	private URI customerMessageUrl = null;
	
	public DetailCustomerMessage getCustomerMessage() {
		return customerMessage;
	}
	public void setCustomerMessage(DetailCustomerMessage customerMessage) {
		this.customerMessage = customerMessage;
	}
	public List<String> getBullets() {
		return bullets;
	}
	public void setBullets(List<String> bullets) {
		this.bullets = bullets;
	}
	public URI getCustomerMessageUrl() {
		return customerMessageUrl;
	}
	public void setCustomerMessageUrl(URI customerMessageUrl) {
		this.customerMessageUrl = customerMessageUrl;
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