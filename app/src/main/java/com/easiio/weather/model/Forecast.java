package com.easiio.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vinchan on 2018/4/4.
 */

public class Forecast implements Parcelable {

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    protected Forecast(Parcel in) {
        date = in.readString();
        high = in.readString();
        fengli = in.readString();
        low = in.readString();
        fengxiang = in.readString();
        type = in.readString();
    }

    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setHigh(String high) {
        this.high = high;
    }
    public String getHigh() {
        return high;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }
    public String getFengli() {
        return fengli;
    }

    public void setLow(String low) {
        this.low = low;
    }
    public String getLow() {
        return low;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }
    public String getFengxiang() {
        return fengxiang;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(high);
        dest.writeString(fengli);
        dest.writeString(low);
        dest.writeString(fengxiang);
        dest.writeString(type);
    }
}