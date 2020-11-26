package com.example.sunrin_zocbo_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        NumberPicker yearPicker = view.findViewById(R.id.yearPicker);
        NumberPicker termPicker = view.findViewById(R.id.termPicker);
        NumberPicker examPicker = view.findViewById(R.id.examPicker);

        yearPicker.setMinValue(0);
        yearPicker.setMaxValue(2);
        yearPicker.setDisplayedValues( new String[] { "2018년", "2019년", "2020년" } );

        termPicker.setMinValue(0);
        termPicker.setMaxValue(1);
        termPicker.setDisplayedValues( new String[] { "1학기", "2학기" } );

        examPicker.setMinValue(0);
        examPicker.setMaxValue(1);
        examPicker.setDisplayedValues( new String[] { "중간고사", "기말고사" } );

        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if (mainActivity == null) return;
                mainActivity.year = i1;
            }
        });

        termPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if (mainActivity == null) return;
                mainActivity.term = i1;
            }
        });

        examPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if (mainActivity == null) return;
                mainActivity.exam = i1;
            }
        });

        view.findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MainActivity mainActivity = (MainActivity)getActivity();
                if (mainActivity == null) return;

                String[] majorText = new String[] { "정보보호과", "소프트웨어과", "아이티경영과", "콘텐츠디자인과" };
                String[] yearText = new String[] { "2018년", "2019년", "2020년" };
                String[] gradeText = new String[] { "1학년", "2학년", "3학년" };
                String[] termText = new String[] { "1학기", "2학기" };
                String[] examText = new String[] { "중간고사", "기말고사" };

                String[] data = new String[] {
                        majorText[mainActivity.major],
                        yearText[mainActivity.year],
                        gradeText[mainActivity.grade],
                        termText[mainActivity.term],
                        examText[mainActivity.exam]
                };

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("exams")
                        .whereEqualTo("major", data[0])
                        .whereEqualTo("year", data[1])
                        .whereEqualTo("grade", data[2])
                        .whereEqualTo("term", data[3])
                        .whereEqualTo("exam", data[4])
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful())
                                    for (QueryDocumentSnapshot document : task.getResult())
                                        mainActivity.items.add(new Item(document.getData()));
                                mainActivity.changeFragment(3);
                            }
                        });
            }
        });

        return view;
    }
}