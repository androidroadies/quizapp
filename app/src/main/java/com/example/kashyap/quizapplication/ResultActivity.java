package com.example.kashyap.quizapplication;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.*;

public class ResultActivity extends AppCompatActivity implements OnClickListener {

    TextView tvGreet;
    TextView tvResult;
    TextView tvMessage;
    Button btnRetakeQuiz;
    Button btnQuit;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        gatherControl();
        getIntentDetails();
        showResult();
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;

        if (b.getId() == R.id.btnRetake){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        else if (b.getId() == R.id.btnQuit){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void getIntentDetails(){
        Result = getIntent().getExtras().getInt("Result");
    }

    private void showResult(){
        tvResult.setText("Your Result " + Result + "%");

        tvGreet.setText("Congratulations!!!");
        tvGreet.setTextColor(Color.GREEN);

        btnRetakeQuiz.setVisibility(View.GONE);
        btnQuit.setVisibility(View.VISIBLE);

        if (Result == 100){
            tvMessage.setText("Your are a Genuis!");
        }
        else if (Result == 80){
            tvMessage.setText("Excellent work!");
        }
        else if (Result == 60){
            tvMessage.setText("Good job!");
        }
        else if (Result < 60){
            tvMessage.setText("Please try again!");
            tvGreet.setText("Failed!!!");
            tvGreet.setTextColor(Color.RED);

            btnRetakeQuiz.setVisibility(View.VISIBLE);
            btnQuit.setVisibility(View.GONE);
        }
    }

    private void gatherControl() {
        tvGreet = (TextView) findViewById(R.id.tvGreet);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMessage = (TextView) findViewById(R.id.tvMessage);

        btnRetakeQuiz = (Button) findViewById(R.id.btnRetake);
        btnRetakeQuiz.setOnClickListener(this);

        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);
    }
}
