package com.easiio.weather.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.easiio.weather.IWeatherAidlInterface;
import com.easiio.weather.model.WeatherModel;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;


import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Vinchan on 2018/4/4.
 * 获取天气数据
 */

public class WeatherService extends Service {
    private static final String TAG = "WeatherService";
    private String mWeatherData = "";

    @Override
    public void onCreate() {
        super.onCreate();
        getWeather();
    }

    private void getWeather(){
        OkHttpUtils
                .get()
                .url( "https://www.apiopen.top/weatherApi")
                .addParams("city", "厦门")
                .build()
                .execute(new WeatherResultCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                        mWeatherData = "请求失败！";
                    }

                    @Override
                    public void onResponse(WeatherModel response, int id) {
                        Log.d(TAG, "onResponse: "+response.getData().getCity());
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("City:"+response.getData().getCity())
                                .append("\n")
                                .append("date:"+response.getData().getForecast().get(0).getDate())
                                .append("\n")
                                .append("high:"+response.getData().getForecast().get(0).getHigh())
                                .append("\n")
                                .append("fengli:"+response.getData().getForecast().get(0).getFengli())
                                .append("\n")
                                .append("low:"+response.getData().getForecast().get(0).getLow())
                                .append("\n")
                                .append("fengxiang:"+response.getData().getForecast().get(0).getFengxiang())
                                .append("\n")
                                .append("type:"+response.getData().getForecast().get(0).getType());
                        mWeatherData = stringBuffer.toString();
                    }
                });
    }

    public abstract class  WeatherResultCallback extends Callback<WeatherModel>

    {
        @Override
        public WeatherModel parseNetworkResponse(Response response, int id) throws Exception {
            String result = response.body().string();
            WeatherModel weatherModel = new Gson().fromJson(result, WeatherModel.class);
            return weatherModel;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final  IWeatherAidlInterface.Stub mBinder = new IWeatherAidlInterface.Stub() {
        @Override
        public String getWeatherData() throws RemoteException {

            Log.e(TAG, "getWeatherData: "+mWeatherData );
            return mWeatherData;
        }
    };

}
