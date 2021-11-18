package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentOnAttachListener;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class SignupActivity extends AppCompatActivity {
    public static final int INPUT_MODE_NAME = 0;
    public static final int INPUT_MODE_ID = 1;
    public static final int INPUT_MODE_PASSWORD = 2;
    public static final int INPUT_MODE_PASSWORD_CHECK = 3;

    private int inputMode = INPUT_MODE_NAME;
    private String[] inputs = { "", "", "", "" };

    private TextView messageView;
    private EditText input;
    private TextView nextButton;
    private TextView nextButtonOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        messageView = findViewById(R.id.message);
        input = findViewById(R.id.input);
        nextButton = findViewById(R.id.next);
        nextButtonOff = findViewById(R.id.nextOff);

        init();
        bindEvents();
    }

    private void nextInputMode() {
        inputs[inputMode] = input.getText().toString().trim();

        if(inputMode == INPUT_MODE_NAME) inputMode = INPUT_MODE_ID;
        else if(inputMode == INPUT_MODE_ID) inputMode = INPUT_MODE_PASSWORD;
        else if(inputMode == INPUT_MODE_PASSWORD) inputMode = INPUT_MODE_PASSWORD_CHECK;
        else if(inputMode == INPUT_MODE_PASSWORD_CHECK) {
            ApiManager.signup(inputs[INPUT_MODE_NAME], inputs[INPUT_MODE_ID], inputs[INPUT_MODE_PASSWORD], success -> {
                if(success) Util.startActivity(this, SignupCompleatActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);
                else Util.toast(this, "사용이 불가능한 아이디 입니다.", false);
            });
        }

        init();
    }

    private void previousInputMode() {
        if(inputMode == INPUT_MODE_NAME) finish();
        else if(inputMode == INPUT_MODE_ID) inputMode = INPUT_MODE_NAME;
        else if(inputMode == INPUT_MODE_PASSWORD) inputMode = INPUT_MODE_ID;
        else if(inputMode == INPUT_MODE_PASSWORD_CHECK) inputMode = INPUT_MODE_PASSWORD;

        init();
    }

    private void init() {
        String[] messages = { "이름을 입력해주세요", "아이디를 입력해주세요", "비밀번호를 입력해주세요", "비밀번호를 확인하세요" };
        String[] hints = { "이름", "아이디", "비밀번호", "비밀번호" };

        messageView.setText(messages[inputMode]);
        input.setHint(hints[inputMode]);
        input.setText(inputs[inputMode]);
    }

    private void bindEvents() {
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = input.getText().toString().trim();

                if(inputMode == INPUT_MODE_PASSWORD_CHECK) showNextButton(str.equals(inputs[INPUT_MODE_PASSWORD]));
                else showNextButton(!str.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.previous).setOnClickListener(v -> previousInputMode());

        nextButton.setOnClickListener(v -> nextInputMode());
    }

    private void showNextButton(boolean visibility) {
        nextButton.setVisibility(visibility ? View.VISIBLE : View.GONE);
        nextButtonOff.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }
}