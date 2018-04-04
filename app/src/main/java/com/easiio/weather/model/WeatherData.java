package com.easiio.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Vinchan on 2018/4/4.
 */
        public class WeatherData implements Parcelable {

            private Yesterday yesterday;
            private String city;
            private String aqi;
            private List<Forecast> forecast;
            private String ganmao;
            private String wendu;

    protected WeatherData(Parcel in) {
        city = in.readString();
        aqi = in.readString();
        forecast = in.createTypedArrayList(Forecast.CREATOR);
        ganmao = in.readString();
        wendu = in.readString();
    }

    public static final Creator<WeatherData> CREATOR = new Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel in) {
            return new WeatherData(in);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };

    public void setYesterday(Yesterday yesterday) {
                this.yesterday = yesterday;
            }
            public Yesterday getYesterday() {
                return yesterday;
            }

            public void setCity(String city) {
                this.city = city;
            }
            public String getCity() {
                return city;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
            public String getAqi() {
                return aqi;
            }

            public void setForecast(List<Forecast> forecast) {
                this.forecast = forecast;
            }
            public List<Forecast> getForecast() {
                return forecast;
            }

            public void setGanmao(String ganmao) {
                this.ganmao = ganmao;
            }
            public String getGanmao() {
                return ganmao;
            }

            public void setWendu(String wendu) {
                this.wendu = wendu;
            }
            public String getWendu() {
                return wendu;
            }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(aqi);
        dest.writeTypedList(forecast);
        dest.writeString(ganmao);
        dest.writeString(wendu);
    }
}