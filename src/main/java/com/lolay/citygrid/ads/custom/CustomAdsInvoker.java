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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.BaseInvoker;
import com.lolay.citygrid.Format;
import com.lolay.citygrid.InvokerException;

/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Custom+Ads+API
 * @see CustomAdsClient
 */
public class CustomAdsInvoker extends BaseInvoker {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(CustomAdsInvoker.class);

	private Long warningLimit = 10000L;
	private String what = null;
	private String where = null;
	private Double latitude = null;
	private Double longitude = null;
	private Integer radius = null;
	private String publisher = null;
	private String clientIp = null;
	private BannerSize size = null;
	private BannerTheme theme = null;
	private Integer max = null;
	private String placement = null;
	private Boolean rotation = null;
	private String impressionId = null;
	
	public Long getWarningLimit() {
		return warningLimit;
	}
	public void setWarningLimit(Long warningLimit) {
		this.warningLimit = warningLimit;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public BannerSize getSize() {
		return size;
	}
	public void setSize(BannerSize size) {
		this.size = size;
	}
	public BannerTheme getTheme() {
		return theme;
	}
	public void setTheme(BannerTheme theme) {
		this.theme = theme;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public Boolean getRotation() {
		return rotation;
	}
	public void setRotation(Boolean rotation) {
		this.rotation = rotation;
	}
	public String getImpressionId() {
		return impressionId;
	}
	public void setImpressionId(String impressionId) {
		this.impressionId = impressionId;
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
	
	public CustomAdsResults where(CustomAdsClient client) throws InvokerException {
		CustomAdsResults results;
		
		Long start = System.currentTimeMillis();
		
		results = parseResults(CustomAdsResults.class, client.where(getWhat(), getWhere(), getClientIp(), getRadius(), getImpressionId(), getPublisher(), getMax(), getPlacement()));
		
		Long end = System.currentTimeMillis();
		Long diff = end - start;
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("CityGrid PFP took %s milliseconds", diff));
		} else if (log.isWarnEnabled() && diff > getWarningLimit()) {
			log.warn(String.format("CityGrid PFP took %s milliseconds which is longer than the threshold %s milliseconds", diff, getWarningLimit()));
		}
		
		return results;
	}
	
	public CustomAdsResults latlon(CustomAdsClient client) throws InvokerException {
		CustomAdsResults results;
		
		Long start = System.currentTimeMillis();
		
		results = parseResults(CustomAdsResults.class, client.latlon(getWhat(), getClientIp(), getLatitude(), getLongitude(), getRadius(), getImpressionId(), getPublisher(), getMax(), getPlacement()));
		
		Long end = System.currentTimeMillis();
		Long diff = end - start;
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("CityGrid PFP location took %s milliseconds", diff));
		} else if (log.isWarnEnabled() && diff > getWarningLimit()) {
			log.warn(String.format("CityGrid PFP location took %s milliseconds which is longer than the threshold %s milliseconds", diff, getWarningLimit()));
		}
		
		return results;
	}
	
	public BannerResults banner(CustomAdsClient client) throws InvokerException {
		BannerResults results;
		
		Long start = System.currentTimeMillis();

		results = parseResults(BannerResults.class, client.banner(getWhat(), getWhere(), getLatitude(), getLongitude(),
			getRadius(), getPublisher(), getClientIp(), getSize(), Format.XML, getTheme(), getMax(), getPlacement(),
			getRotation()));
		
		Long end = System.currentTimeMillis();
		Long diff = end - start;
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("CityGrid PFP banner took %s milliseconds", diff));
		} else if (log.isWarnEnabled() && diff > getWarningLimit()) {
			log.warn(String.format("CityGrid PFP banner took %s milliseconds which is longer than the threshold %s milliseconds", diff, getWarningLimit()));
		}
		
		return results;
	}
	
	public static Builder builder(CustomAdsInvoker prototype) {
		return builder().warningLimit(prototype.getWarningLimit()).what(prototype.getWhat()).where(prototype.getWhere())
			.latitude(prototype.getLatitude()).longitude(prototype.getLongitude()).radius(prototype.getRadius())
			.publisher(prototype.getPublisher()).clientIp(prototype.getClientIp()).size(prototype.getSize())
			.theme(prototype.getTheme()).max(prototype.getMax()).placement(prototype.getPlacement())
			.rotation(prototype.getRotation()).impressionId(prototype.getImpressionId());
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements Serializable {
		private static final long serialVersionUID = 1L;

		private CustomAdsInvoker instance = new CustomAdsInvoker();
		private Builder() { }
		
		public Builder warningLimit(Long warningLimit) {
			instance.setWarningLimit(warningLimit);
			return this;
		}
		
		public Builder what(String what) {
			instance.setWhat(what);
			return this;
		}
		
		public Builder where(String where) {
			instance.setWhere(where);
			return this;
		}
		
		public Builder latitude(Double latitude) {
			instance.setLatitude(latitude);
			return this;
		}
		
		public Builder longitude(Double longitude) {
			instance.setLongitude(longitude);
			return this;
		}
		
		public Builder radius(Integer radius) {
			instance.setRadius(radius);
			return this;
		}
		
		public Builder publisher(String publisher) {
			instance.setPublisher(publisher);
			return this;
		}
		
		public Builder clientIp(String clientIp) {
			instance.setClientIp(clientIp);
			return this;
		}
		
		public Builder size(BannerSize size) {
			instance.setSize(size);
			return this;
		}
		
		public Builder theme(BannerTheme theme) {
			instance.setTheme(theme);
			return this;
		}
		
		public Builder max(Integer max) {
			instance.setMax(max);
			return this;
		}
		
		public Builder placement(String placement) {
			instance.setPlacement(placement);
			return this;
		}
		
		public Builder rotation(Boolean rotation) {
			instance.setRotation(rotation);
			return this;
		}
		
		public Builder impressionId(String impressionId) {
			instance.setImpressionId(impressionId);
			return this;
		}

		public CustomAdsInvoker build() {
			if (log.isDebugEnabled()) {
				log.debug(String.format("PfpInvoker=%s", instance));
			}
			return instance;
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
}