package com.lolay.citygrid;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="engagement")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Engagement implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="event",required=true)
	private Event event = null;
	@XmlElement(name="location",required=true)
	private Location location = null;

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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