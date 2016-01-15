package com.kim.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil { 
	
    /** The Constant ISO_DATETIME_PATTERN - per SOAPui 2003-11-10T02:56:46.123-05:00. */
    private static final String ISO_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
    
    /** The Constant ISO_FORMATTER. */
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormat.forPattern(ISO_DATETIME_PATTERN);
    
    /**
     * Gets a date value from an iso formatted date string
     *
     * @param isoString the date string
     * @return the date value
     * @throws Exception the exception
     */
    public static final Date getDateValueFromIsoString(String isoString) throws Exception {
        try { 
            DateTime isoDateTime = ISO_FORMATTER.parseDateTime(isoString);
            return isoDateTime.toDate();
        } catch (final Exception e) {
            String message = "Unable to parse input date [" + isoString + "] with ISO Date-Time Pattern";          
            throw new Exception(message);
        }
    }
}
