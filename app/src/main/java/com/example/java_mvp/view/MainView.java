package com.example.java_mvp.view;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onSuccess(String namaSiswa);
    void onError(String strError);
    void addCount(int additionalCount);

}
