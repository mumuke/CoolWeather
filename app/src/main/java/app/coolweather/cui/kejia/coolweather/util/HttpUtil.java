package app.coolweather.cui.kejia.coolweather.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ckj on 2017/7/25.
 */

public class HttpUtil {
//    第一版的request
//    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection = null;
//                try {
//                    URL url = new URL(address);
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    InputStream is = connection.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//                    if (listener != null) {
//                        listener.onFinish(response.toString());
//                    }
//                } catch (Exception e) {
//                    if (listener != null) {
//                        listener.onError(e);
//                    }
//                } finally {
//                    if (connection != null) {
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }

    //    使用okHttp3 request
    public static void sendOkHttpRequest(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
