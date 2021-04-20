package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizapp.Common.Common;
import com.example.quizapp.Model.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Collections;

public class PlayActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
/*
public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    int i=0, score=0, thisQuestion=0,totalQuestion,correctAnswer;

    FirebaseDatabase database;
    DatabaseReference questions;
    ImageView question_image;
    Button buttonA,buttonB,buttonC,buttonD;
    TextView textScore,textQuestion,textTotalQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        database=FirebaseDatabase.getInstance();
        questions=FirebaseDatabase.getInstance().getReference("Questions");

        question_image=(ImageView)findViewById(R.id.question_image);
        textScore=(TextView)findViewById(R.id.textScore);
        textQuestion=(TextView)findViewById(R.id.question_text);
        textTotalQuestion=(TextView)findViewById(R.id.textTotalQuestion);

        buttonA=(Button)findViewById(R.id.buttonA);
        buttonB=(Button)findViewById(R.id.buttonB);
        buttonC=(Button)findViewById(R.id.buttonC);
        buttonD=(Button)findViewById(R.id.buttonD);


        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);

        loadQuestion(Common.categoryId);
    }

    private void loadQuestion(String categoryId) {

        // daca avem intrebari vechi in lista, le stergem
        if(Common.questionsList.size()>0)
            Common.questionsList.clear();

        questions.orderByChild("CategoryId").equalTo(categoryId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot postSnapshot : snapshot.getChildren()){
                            Questions ques=postSnapshot.getValue(Questions.class);
                            Common.questionsList.add(ques);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        Collections.shuffle(Common.questionsList);
    }



    @Override
    public void onClick(View v) {

        if(i < totalQuestion){ //inca mai sunt intrebari in lista

            Button clickButton=(Button)v;
            if(clickButton.getText().equals(Common.questionsList.get(i).getCorrectAnswer())){ //alegem raspunsul corect

                score+=1;
                correctAnswer++;
                showQuestion(++i); //trecem la urmatoarea intrebare

            }else{ //alegem raspunsul gresit
                Intent intent=new Intent(this,FinishActivity.class);
                Bundle dataSend=new Bundle();
                dataSend.putInt("Score",score);
                dataSend.putInt("Total",totalQuestion);
                dataSend.putInt("Correct",correctAnswer);
                intent.putExtras(dataSend);
                startActivity(intent);
                finish();

            }
            textScore.setText(String.format("%d",score));

        }

    }

    private void showQuestion(int i) {

        if(i < totalQuestion){
            thisQuestion++;
            textTotalQuestion.setText(String.format("%d/ %d",thisQuestion,totalQuestion));*/

            /*if(Common.questionsList.get(i).getIsImageQuestion().equals("true")){
                Picasso.with(getBaseContext())
                        .load(Common.questionsList.get(i).getQuestion())
                        .into(question_image);

            }*/
/*
            buttonA.setText(Common.questionsList.get(i).getAnswerA());
            buttonB.setText(Common.questionsList.get(i).getAnswerB());
            buttonC.setText(Common.questionsList.get(i).getAnswerC());
            buttonD.setText(Common.questionsList.get(i).getAnswerD());

        }else{ //daca e ultima intrebare
            Intent intent=new Intent(this,FinishActivity.class);
            Bundle dataSend=new Bundle();
            dataSend.putInt("Score",score);
            dataSend.putInt("Total",totalQuestion);
            dataSend.putInt("Correct",correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();

        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        totalQuestion=Common.questionsList.size();
        showQuestion(i);
    }*/
}