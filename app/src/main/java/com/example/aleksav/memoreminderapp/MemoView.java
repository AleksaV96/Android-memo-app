package com.example.aleksav.memoreminderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MemoView extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_view);

        Bundle extra = getIntent().getExtras();
        int id = extra.getInt("id");

        findViewById(R.id.deleteMemoBtn).setOnClickListener(this);
        findViewById(R.id.backBtn).setOnClickListener(this);

        LinkedList<Memo> memoList = MemoApi.getMemos();
        Memo openedMemo;

        openedMemo = null;
        for (Memo memo : memoList) {
            if (memo.id == id);
            openedMemo = memo;
        }

        TextView memoName = (TextView) findViewById(R.id.showMemoName);
        memoName.setText(openedMemo.getName());

        switch(openedMemo.getPriority()) {
            case LOW:
                memoName.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case MEDIUM:
                memoName.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case HIGH:
                memoName.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }

        TextView memoDate = (TextView)findViewById(R.id.showMemoDate);
        TextView memoText = (TextView)findViewById(R.id.showMemoText);

        memoDate.setText(openedMemo.getDate());
        memoText.setText(openedMemo.getText());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backBtn:
                goBack();
                break;
            case R.id.deleteMemoBtn:
                deleteMemo();
                break;
        }
    }

    public void deleteMemo(){
        Bundle extra = getIntent().getExtras();
        int id = extra.getInt("id");

        LinkedList<Memo> memoList = MemoApi.getMemos();
        ArrayList<Memo> deleteList = new ArrayList<>();

        for (Memo memo : memoList) {
            if (memo.id != id) {
                deleteList.add(memo);
            }
        }
        MemoApi.deleteList();

        for (Memo memo : deleteList) {
            memoList.add(memo);
        }
        goBack();
    }

    public void goBack(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
