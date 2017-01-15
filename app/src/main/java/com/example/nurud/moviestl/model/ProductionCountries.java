package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/29/2016.
 */
public class ProductionCountries implements Parcelable {
    @SerializedName("iso_3166_1")
    private String mIso3166;
    @SerializedName("name")
    private String mProductionCountriesName;

    public ProductionCountries(Parcel parcel) {
        mIso3166 = parcel.readString();
        mProductionCountriesName = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mIso3166);
        destination.writeString(mProductionCountriesName);
    }

    public String getIso3166() {
        return mIso3166;
    }

    public void setIso3166(String iso3166) {
        this.mIso3166 = iso3166;
    }

    public String getProductionCountriesName() {
        return mProductionCountriesName;
    }

    public void setProductionCountriesName(String productionCountriesName) {
        this.mProductionCountriesName = productionCountriesName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductionCountries> CREATOR = new Creator<ProductionCountries>() {
        @Override
        public ProductionCountries createFromParcel(Parcel parcel) {
            return new ProductionCountries(parcel);
        }

        @Override
        public ProductionCountries[] newArray(int i) {
            return new ProductionCountries[i];
        }
    };
}
