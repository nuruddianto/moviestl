package com.example.nurud.moviestl.utility;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nurudianto on 12/27/2016.
 */
public class DateFormatter {
    private Date mReleaseDate;

    public DateFormatter(String dateInString) {
        SimpleDateFormat releaseSDF = new SimpleDateFormat("yyyy-MM-dd");
        releaseSDF.setLenient(false);
        try {
            mReleaseDate = releaseSDF.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String change(Context context) {
        SimpleDateFormat toFormat = new SimpleDateFormat("MMM dd, yyyy");
        toFormat.setLenient(false);
        return toFormat.format(mReleaseDate);
    }

    public boolean isReleased() {
        DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
        fromFormat.setLenient(false);

        Date currentDate = new Date();

        if (mReleaseDate.after(currentDate)) {
            return true;
        }
        return false;
    }

}
