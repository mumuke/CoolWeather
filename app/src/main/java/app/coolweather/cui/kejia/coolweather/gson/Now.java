package app.coolweather.cui.kejia.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ckj on 2017/7/28.
 *  现在温度
 * "now":{
 *     "tmp":"29",
 *     "cond":{
 *         "txt":"阵雨"
 *     }
 * }
 */

public class Now {
    public String temperture;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
