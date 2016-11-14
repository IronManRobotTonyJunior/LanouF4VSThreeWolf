package com.example.dllo.bibilala.search.scan;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    private Handler mHandler = new Handler();

    @Override
    public void handleResult(Result result) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ScanActivity.this, "扫描成功", Toast.LENGTH_SHORT).show();
                mScannerView.resumeCameraPreview(ScanActivity.this);
            }
        }, 2000);

    }
}
