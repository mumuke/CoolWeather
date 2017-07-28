package app.coolweather.cui.kejia.coolweather.gson;

/**
 * Created by ckj on 2017/7/28.
 * 空气质量
 * "aqi":{
 *     "city":{
 *         "aqi":"44",
 *         "pm25":"13"
 *     }
 * }
 */

public class AQI {
    public City city;

    public class City {
        public String aqi;
        public String pm25;
    }
}
