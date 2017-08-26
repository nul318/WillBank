package com.willbank.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.willbank.R;

public class LoginActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Intent intent;
    ProgressDialog dialog;
    private void DialogProgress() { // 로그인 다이얼로그
        dialog = ProgressDialog.show(LoginActivity.this, "", "로그인 중입니다", true);
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        finish();
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                });
            }
        }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intent = new Intent(LoginActivity.this, HomeActivity.class);
        findViewById(R.id.login_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogProgress();
            }
        });

    }
}
