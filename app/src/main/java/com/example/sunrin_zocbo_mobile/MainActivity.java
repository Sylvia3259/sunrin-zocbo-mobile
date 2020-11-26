package com.example.sunrin_zocbo_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int major = 0;
    public int year = 0;
    public int grade = 0;
    public int term = 0;
    public int exam = 0;

    public ArrayList<Item> items = new ArrayList<>();

    private MajorFragment majorFragment;
    private GradeFragment gradeFragment;
    private DetailFragment detailFragment;
    private SubjectFragment subjectFragment;

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