package app.coolweather.cui.kejia.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ckj on 2017/7/28.
 *
 * {
 *     "HeWeather":[
 *     {
 *         "status":"ok",
 *         "basic":{},
 *         "aqi":{},
 *         "now":{},
 *         "suggestion":{},
 *         "daily_forecast":[]
 *     }
 *     ]
 * }
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}

