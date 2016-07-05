package com.example.kashyap.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.*;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView tvSrNo;
    TextView tvQuestions;
    Button btnOption1;
    Button btnOption2;
    Button btnOption3;
    Button btnOption4;
    Button btnSubmit;

    TextView tvCorrect;
    TextView tvIncorrect;

    int indexQues = 0;
    ArrayList<Integer> arrRandNos = new ArrayList<Integer>();
    ArrayList<QuizQuestions> arrQuizQuestions = new ArrayList<QuizQuestions>();
    String Answer;
    String optionSelected = "";
    int correctAns = 0;
    int incorrectAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gatherControl();
        getRandomNos();
        makeQuizQuestions();
        loadQuestions();
    }

    @Override
    public void onClick(View v) {

        Button b = (Button)v;
        if (b.getId() == R.id.btnOption1 || b.getId() == R.id.btnOption2 || b.getId() == R.id.btnOption3
                || b.getId() == R.id.btnOption4){
            optionSelected = setButtonSelected(b);
        }
        else if(b.getId() == R.id.btnSubmit){
            if (!optionSelected.isEmpty()) {
                if (optionSelected == Answer) {
                    correctAns++;
                }
                else{
                    incorrectAns++;
                }

                tvCorrect.setText(Integer.toString(correctAns));
                tvIncorrect.setText(Integer.toString(incorrectAns));

                if (indexQues < 5) {
                    loadQuestions();
                } else {
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("Result", correctAns * 100 / 5);
                    startActivity(i);
                }
                optionSelected = "";
            }
            else{
                Toast.makeText(MainActivity.this, "Please select one option.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void gatherControl(){
        tvSrNo = (TextView)findViewById(R.id.tvSrNo);
        tvQuestions = (TextView)findViewById(R.id.tvQuestions);

        tvCorrect = (TextView)findViewById(R.id.tvCountCorrect);
        tvIncorrect = (TextView)findViewById(R.id.tvCountIncorrect);

        btnOption1 = (Button)findViewById(R.id.btnOption1);
        btnOption1.setOnClickListener(this);

        btnOption2 = (Button)findViewById(R.id.btnOption2);
        btnOption2.setOnClickListener(this);

        btnOption3 = (Button)findViewById(R.id.btnOption3);
        btnOption3.setOnClickListener(this);

        btnOption4 = (Button)findViewById(R.id.btnOption4);
        btnOption4.setOnClickListener(this);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    private void getRandomNos(){
        arrRandNos.clear();

        for (int i = 0; arrRandNos.size() < 5; i++) {
            Random r = new Random();
            int val = r.nextInt(10);
            if (!arrRandNos.contains(val)) {
                arrRandNos.add(val);
            }
        }

    }

    private String setButtonSelected(Button b){

        String optionSelected = "";

        btnOption1.setBackgroundResource(R.drawable.unselected_border);
        btnOption2.setBackgroundResource(R.drawable.unselected_border);
        btnOption3.setBackgroundResource(R.drawable.unselected_border);
        btnOption4.setBackgroundResource(R.drawable.unselected_border);

        if(b.getId() == R.id.btnOption1){
            btnOption1.setBackgroundResource(R.drawable.selected_border);
            optionSelected = btnOption1.getText().toString();
        }
        else if(b.getId() == R.id.btnOption2){
            btnOption2.setBackgroundResource(R.drawable.selected_border);
            optionSelected = btnOption2.getText().toString();
        }
        else if(b.getId() == R.id.btnOption3){
            btnOption3.setBackgroundResource(R.drawable.selected_border);
            optionSelected = btnOption3.getText().toString();
        }
        else if(b.getId() == R.id.btnOption4){
            btnOption4.setBackgroundResource(R.drawable.selected_border);
            optionSelected = btnOption4.getText().toString();
        }

        return optionSelected;
    }

    private void makeQuizQuestions(){

        QuizQuestions objQuizQuestions = new QuizQuestions("Who invented microprocessor?",
                "Joseph Jacquard","Herman H Goldstein","Marcian E Huff","George Boole","Marcian E Huff");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Who built the world's first binary digit computer?",
                "Alan Turing","Konrad Zuse","George Boole","Ken Thompson","Konrad Zuse");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Which company created the most used networking software in 1980's?",
                "Sun","IBM","Novell","Microsoft","Novell");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("In what year was the @ chosen for its use in email address?",
                "1972","1976","1980","1984","1972");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Which one is the first search engine?",
                "Google","Archie","Altavista","WAIS","Archie");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("How many number of bit is used by the IPv6 address?",
                "32 bit","64 bit","128 bit","256 bit","128 bit");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Which one is the first web browser invented in 1990?",
                "Internet Explorer","Mosaic","Mozilla","WorldWideWeb","WorldWideWeb");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("First computer virus is known as",
                "Rabbit","Creeper Virus","Elk Cloner","SCA Virus","Creeper Virus");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Which one programming language is exclusively used for artificial intelligence?",
                "C","Java","J2EE","Prolog","Prolog");
        arrQuizQuestions.add(objQuizQuestions);

        objQuizQuestions = new QuizQuestions("Who developed Yahoo?",
                "Dennis Ritchie & Ken Thompson","David Filo & Jerry Yang","Vint Cerf & Robert Kahn","Steve Case & Jeff Bezos","David Filo & Jerry Yang");
        arrQuizQuestions.add(objQuizQuestions);
    }

    private void loadQuestions(){

        btnOption1.setBackgroundResource(R.drawable.unselected_border);
        btnOption2.setBackgroundResource(R.drawable.unselected_border);
        btnOption3.setBackgroundResource(R.drawable.unselected_border);
        btnOption4.setBackgroundResource(R.drawable.unselected_border);

        tvSrNo.setText(Integer.toString(indexQues+1));
        tvQuestions.setText(arrQuizQuestions.get(arrRandNos.get(indexQues)).getQuestion());
        btnOption1.setText(arrQuizQuestions.get(arrRandNos.get(indexQues)).getOption1());
        btnOption2.setText(arrQuizQuestions.get(arrRandNos.get(indexQues)).getOption2());
        btnOption3.setText(arrQuizQuestions.get(arrRandNos.get(indexQues)).getOption3());
        btnOption4.setText(arrQuizQuestions.get(arrRandNos.get(indexQues)).getOption4());
        Answer = arrQuizQuestions.get(arrRandNos.get(indexQues)).getAnswer();

        indexQues++;
    }
}
