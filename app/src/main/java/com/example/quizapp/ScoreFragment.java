package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ScoreFragment extends Fragment {

    View myFragment;

    public static ScoreFragment newInstance(){
        ScoreFragment scoreFragment=new ScoreFragment();
        return scoreFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment=inflater.inflate(R.layout.fragment_score,container,false);

        return myFragment;
    }

}