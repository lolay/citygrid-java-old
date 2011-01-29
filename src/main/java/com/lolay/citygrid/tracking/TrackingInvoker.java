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
package com.lolay.citygrid.tracking;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.BaseInvoker;
import com.lolay.citygrid.InvokerException;

/**
 * @see http://developer.citygridmedia.com/docs/trackign
 * @see TrackingClient
 */
public class TrackingInvoker extends BaseInvoker {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(TrackingInvoker.class);

	private Long warningLimit = 10000L;
	private ActionTarget actionTarget = null;
	private Integer listingId = null;
	private Integer referenceId = null;
	private String publisher = null;
	private String impressionId = null;
	private String placement = null;
	private String mobileType = null;
	private String muid = null;
	private String sourcePhone = null;
	private String dialPhone = null;
	private String ua = null;
	
	public Long getWarningLimit() {
		return warningLimit;
	}
	public void setWarningLimit(Long warningLimit) {
		this.warningLimit = warningLimit;
	}
	public ActionTarget getActionTarget() {
		return actionTarget;
	}
	public void setActionTarget(ActionTarget actionTarget) {
		this.actionTarget = actionTarget;
	}
	public Integer getListingId() {
		return listingId;
	}
	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}
	public Integer getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getImpressionId() {
		return impressionId;
	}
	public void setImpressionId(String impressionId) {
		this.impressionId = impressionId;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	public String getMuid() {
		return muid;
	}
	public void setMuid(String muid) {
		this.muid = muid;
	}
	public String getSourcePhone() {
		return sourcePhone;
	}
	public void setSourcePhone(String sourcePhone) {
		this.sourcePhone = sourcePhone;
	}
	public String getDialPhone() {
		return dialPhone;
	}
	public void setDialPhone(String dialPhone) {
		this.dialPhone = dialPhone;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}
	
	public void impression(TrackingClient client) throws InvokerException {
		Long start = System.currentTimeMillis();

		client.impression(getActionTarget(), getListingId(), getReferenceId(), getPublisher(), getImpressionId(), getPlacement(), getMobileType(), getMuid(), getSourcePhone(), getDialPhone(), getUa());
		
		Long end = System.currentTimeMillis();
		Long diff = end - start;
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("CityGrid profile took %s milliseconds", diff));
		} else if (log.isWarnEnabled() && diff > getWarningLimit()) {
			log.warn(String.format("CityGrid profile took %s milliseconds which is longer than the threshold %s milliseconds", diff, getWarningLimit()));
		}
	}
	
	public static Builder builder(TrackingInvoker prototype) {
		return builder().warningLimit(prototype.getWarningLimit()).actionTarget(prototype.getActionTarget()).listingId(prototype.getListingId())
			.referenceId(prototype.getReferenceId()).publisher(prototype.getPublisher()).placement(prototype.getPlacement())
			.mobileType(prototype.getMobileType()).muid(prototype.getMuid()).ua(prototype.getUa());
	}
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements Serializable {
		private static final long serialVersionUID = 1L;

		private TrackingInvoker instance = new TrackingInvoker();
		private Builder() { }
		
		public Builder warningLimit(Long warningLimit) {
			instance.setWarningLimit(warningLimit);
			return this;
		}
		
		public Builder actionTarget(ActionTarget actionTarget) {
			instance.setActionTarget(actionTarget);
			return this;
		}
		
		public Builder listingId(Integer listingId) {
			instance.setListingId(listingId);
			return this;
		}
		
		public Builder referenceId(Integer referenceId) {
			instance.setReferenceId(referenceId);
			return this;
		}
		
		public Builder publisher(String publisher) {
			instance.setPublisher(publisher);
			return this;
		}
		
		public Builder impressionId(String impressionId) {
			instance.setImpressionId(impressionId);
			return this;
		}
		
		public Builder placement(String placement) {
			instance.setPlacement(placement);
			return this;
		}
		
		public Builder mobileType(String mobileType) {
			instance.setMobileType(mobileType);
			return this;
		}
		
		public Builder muid(String muid) {
			instance.setMuid(muid);
			return this;
		}
		
		public Builder sourcePhone(String sourcePhone) {
			instance.setSourcePhone(sourcePhone);
			return this;
		}
		
		public Builder dialPhone(String dialPhone) {
			instance.setDialPhone(dialPhone);
			return this;
		}
		
		public Builder ua(String ua) {
			instance.setUa(ua);
			return this;
		}
		
		public TrackingInvoker build() {
			return instance;
		}
	}
}