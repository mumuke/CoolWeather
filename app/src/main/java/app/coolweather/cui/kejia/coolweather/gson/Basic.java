package app.coolweather.cui.kejia.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ckj on 2017/7/28.
 *  地址和更新时间
 * "basic":{
 *     "city":"苏州",
 *     "id":"CN101190401",
 *     "update":{
 *         "log":"2016-08-08 21:58"
 *     }
 * }
 */

public class Basic {
//    @SerializedName()让JSON字段和Java字段之间建立映射关系
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
