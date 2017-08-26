package com.willbank.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.willbank.R;

import java.util.Calendar;
import java.util.Locale;


public class ChallengeStepOneActivity extends AppCompatActivity {
    TextView startDate;
    TextView finishDate;
    boolean isStartDateClicked=false;
    boolean isFinishDateClicked=false;


    TextView typeA;
    TextView typeB;
    boolean isTypeAClicked=false;
    boolean isTypeBClicked=false;

    EditText contents;


    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_step1);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((isTypeAClicked == isTypeBClicked) || (contents.getText().toString().equals("")) || startDate.getText().equals("언제") ||  finishDate.getText().equals("언제") ){
                    Toast.makeText(ChallengeStepOneActivity.this, "항목을 채워주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(ChallengeStepOneActivity.this, ChallengeStepTwoActivity.class);
                intent.putExtra("startDate", startDate.getText());
                intent.putExtra("finishDate", finishDate.getText());
                intent.putExtra("isTypeAClicked", isTypeAClicked);
                intent.putExtra("isTypeBClicked", isTypeBClicked);
                intent.putExtra("contents", contents.getText().toString());

                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                finish();
            }
        });

        myCalendar = Calendar.getInstance();
        startDate = (TextView) findViewById(R.id.startDate);
        finishDate = (TextView) findViewById(R.id.finishDate);
        typeA = (TextView) findViewById(R.id.typeA);
        typeB = (TextView) findViewById(R.id.typeB);
        contents = (EditText) findViewById(R.id.contents);


        date = new DatePickerDialog.OnDateSetListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        startDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ChallengeStepOneActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                isStartDateClicked = true;
                isFinishDateClicked = false;
            }
        });
        finishDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ChallengeStepOneActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                isStartDateClicked = false;
                isFinishDateClicked = true;
            }
        });


        typeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeA.setTextColor(Color.WHITE);
                typeB.setTextColor(Color.argb(96,255,255,255));
                isTypeAClicked = true;
                isTypeBClicked = false;

            }
        });

        typeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeA.setTextColor(Color.argb(96,255,255,255));
                typeB.setTextColor(Color.WHITE);
                isTypeAClicked = false;
                isTypeBClicked = true;

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "M/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
        if(isFinishDateClicked){
            finishDate.setText(sdf.format(myCalendar.getTime()));

        }else if(isStartDateClicked){
            startDate.setText(sdf.format(myCalendar.getTime()));
        }

    }
}

