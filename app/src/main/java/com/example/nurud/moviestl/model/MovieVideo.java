package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/28/2016.
 */
public class MovieVideo implements Parcelable {
    @SerializedName("id")
    private String mViedoId;
    @SerializedName("iso_639_1")
    private String mIs0639;
    @SerializedName("iso_3166_1")
    private String mIso3166;
    @SerializedName("key")
    private String mVideoKey;
    @SerializedName("name")
    private String mVideoName;
    @SerializedName("site")
    private String mVideoSite;
    @SerializedName("size")
    private int mVideoSize;
    @SerializedName("type")
    private String mVideoType;


    public MovieVideo(Parcel parcel) {
        mViedoId = parcel.readString();
        mIs0639 = parcel.readString();
        mIso3166 = parcel.readString();
        mVideoKey = parcel.readString();
        mVideoName = parcel.readString();
        mVideoSite = parcel.readString();
        mVideoSize = parcel.readInt();
        mVideoType = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(mViedoId);
        destination.writeString(mIs0639);
        destination.writeString(mIso3166);
        destination.writeString(mVideoKey);
        destination.writeString(mVideoName);
        destination.writeString(mVideoSite);
        destination.writeInt(mVideoSize);
        destination.writeString(mVideoType);
    }

    public String getViedoId() {
        return mViedoId;
    }

    public void setViedoId(String mViedoId) {
        this.mViedoId = mViedoId;
    }

    public String getIs0639() {
        return mIs0639;
    }

    public void setIs0639(String mIs0639) {
        this.mIs0639 = mIs0639;
    }

    public String getIso3166() {
        return mIso3166;
    }

    public void setIso3166(String mIso3166) {
        this.mIso3166 = mIso3166;
    }

    public String getVideoKey() {
        return mVideoKey;
    }

    public void setVideoKey(String mVideoKey) {
        this.mVideoKey = mVideoKey;
    }

    public String getVideoName() {
        return mVideoName;
    }

    public void setVideoName(String mVideoName) {
        this.mVideoName = mVideoName;
    }

    public String getVideoSite() {
        return mVideoSite;
    }

    public void setVideoSite(String mVideoSite) {
        this.mVideoSite = mVideoSite;
    }

    public int getVideoSize() {
        return mVideoSize;
    }

    public void setVideoSize(int mVideoSize) {
        this.mVideoSize = mVideoSize;
    }

    public String getVideoType() {
        return mVideoType;
    }

    public void setVideoType(String mVideoType) {
        this.mVideoType = mVideoType;
    }

    public static final Creator<MovieVideo> CREATOR = new Creator<MovieVideo>() {
        @Override
        public MovieVideo createFromParcel(Parcel parcel) {
            return new MovieVideo(parcel);
        }

        @Override
        public MovieVideo[] newArray(int i) {
            return new MovieVideo[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
