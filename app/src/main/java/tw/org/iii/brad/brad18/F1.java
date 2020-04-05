package tw.org.iii.brad.brad18;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class F1 extends Fragment {
    private TextView lottery;
    private View view;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){                           //為了切換後仍能保留頁面上的東西,故不要讓他重置

            view = inflater.inflate(R.layout.fragment_f1, container, false);

            lottery = view.findViewById(R.id.page1_lottery);
            Button test1 = view.findViewById(R.id.page1_test1);
            test1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLottery();
                }
            });

            view.findViewById(R.id.page1_test2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.changeTitle("Cool Story Bro");
                }
            });
        }
        return view;
    }

    public void showLottery(){
        lottery.setText(""+(int)(Math.random()*49+1));
    }

    @Override
    public void onAttach(@NonNull Context context) { //此處的context是MainActivity
        super.onAttach(context);
        mainActivity = (MainActivity)context;

    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState) {         //有生命但活在 Activity 底下
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
}
