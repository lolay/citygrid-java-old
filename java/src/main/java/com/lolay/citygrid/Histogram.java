package com.lolay.citygrid;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="histogram")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Histogram implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="name",required=true)
	private String name = null;
	@XmlElement(name="item",required=true)
	private List<HistogramItem> items = null;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<HistogramItem> getItems() {
		return items;
	}
	public void setItems(List<HistogramItem> items) {
		this.items = items;
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