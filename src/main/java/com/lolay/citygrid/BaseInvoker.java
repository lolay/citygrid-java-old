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