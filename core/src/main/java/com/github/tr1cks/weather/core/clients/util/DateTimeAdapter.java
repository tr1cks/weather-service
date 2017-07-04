package com.github.tr1cks.weather.core.clients.util;

import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class DateTimeAdapter extends XmlAdapter<String, Date> {
    private static DateTimeFormatter fmt = ISODateTimeFormat.dateHourMinuteSecond().withZoneUTC();

    @Override public Date unmarshal(String dateTime) throws Exception { return fmt.parseDateTime(dateTime).toDate(); }

    @Override public String marshal(Date datetime) throws Exception { return fmt.print(new Instant(datetime)); }
}
