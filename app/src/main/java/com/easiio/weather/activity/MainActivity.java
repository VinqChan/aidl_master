package com.easiio.weather.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.easiio.weather.IWeatherAidlInterface;
import com.easiio.weather.R;


/**
 *  * Created by Echan on 2018/4/4.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mGetWeather;
    private TextView mWeatherContent;
    private IWeatherAidlInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListener();
        initService();
    }

    /**
     * 初始化服务
     */
    private void initService() {
        Bundle args = new Bundle();
        Intent intent = new Intent("com.easiio.WeatherService");
        intent.setPackage(getPackageName());
        intent.putExtras(args);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        mGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mService.getWeatherData();
                    mWeatherContent.setText( mService.getWeatherData());
                    Log.e(TAG, "onClick: "+ mService.getWeatherData());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        mGetWeather =  (Button)findViewById(R.id.bt_getweather);
        mWeatherContent =  (TextView) findViewById(R.id.tv_weather_content);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: " );
            mService = IWeatherAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected: " );
            mService = null;
        }
    };
}
