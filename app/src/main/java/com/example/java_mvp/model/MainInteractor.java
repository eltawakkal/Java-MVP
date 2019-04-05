package com.example.java_mvp.model;

import android.os.CountDownTimer;

public class MainInteractor{

    public interface onFinish {
        void onSuccess(String namaSiswa);
        void onError(String strError);
        void addCount(int additionalCoount);
    }

    public void addCountToView(onFinish onFinish, int currentCount) {
        onFinish.addCount(currentCount);
    }

    public void getDataFromServer(final onFinish onFinish) {
        /*Transaksi retrofit*/
//        onSuccessListener
//        onFinish.onSuccess("Faturrahman");
//        onErrorListener
//        onFinish.onError("Kesalahan Terjadi");

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                onFinish.onSuccess("Faturrahman");
            }
        }.start();
    }



}
