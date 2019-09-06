package com.example.aleksav.memoreminderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddMemo extends AppCompatActivity implements View.OnClickListener{

    private static final int RB1_ID = 1;
    private static final int RB2_ID = 2;
    private static final int RB3_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);



        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        findViewById(R.id.radioButtonLow).setId(RB1_ID);
        findViewById(R.id.radioButtonMedium).setId(RB2_ID);
        findViewById(R.id.radioButtonHigh).setId(RB3_ID);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                addMemo();
                backToFirstIntent();
                break;
            case R.id.btnCancel:
                backToFirstIntent();
                break;
        }
    }

    private void addMemo() {

        int id = MemoApi.getLastMemoId();
        String name = ((EditText) findViewById(R.id.inputMemoName)).getText().toString();
        String text = ((EditText) findViewById(R.id.inputMemoText)).getText().toString();

        Memo.PRIORITY priority;
        RadioGroup radioGroup = ((RadioGroup) findViewById(R.id.inputMemoPriority));

        switch (radioGroup.getCheckedRadioButtonId()) {
            case 1:
                priority = Memo.PRIORITY.LOW;
                break;
            case 2:
                priority = Memo.PRIORITY.MEDIUM;
                break;
            case 3:
                priority = Memo.PRIORITY.HIGH;
                break;
            default:
                priority = Memo.PRIORITY.LOW;
                break;
        }

        DatePicker datePicker = (DatePicker) findViewById(R.id.inputMemoDate);

        String date = String.format("%4d -%2d -%2d", datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

        MemoApi.putMemo(new Memo(id, name, text, priority, false, date));


    }

    private void backToFirstIntent() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
