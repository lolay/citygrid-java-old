package com.lolay.citygrid;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="results")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SearchResults {
	@XmlAttribute(name="queryid",required=true)
	private String queryId = null;
	@XmlAttribute(name="firsthit",required=true)
	private Integer first = null;
	@XmlAttribute(name="lasthist",required=true)
	private Integer last = null;
	@XmlAttribute(name="totalhits",required=true)
	private Integer total = null;
	
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
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