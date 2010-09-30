package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="customer_content")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class CustomerContent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="customer_message",required=true)
	private CustomerMessage customerMessage = null;
	@XmlElementWrapper(name="bullets")
	@XmlElement(name="bullet",required=true)
	private List<String> bullets = null;
	@XmlElement(name="customer_message",required=true)
	private URI customerMessageUrl = null;
	
	public CustomerMessage getCustomerMessage() {
		return customerMessage;
	}
	public void setCustomerMessage(CustomerMessage customerMessage) {
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