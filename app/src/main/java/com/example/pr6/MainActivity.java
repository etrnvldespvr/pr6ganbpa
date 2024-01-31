package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private TextView tvInfo;
private EditText eInput;
private Button bControl;
private int guess;
private int last;
private boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView1);
        eInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);
        guess = (int)(Math.random() * 100);
        gameFinished = false;
        last = 0;
    }

    public void onClick(View v) {
        Integer.parseInt(eInput.getText().toString());
        tvInfo.setText(getResources().getString(R.string.ahead));
        if (!gameFinished) {
            int inp=Integer.parseInt(eInput.getText().toString());
            if (inp > guess) {
                tvInfo.setText("Перелет!");
                eInput.setText("");
            }
            if (inp < guess) {
                tvInfo.setText("Недолет!");
                eInput.setText("");
            }
            if (inp == guess) {
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение:");
            eInput.setText("");
            tvInfo.setText("Попробуйте угадать число (1-100)");
            gameFinished = false;
        }

    }
}