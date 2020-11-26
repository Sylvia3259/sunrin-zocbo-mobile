package com.example.sunrin_zocbo_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public int major = 0;
    public int year = 0;
    public int grade = 0;
    public int term = 0;
    public int exam = 0;

    MajorFragment majorFragment;
    GradeFragment gradeFragment;
    DetailFragment detailFragment;
    SubjectFragment subjectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        majorFragment = new MajorFragment();
        gradeFragment = new GradeFragment();
        detailFragment = new DetailFragment();
        subjectFragment = new SubjectFragment();

        changeFragment(0);
    }

    public void changeFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case 0: transaction.replace(R.id.container, majorFragment); break;
            case 1: transaction.replace(R.id.container, gradeFragment); break;
            case 2: transaction.replace(R.id.container, detailFragment); break;
            case 3: transaction.replace(R.id.container, subjectFragment); break;
        }
        if (index > 0) transaction.addToBackStack(null);
        transaction.commit();
    }
}