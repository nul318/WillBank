package com.willbank.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.willbank.R;

public class ChatActivity extends AppCompatActivity {
    ImageView msg_1;
    ImageView msg_2;
    ImageView msg_3;
    ImageView msg_4;
    ImageView msg_5;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        handler = new Handler();
        msg_1 = (ImageView) findViewById(R.id.msg_1);
        msg_2 = (ImageView) findViewById(R.id.msg_2);
        msg_3 = (ImageView) findViewById(R.id.msg_3);
        msg_4 = (ImageView) findViewById(R.id.msg_4);
        msg_5 = (ImageView) findViewById(R.id.msg_5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                setVisible(msg_1);
                setVisible(msg_2);
                setVisible(msg_3);
                setVisible(msg_4);
                setVisible(msg_5);
            }
        }).start();

    }

    public void setVisible(final ImageView msg){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                msg.setVisibility(View.VISIBLE);

            }
        });


    }

}
