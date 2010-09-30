package com.lolay.citygrid;

import java.io.InputStream;
import java.io.Serializable;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseInvoker implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected static <T> T parseResults(Class<T> type, Response response) throws InvokerException {
		if (Response.Status.OK.getStatusCode() != response.getStatus()) {
			throw new RuntimeException(String.format("Can only parse a 200 response, the reponse was %s", response.getStatus()));
		}
		
		if (response.getEntity() != null && response.getEntity().getClass().equals(type)) {
			return type.cast(response.getEntity());
		} else if (response.getEntity() instanceof ErrorResults) {
			throw new InvokerException(ErrorResults.class.cast(response.getEntity()));
		} else if (response.getEntity() instanceof InputStream) {
			InputStream stream = InputStream.class.cast(response.getEntity());
			Object results = null; 
			try {
				JAXBContext context = JAXBContext.newInstance(type, ErrorResults.class);
				results = context.createUnmarshaller().unmarshal(stream);
			} catch (JAXBException e) {
				throw new RuntimeException("Problem unmarshalling the entity", e);
			}
			if (results != null && results.getClass().equals(type)) {
				return type.cast(results);
			} else {
				throw new InvokerException(ErrorResults.class.cast(results));
			}
		} else {
			throw new RuntimeException(String.format("Do not know how to parse %s", response.getEntity().getClass()));
		}
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