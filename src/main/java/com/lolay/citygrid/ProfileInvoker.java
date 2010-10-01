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

/**
 * @see http://developer.citygridmedia.com/docs/profile
 * @see ProfileClient
 */
public class ProfileInvoker extends BaseInvoker {
	private static final long serialVersionUID = 1L;
	
	private Integer listingId = null;
	private Integer infoUsaId = null;
	private String phone = null;
	private String publisher = null;
	private String apiKey = null;
	private Boolean customerOnly = null;
	private Boolean allResults = null;
	private Integer reviewCount = null;
	private String placement = null;
	private String clientIp = null;
	private Integer noLog = null;
	
	public Integer getListingId() {
		return listingId;
	}
	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}
	public Integer getInfoUsaId() {
		return infoUsaId;
	}
	public void setInfoUsaId(Integer infoUsaId) {
		this.infoUsaId = infoUsaId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Boolean getCustomerOnly() {
		return customerOnly;
	}
	public void setCustomerOnly(Boolean customerOnly) {
		this.customerOnly = customerOnly;
	}
	public Boolean getAllResults() {
		return allResults;
	}
	public void setAllResults(Boolean allResults) {
		this.allResults = allResults;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public Integer getNoLog() {
		return noLog;
	}
	public void setNoLog(Integer noLog) {
		this.noLog = noLog;
	}
	public ProfileResults profile(ProfileClient client) throws InvokerException {
		return parseResults(ProfileResults.class, client.profile(getListingId(), getInfoUsaId(),
			getPhone(), getPublisher(), getApiKey(), getCustomerOnly(), getAllResults(),
			getReviewCount(), getPlacement(), getClientIp(), Format.XML, getNoLog()));
	}
	
	public static Builder builder(ProfileInvoker prototype) {
		return builder().listingId(prototype.getListingId()).infoUsaId(prototype.getInfoUsaId())
			.phone(prototype.getPhone()).publisher(prototype.getPublisher())
			.apiKey(prototype.getApiKey()).customerOnly(prototype.getCustomerOnly())
			.allResults(prototype.getAllResults()).reviewCount(prototype.getReviewCount())
			.placement(prototype.getPlacement()).clientIp(prototype.getClientIp()).noLog(prototype.getNoLog());
	}
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements Serializable {
		private static final long serialVersionUID = 1L;

		private ProfileInvoker instance = new ProfileInvoker();
		private Builder() { }
		
		public Builder listingId(Integer listingId) {
			instance.setListingId(listingId);
			return this;
		}
		
		public Builder infoUsaId(Integer infoUsaId) {
			instance.setInfoUsaId(infoUsaId);
			return this;
		}
		
		public Builder phone(String phone) {
			instance.setPhone(phone);
			return this;
		}
		
		public Builder publisher(String publisher) {
			instance.setPublisher(publisher);
			return this;
		}
		
		public Builder apiKey(String apiKey) {
			instance.setApiKey(apiKey);
			return this;
		}
		
		public Builder customerOnly(Boolean customerOnly) {
			instance.setCustomerOnly(customerOnly);
			return this;
		}
		
		public Builder allResults(Boolean allResults) {
			instance.setAllResults(allResults);
			return this;
		}
		
		public Builder reviewCount(Integer reviewCount) {
			instance.setReviewCount(reviewCount);
			return this;
		}
		
		public Builder placement(String placement) {
			instance.setPlacement(placement);
			return this;
		}
		
		public Builder clientIp(String clientIp) {
			instance.setClientIp(clientIp);
			return this;
		}
		
		public Builder noLog(Integer noLog) {
			instance.setNoLog(noLog);
			return this;
		}
		
		public ProfileInvoker build() {
			return instance;
		}
	}
}