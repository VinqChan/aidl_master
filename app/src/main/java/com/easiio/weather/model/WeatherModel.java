package com.easiio.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vinchan on 2018/4/4.
 */

public class WeatherModel implements Parcelable {

        private int code;
        private String msg;
        private WeatherData data;

    protected WeatherModel(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<WeatherModel> CREATOR = new Creator<WeatherModel>() {
        @Override
        public WeatherModel createFromParcel(Parcel in) {
            return new WeatherModel(in);
        }

        @Override
        public WeatherModel[] newArray(int size) {
            return new WeatherModel[size];
        }
    };

    public void setCode(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }

        public void setData(WeatherData data) {
            this.data = data;
        }
        public WeatherData getData() {
            return data;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }
}