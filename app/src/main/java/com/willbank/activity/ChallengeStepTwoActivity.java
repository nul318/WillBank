package com.willbank.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.willbank.R;


public class ChallengeStepTwoActivity extends AppCompatActivity {
    EditText priceText;
    TextView startDate;
    TextView finishDate;
    TextView type;
    TextView contents;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_step2);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(priceText.getText().equals("")){
                    Toast.makeText(ChallengeStepTwoActivity.this, "항목을 채워주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(ChallengeStepTwoActivity.this, ChallengeStepThreeActivity.class);
                intent.putExtra("startDate", startDate.getText());
                intent.putExtra("finishDate", finishDate.getText());
                intent.putExtra("isTypeAClicked", getIntent().getBooleanExtra("isTypeAClicked", false));
                intent.putExtra("isTypeBClicked", getIntent().getBooleanExtra("isTypeBClicked", false));
                intent.putExtra("contents", contents.getText().toString());
                intent.putExtra("price", priceText.getText().toString());

                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                finish();
            }
        });
        priceText = (EditText) findViewById(R.id.price);

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



        priceText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChallengeStepTwoActivity.this);
                builder.setTitle("금액을 선택해 주세요");
                String[] price_list = {"5,000원", "10,000원", "30,000원", "50,000원", "100,000원"};
                builder.setItems(price_list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                priceText.setText("5,000원");
                                break;
                            case 1:
                                priceText.setText("10,000원");
                                break;
                            case 2:
                                priceText.setText("30,000원");
                                break;
                            case 3:
                                priceText.setText("50,000원");
                                break;
                            case 4:
                                priceText.setText("100,000원");
                                break;
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


}

