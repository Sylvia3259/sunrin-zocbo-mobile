package com.example.sunrin_zocbo_mobile;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MajorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CardView[] cardViews;

    public MajorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MajorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MajorFragment newInstance(String param1, String param2) {
        MajorFragment fragment = new MajorFragment();
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
        View view = inflater.inflate(R.layout.fragment_major, container, false);

        cardViews = new CardView[]{
                view.findViewById(R.id.major1),
                view.findViewById(R.id.major2),
                view.findViewById(R.id.major3),
                view.findViewById(R.id.major4),
        };

        CardView.OnClickListener onClickListener = new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if (mainActivity == null) return;
                for (int i = 0; i < cardViews.length; i++)
                    if (view.getId() == cardViews[i].getId())
                        mainActivity.major = i;
                mainActivity.changeFragment(1);
            }
        };

        for(CardView cardView : cardViews)
            cardView.setOnClickListener(onClickListener);

        return view;
    }
}