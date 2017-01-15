package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/29/2016.
 */
public class ProductionCompanies implements Parcelable {
    @SerializedName("name")
    private String mProuctionCompanyName;
    @SerializedName("id")
    private int mProductionCompanyId;

    public ProductionCompanies(Parcel parcel) {
        mProuctionCompanyName = parcel.readString();
        mProductionCompanyId = parcel.readInt();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mProuctionCompanyName);
        destination.writeInt(mProductionCompanyId);
    }

    public String getProuctionCompanyName() {
        return mProuctionCompanyName;
    }

    public void setProuctionCompanyName(String prouctionCompanyName) {
        this.mProuctionCompanyName = prouctionCompanyName;
    }

    public int getProductionCompanyId() {
        return mProductionCompanyId;
    }

    public void setProductionCompanyId(int productionCompanyId) {
        this.mProductionCompanyId = productionCompanyId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductionCompanies> CREATOR = new Creator<ProductionCompanies>() {
        @Override
        public ProductionCompanies createFromParcel(Parcel parcel) {
            return new ProductionCompanies(parcel);
        }

        @Override
        public ProductionCompanies[] newArray(int i) {
            return new ProductionCompanies[i];
        }
    };
}
