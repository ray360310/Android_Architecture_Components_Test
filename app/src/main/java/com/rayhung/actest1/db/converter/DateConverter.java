package com.rayhung.actest1.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by rayhung on 2017/12/5.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}