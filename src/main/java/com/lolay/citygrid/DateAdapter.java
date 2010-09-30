package com.lolay.citygrid;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String,Date> {
	private static final String format = "yyyy-MM-dd";
	
	@Override
	public Date unmarshal(String string) throws Exception {
		return new SimpleDateFormat(format).parse(string);
	}

	@Override
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(format).format(date);
	}
}