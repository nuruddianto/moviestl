package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/29/2016.
 */
public class SpokenLanguage implements Parcelable {
    @SerializedName("iso_639_1")
    private String mIso639;
    @SerializedName("name")
    private String mSpokenLanguageName;

    public SpokenLanguage(Parcel parcel) {
        mIso639 = parcel.readString();
        mSpokenLanguageName = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mIso639);
        destination.writeString(mSpokenLanguageName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpokenLanguage> CREATOR = new Creator<SpokenLanguage>() {
        @Override
        public SpokenLanguage createFromParcel(Parcel parcel) {
            return new SpokenLanguage(parcel);
        }

        @Override
        public SpokenLanguage[] newArray(int i) {
            return new SpokenLanguage[i];
        }
    };
}
