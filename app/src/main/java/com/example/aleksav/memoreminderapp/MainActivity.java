package com.example.aleksav.memoreminderapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAddNewMemo).setOnClickListener(this);


        //MemoApi.addTestMemos();
        LinkedList<Memo> memoList = MemoApi.getMemos();

        LinearLayout mainView = (LinearLayout) findViewById(R.id.mainView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for ( Memo memo : memoList) {
            RelativeLayout item = (RelativeLayout) inflater.inflate(R.layout.my_view, null);
            item.findViewById(R.id.id).setId(memo.getId());


            ((TextView) item.findViewById(R.id.textViewMemoName)).setText(String.format("%1.45s", memo.getName()));
            ((TextView) item.findViewById(R.id.textViewMemoDate)).setText(memo.getDate());

            ImageView imagePrior = (ImageView) item.findViewById(R.id.imagePrior);

            item.findViewById(R.id.memo).setOnClickListener(this);

            switch (memo.getPriority()) {
                case LOW:
                    imagePrior.setImageResource(R.drawable.lowprior);
                    break;
                case MEDIUM:
                    imagePrior.setImageResource(R.drawable.medprior);
                    break;
                case HIGH:
                    imagePrior.setImageResource(R.drawable.highprior);
                    break;
            }

            mainView.addView(item);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddNewMemo:
                addNewMemo();
                break;
            case R.id.memo:
                RelativeLayout mm = findViewById(R.id.memo);
                View child = mm.getChildAt(0);
                int id = child.getId();
                openMemo(id);
                break;
        }
    }

    private void openMemo(int id) {
        Intent b = new Intent(this, MemoView.class);
        Bundle extra = new Bundle();
        extra.putInt("id", id);
        b.putExtras(extra);
        startActivity(b);
    }

    private void addNewMemo() {
        Intent i = new Intent(this, AddMemo.class);
        startActivity(i);
    }




}
