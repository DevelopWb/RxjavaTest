package com.rxjavatest.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.rxjavatest.R;
import com.rxjavatest.test1.NetWorkinterface.GetRequest_Interface;
import com.rxjavatest.test1.Test1bean.Translation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main1Activity extends AppCompatActivity {

    private String TAG = "Main1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Observable.interval(2, 1, TimeUnit.SECONDS)
                // 参数说明：
                // 参数1 = 第1次延迟时间；
                // 参数2 = 间隔时间数字；
                // 参数3 = 时间单位；
                // 该例子发送的事件特点：延迟2s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）


                /*
                  * 步骤2：每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）
                  * 即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
                  **/

                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        //网络请求
                        Log.d(TAG, "wangluo");
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://fy.iciba.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .build();
                        GetRequest_Interface networkInterface = retrofit.create(GetRequest_Interface.class);
                        Observable<Translation> observable = networkInterface.getCall();
                        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Translation>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Translation value) {
                                value.show();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long value) {
                Log.d(TAG, value + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
