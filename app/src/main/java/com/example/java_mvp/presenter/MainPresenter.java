package com.example.java_mvp.presenter;

import com.example.java_mvp.model.MainInteractor;
import com.example.java_mvp.view.MainView;

public class MainPresenter implements MainInteractor.onFinish {

    MainView mainView;
    MainInteractor mainInteractor;

    public MainPresenter(MainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    public void getData() {
        mainInteractor.getDataFromServer(this);
        mainView.showLoading();
    }

    public void addCountToView(int currentCount) {
        mainView.showLoading();
        mainInteractor.addCountToView(this, currentCount);
    }

    @Override
    public void onSuccess(String namaSiswa) {
        mainView.hideLoading();
        mainView.onSuccess(namaSiswa);
    }

    @Override
    public void onError(String strError) {
        mainView.hideLoading();
        mainView.onError(strError);
    }

    @Override
    public void addCount(int additionalCoount) {
        mainView.hideLoading();
        mainView.addCount(additionalCoount);
    }
}
