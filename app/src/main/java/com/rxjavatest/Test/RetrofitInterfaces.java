package com.rxjavatest.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Author:wang_sir
 * Time:2018/1/24 13:50
 * Description:This is RetrofitInterfaces
 */
public class RetrofitInterfaces {

    //通过get获取基站位置
    // http://api.haoservice.com/api/getlbs?mcc=460&mnc=0&cell_id=17984012&lac=4190&type=2&key=80bad67eb9bd4f3aa68b52f5d747c91b
    public interface JiZhanPosition{
      @GET ("{path}/getlbs?")
        Call<Position> getPosition(@Path("path") String path, @QueryMap Map<String,String> options);
    }

//通过post请求信标设备的位置，请求参数为键值对
    public interface  XinBiaoLocation{
        @FormUrlEncoded
        @POST("/WebService/GLService.asmx/GetMemberPositioningByImeis")
        Call<String> getPositionByPost(@Field("imeis") String options);
    }

    //通过post请求信标设备的位置,请求参数为json字符串
    public interface  XinBiaoLocation2{
        @POST("/WebService/GLService.asmx/GetMemberPositioningByImeis")
        Call<String> getPositionByPost(@Body Position position);
    }


    /**
     * 传一张图片,测试可以  图片上传的全路径eg:
     * http://gq.xun365.net/reuplf_exp.aspx?imei=20YJY2HA&createDate=20180129163455&lat=0.0&lng=0.0&type=0
     */
    public interface GaoQingTuChuanPost{
        @Multipart
        @POST("/reuplf_exp.aspx?")
        Call<ResponseBody> uploadImageFile(@QueryMap Map<String,String> map,
                                           @Part("pic\"; filename=\"image.png") RequestBody file);
    }
    /**
     * 传多张图片
     */
    public interface GaoQingTuChuanPostMore{
        @Multipart
        @POST("/reuplf_exp.aspx?")
        Call<Map<String, RequestBody>> uploadImageFiles(@QueryMap Map<String,String> map,
                @PartMap() Map<String, RequestBody> maps
        );
    }


    /**
     *
     * @param utcTime 2017-01-08 07:27:35
     * @return
     */
    public static String utc2Local(String utcTime) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");// UTC时间格式
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");// 当地时间格式
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

}
