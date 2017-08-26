package com.willbank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.willbank.R;


public class ChallengeStepThreeActivity extends AppCompatActivity {
    TextView priceText;
    TextView startDate;
    TextView finishDate;
    TextView type;
    TextView contents;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_step3);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeStepThreeActivity.this, HomeActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }
        });

        priceText = (TextView) findViewById(R.id.price);

        startDate = (TextView) findViewById(R.id.startDate);
        finishDate = (TextView) findViewById(R.id.finishDate);
        type = (TextView) findViewById(R.id.type);
        contents = (TextView) findViewById(R.id.contents);

        startDate.setText(getIntent().getStringExtra("startDate"));
        finishDate.setText(getIntent().getStringExtra("finishDate"));

        if(getIntent().getBooleanExtra("isTypeAClicked", false)){
            type.setText("매일 ");
        }else if(getIntent().getBooleanExtra("isTypeBClicked", false)){
            type.setText("이 때까지");
        }



        contents.setText(getIntent().getStringExtra("contents"));
        priceText.setText(getIntent().getStringExtra("price"));
    }


}

