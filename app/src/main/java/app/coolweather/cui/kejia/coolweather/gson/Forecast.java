package app.coolweather.cui.kejia.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ckj on 2017/7/28.
 *  预报
 * "daily_forecast":[
 *      {
 *          "date":"2016-08-08",
 *          "cond":{
 *              "txt_d":"阵雨"
 *          },
 *          "tmp":{
 *              "max":"34",
 *              "min":"27"
 *          }
 *      },
 *      {
 *          "date":"2016-08-09",
 *          "cond":{
 *              "txt_d":"多云"
 *          }
 *          "tmp":{
 *              "max":35",
 *              "min":29"
 *          }
 *      }
 *      `````
 *  ]
 *
 *
 */

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperture temperture;

    @SerializedName("cond")
    public More more;

    public class Temperture{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
