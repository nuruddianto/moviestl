package com.example.nurud.moviestl.Utility;

import android.content.Context;

import com.example.nurud.moviestl.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SRIN on 12/27/2016.
 */
public class DateFormatter {

    private String mDateInString;

    public DateFormatter(String dateInString) {
        mDateInString = dateInString;
    }

    public String doFormat(Context context){
        DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
        fromFormat.setLenient(false);
        SimpleDateFormat toFormat = new SimpleDateFormat("MMM dd yyyy");
        toFormat.setLenient(false);

        try {
            Date date = fromFormat.parse(mDateInString);
            return toFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return context.getString(R.string.error_date_input_format);
    }
}
