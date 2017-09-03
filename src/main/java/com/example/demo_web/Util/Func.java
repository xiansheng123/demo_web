package com.example.demo_web.Util;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luxuda on 7/30/2017.
 */
public  class  Func {
    public static String  ConvertLongDate(Timestamp timestamp) {
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSZ");
        Date date = new Date(timestamp.getTime());
        return stf.format(date);
    }

    public static Timestamp convertTimeStamp(String time) {

        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        stf.setLenient(false);
        Timestamp timestamp = new Timestamp(stf.parse(time, new ParsePosition(0)).getTime());
        return timestamp;
    }
}
