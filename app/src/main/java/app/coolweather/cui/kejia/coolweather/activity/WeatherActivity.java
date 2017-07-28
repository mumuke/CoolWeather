package app.coolweather.cui.kejia.coolweather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import app.coolweather.cui.kejia.coolweather.R;

/**
 * Created by ckj on 2017/7/28.
 */

public class WeatherActivity extends AppCompatActivity {
    private ScrollView svWeather;
    private TextView tvTitleCity, tvUpdateTime, tvDegree, tvWeatherInfo, tvAqi, tvPm25, tvComfort, tvCarWash, tvSport;
    private LinearLayout llForecast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        svWeather = (ScrollView) findViewById(R.id.sv_weather);
        tvTitleCity = (TextView) findViewById(R.id.tv_city);
        tvUpdateTime = (TextView) findViewById(R.id.tv_update_time);
        tvDegree = (TextView) findViewById(R.id.tv_degree);
        tvWeatherInfo = (TextView) findViewById(R.id.tv_weather_info);
        tvAqi = (TextView) findViewById(R.id.tv_aqi);
        tvPm25 = (TextView) findViewById(R.id.tv_pm25);
        tvComfort = (TextView) findViewById(R.id.tv_comfort);
        tvCarWash = (TextView) findViewById(R.id.tv_car_wash);
        tvSport = (TextView) findViewById(R.id.tv_sport);
        llForecast = (LinearLayout) findViewById(R.id.ll_forecast);
    }
}
