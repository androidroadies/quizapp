package com.example.kashyap.quizapplication;

/**
 * Created by kashyap on 15-11-04.
 */
public class QuizQuestions {
    private String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Answer;

    public QuizQuestions(String Question, String Option1, String Option2, String Option3, String Option4, String Answer){
        this.Question = Question;
        this.Option1 = Option1;
        this.Option2 = Option2;
        this.Option3 = Option3;
        this.Option4 = Option4;
        this.Answer = Answer;
    }

    public String getQuestion(){
        return Question;
    }

    public String getOption1(){
        return Option1;
    }

    public String getOption2(){
        return Option2;
    }

    public String getOption3(){
        return Option3;
    }

    public String getOption4(){
        return Option4;
    }

    public String getAnswer(){
        return Answer;
    }
}
