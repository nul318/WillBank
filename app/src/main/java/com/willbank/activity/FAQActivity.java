package com.willbank.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.willbank.R;
import com.willbank.adapter.FAQAdapter;

import java.util.ArrayList;


public class FAQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        ArrayList<String> faqList = new ArrayList<>();
        faqList.add("도전기간을 늘릴수는 없나요?");
        faqList.add("도전을 포기하고 싶어요");
        faqList.add("커뮤니티는 무엇인가요?");
        faqList.add("리워드가 궁금해요");
        faqList.add("여러개의 도전을 관리할땐?");
        faqList.add("현금으로 돌려받고 싶어요");
        faqList.add("송금은 어떻게 하나요?");
        faqList.add("도전을 잠시 미루고 싶어요");
        faqList.add("그래프를 어떻게 보아야 하나요?");
        faqList.add("오프라인 서비스는 없나요?");
        faqList.add("도전기간을 늘릴수는 없나요?");
        faqList.add("도전을 포기하고 싶어요");
        faqList.add("커뮤니티는 무엇인가요?");
        faqList.add("리워드가 궁금해요");
        faqList.add("여러개의 도전을 관리할땐?");
        faqList.add("현금으로 돌려받고 싶어요");
        faqList.add("송금은 어떻게 하나요?");
        faqList.add("도전을 잠시 미루고 싶어요");
        faqList.add("그래프를 어떻게 보아야 하나요?");
        faqList.add("오프라인 서비스는 없나요?");


        FAQAdapter communityAdapter = new FAQAdapter(faqList, FAQActivity.this, R.layout.item_faq);

        ListView faqListView = (ListView) findViewById(R.id.faq_list_view);
        faqListView.setAdapter(communityAdapter);

    }




}

