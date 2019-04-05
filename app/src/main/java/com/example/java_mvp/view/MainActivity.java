package com.example.java_mvp.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java_mvp.R;
import com.example.java_mvp.model.MainInteractor;
import com.example.java_mvp.presenter.MainPresenter;
import com.example.java_mvp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;

    ProgressDialog progressDialog;

    int currentCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Downloading");
        progressDialog.setMessage("Sedang Mengambil Data");
        progressDialog.setCancelable(false);

        mainPresenter = new MainPresenter(this, new MainInteractor());
        mainPresenter.getData();

        findViewById(R.id.bt_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.addCountToView(currentCount);
            }
        });
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess(String namaSiswa) {
        Toast.makeText(this, "Nama Siswa : " + namaSiswa, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String strError) {
        Toast.makeText(this, "Error : " + strError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addCount(int additionalCount) {
        TextView textView = findViewById(R.id.tv_count);
        textView.setText("" + additionalCount);

        currentCount ++;
    }
}
