package com.lolay.citygrid;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FloatIntegerAdapter extends XmlAdapter<String,Integer> {
	@Override
	public String marshal(Integer value) throws Exception {
		if (value == null) {
			return null;
		}
		
		return value.toString();
	}

	@Override
	public Integer unmarshal(String value) throws Exception {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		Float floatValue = Float.parseFloat(value);
		return floatValue.intValue();
	}
}
