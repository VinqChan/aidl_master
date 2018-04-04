package com.easiio.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vinchan on 2018/4/4.
 */

    public class Yesterday  implements Parcelable {

        private String date;
        private String high;
        private String fx;
        private String low;
        private String fl;
        private String type;

    protected Yesterday(Parcel in) {
        date = in.readString();
        high = in.readString();
        fx = in.readString();
        low = in.readString();
        fl = in.readString();
        type = in.readString();
    }

    public static final Creator<Yesterday> CREATOR = new Creator<Yesterday>() {
        @Override
        public Yesterday createFromParcel(Parcel in) {
            return new Yesterday(in);
        }

        @Override
        public Yesterday[] newArray(int size) {
            return new Yesterday[size];
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

        public void setFx(String fx) {
            this.fx = fx;
        }
        public String getFx() {
            return fx;
        }

        public void setLow(String low) {
            this.low = low;
        }
        public String getLow() {
            return low;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }
        public String getFl() {
            return fl;
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
        dest.writeString(fx);
        dest.writeString(low);
        dest.writeString(fl);
        dest.writeString(type);
    }
}