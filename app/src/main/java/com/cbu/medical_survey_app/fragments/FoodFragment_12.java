package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class FoodFragment_12 extends Fragment {

    private Context nowContext;
    Button food12_pre_bt,food12_next_bt;
    ButtonListener bt1,bt2;
    Food12[] food12;

    public FoodFragment_12(Context context){

        nowContext = context;
        bt1 = new ButtonListener(context);
        bt2 = new ButtonListener(context);
        food12 = new Food12[12];
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_12, container, false);

        food12_pre_bt = vg.findViewById(R.id.bt_food12_prev);
        food12_next_bt = vg.findViewById(R.id.bt_food12_next);

        food12_pre_bt.setOnClickListener(bt1);
        food12_next_bt.setOnClickListener(bt2);

        StartActivity.dtc.setDataToView(vg);
        initView(vg);


        return vg;
    }
    private void initView(ViewGroup vg){


        //과일
        for(int RowID=0;RowID<12;RowID++){
            RadioButton[] rb1 = new RadioButton[9];
            RadioButton[] rb2 = new RadioButton[3];
            RadioButton[] rb3 = new RadioButton[4];
            for(int ColID=0;ColID<9;ColID++){
                rb1[ColID] = vg.findViewById(getResId(vg,"food12_fir_radio"+(RowID+1)+"_"+(ColID+1)));
            }
            for(int ColID=0;ColID<3;ColID++){
                rb2[ColID] = vg.findViewById(getResId(vg, "food12_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
            }
            for(int ColID=0;ColID<4;ColID++){
                rb3[ColID] = vg.findViewById(getResId(vg, "food12_radio_" + (RowID + 1) + "_"+(ColID+1)));
            }

            food12[RowID] = new Food12(rb1,rb2,rb3);
        }



    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }
    //라디오 버튼 비활성화
    private void disableRadio(RadioButton rb) {
        rb.setFocusable(false);
        rb.setChecked(false);
    }
    public void disableRadio_no_click(RadioButton rb) {
        rb.setFocusable(false);
        rb.setClickable(false);
        rb.setChecked(false);
        rb.setEnabled(false);
        rb.setTextColor(getResources().getColor(R.color.text_gray));
    }
    //라디오 버튼 활성화
    private void enableRadio(RadioButton rb) {
        rb.setFocusable(true);
        rb.setClickable(true);
        rb.setEnabled(true);
        rb.setTextColor(getResources().getColor(R.color.text_black));
    }
    private class Food12{
        protected RadioButton[] erb;
        protected RadioButton[] yrb;
        protected RadioButton[] frb;
        protected  int f_checked=-1;
        protected int checked=-1;
        protected int ck=-1;


        public Food12(RadioButton[] rb1,RadioButton[] rb2,RadioButton[] rb3){
            erb = rb1;
            yrb = rb2;
            frb = rb3;

            for(int i=0;i<frb.length;i++){
                if(frb[i].isChecked()){
                    frb[i].setChecked(true);
                    f_checked = i;
                }
                else
                    frb[i].setChecked(false);
                setBtListener3(frb[i],i);

            }


            for(int i=0;i<erb.length;i++){
                if(erb[i].isChecked()){
                    erb[i].setChecked(true);
                    checked = i;
                }
                else
                    erb[i].setChecked(false);
                setBtListener(erb[i],i);

            }
            if(checked==-1||checked==0){
                for(int i=0;i<yrb.length;i++)
                    disableRadio_no_click(yrb[i]);
            }

            for (int i = 0; i < yrb.length; i++) {
                if (yrb[i].isChecked()) {
                    yrb[i].setChecked(true);
                    ck = i;
                } else
                    yrb[i].setChecked(false);

                setBtListener2(yrb[i], i);

            }


        }

        private void setBtListener(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(idx!=checked){
                        rb.setChecked(true);
                        if(checked!=-1){
                            erb[checked].setChecked(false);
                        }
                        checked=idx;
                    }
                    else
                        rb.setChecked(true);

                    if(checked==-1||checked==0){
                        for(int i=0;i<yrb.length;i++)
                            disableRadio_no_click(yrb[i]);
                    }
                    else{
                        for(int i=0;i<yrb.length;i++)
                            enableRadio(yrb[i]);
                    }

                }
            });


        }
        private void setBtListener2(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(idx!=ck){
                        rb.setChecked(true);
                        if(ck!=-1){
                            yrb[ck].setChecked(false);
                        }
                        ck=idx;
                    }
                    else
                        rb.setChecked(true);



                }
            });


        }

        private void setBtListener3(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if (idx != f_checked) {
                        rb.setChecked(true);
                        if (f_checked != -1) {
                            frb[f_checked].setChecked(false);
                        }
                        f_checked = idx;
                    } else
                        rb.setChecked(true);

                }
            });


    }

    }

}


