package com.rxjavatest.Test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.rxjavatest.R;
import com.rxjavatest.test1.Main1Activity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String key = "80bad67eb9bd4f3aa68b52f5d747c91b";
    public static String srcFilePath = "/storage/emulated/0/DCIM/Camera/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitInterfaces.utc2Local("2017-01-08 07:27:35");
//     String a = "[ZJ*589467020001673*0928*0005][ZJ*589467020001673]";
//        a.substring(a.lastIndexOf("["), a.length());
//        a.toString();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();

//        new BugSdkInit(getApplicationContext()).init("999");

//        getPositionThoughGet("460", "2", "64713", "29977", "2", key);
//        getPositionThoughPost("9106118032");

//        uploadImagePost();

//        uploadImagePostMore();
        startActivity(new Intent(this, Main1Activity.class));
    }


    /**
     * 这个接口请求返回数据失败是因为接口返回的数据不是标准的json格式，不能直接通过gson转换
     *
     * @param num
     */
    private void getPositionThoughPost(String num) {
        String url = "http://xb.xun365.net";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterfaces.XinBiaoLocation xinBiaoLocation = retrofit.create(RetrofitInterfaces.XinBiaoLocation.class);
        Call<String> call = xinBiaoLocation.getPositionByPost(num);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 请求基站的位置信息
     * @param mcc
     * @param mnc
     * @param cell_id
     * @param lac
     * @param type
     * @param key
     */
    private void getPositionThoughGet(String mcc, String mnc, String cell_id, String lac, String type, String key) {
        String url = "http://api.haoservice.com";
        Map<String, String> map = getQueryMap(mcc, mnc, cell_id, lac, type, key);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterfaces.JiZhanPosition jiZhanPosition = retrofit.create(RetrofitInterfaces.JiZhanPosition.class);
        Call<Position> call = jiZhanPosition.getPosition("/api", map);
        call.enqueue(new Callback<Position>() {
            @Override
            public void onResponse(Call<Position> call, Response<Position> response) {
                Position position = response.body();
                String a = position.getLocation().getAddressDescription();
                Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Position> call, Throwable t) {

            }
        });
    }

    @NonNull
    /**
     * 获取请求参数
     */
    private Map<String, String> getQueryMap(String mcc, String mnc, String cell_id, String lac, String type, String key) {
        Map<String, String> map = new HashMap<>();
        map.put("mcc", mcc);
        map.put("mnc", mnc);
        map.put("cell_id", cell_id);
        map.put("lac", lac);
        map.put("type", type);
        map.put("key", key);
        return map;
    }

//    public void uploadImage() {
//        Log.e("888888", getCurrentTime());
//        String url = "http://gq.xun365.net";
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RetrofitInterfaces.GaoQingTuChuan responseBody = retrofit.create(RetrofitInterfaces.GaoQingTuChuan.class);
//        Call<ResponseBody> responseBodyCall = responseBody.uploadImageFile(getRequestBody());
//        responseBodyCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.e("888888", getCurrentTime());
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("888888", getCurrentTime());
//            }
//        });
//
//    }

    /**
     * 传一个图片
     */
    public void uploadImagePost() {

        Log.e("888888", getCurrentTime());
        String url = "http://gq.xun365.net";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("imei", "20YJY2HA");
        map.put("createDate", "20180129163455");
        map.put("lat", "88.0");
        map.put("lng", "118.0");
        map.put("type", "0");
        RetrofitInterfaces.GaoQingTuChuanPost responseBody = retrofit.create(RetrofitInterfaces.GaoQingTuChuanPost.class);
        Call<ResponseBody> responseBodyCall = responseBody.uploadImageFile(map, getRequestBody());
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("888888", getCurrentTime());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("888888", getCurrentTime());
            }
        });

    }

    /**
     * 传多个图片
     */
    public void uploadImagePostMore() {

        Log.e("888888", getCurrentTime());
        String url = "http://gq.xun365.net";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("imei", "888888");
        map.put("createDate", "20180129163455");
        map.put("lat", "0.0");
        map.put("lng", "0.0");
        map.put("type", "0");
        RetrofitInterfaces.GaoQingTuChuanPostMore responseBody = retrofit.create(RetrofitInterfaces.GaoQingTuChuanPostMore.class);
        Call<Map<String, RequestBody>> responseBodyCall = responseBody.uploadImageFiles(map, getRequestBodys());
        responseBodyCall.enqueue(new Callback<Map<String, RequestBody>>() {
            @Override
            public void onResponse(Call<Map<String, RequestBody>> call, Response<Map<String, RequestBody>> response) {
                Log.e("888888", getCurrentTime());
            }

            @Override
            public void onFailure(Call<Map<String, RequestBody>> call, Throwable t) {

            }
        });
    }


    private Map<String, RequestBody> getRequestBodys() {
        Map<String, RequestBody> map = new HashMap<>();
        File[] files = new File(srcFilePath).listFiles();
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("multipart/form-data"), files[0]);
        map.put(files[0].getName(), requestBody);
        return map;
    }

    private RequestBody getRequestBody() {
        File[] files = new File(srcFilePath).listFiles();
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("multipart/form-data"), files[1]);
        return requestBody;
    }

    private String getCurrentTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }
}
