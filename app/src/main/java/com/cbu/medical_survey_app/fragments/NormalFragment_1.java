package com.cbu.medical_survey_app.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;
import com.cbu.medical_survey_app.activities.SubActivity;
import com.cbu.medical_survey_app.activities.SurveyActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NormalFragment_1 extends Fragment {
    private ButtonListener bt1;
    private Context nowContext;
    TextView editDate ;
    EditText pro3_4,editText1,editText2;
    Button next_btn;
    Calendar myCalendar = Calendar.getInstance();
    RadioGroup rg1,rg2,rg7,rg;
    RadioButton rbt1,rbt2,rbt3,rbt4;


    //DateListener가 바뀔경우

    DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myCalendar.set(Calendar.YEAR,i);
            myCalendar.set(Calendar.MONTH,i1);
            myCalendar.set(Calendar.DAY_OF_MONTH,i2);
            updateDate();
        }
    };




    public NormalFragment_1(Context context) {
        bt1 = new ButtonListener(context);
        nowContext = context;
    }



    // 프래그먼트가 만들어질 때 datas에서 데이터를 가져와 모든 뷰에 넣어줌
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.normal_frag_1, container, false);

        next_btn = (Button)vg.findViewById(R.id.normal1_next_btn_1);
        editDate = (TextView)vg.findViewById(R.id.pro3_1);
        pro3_4 = (EditText)vg.findViewById(R.id.pro3_4);


        rbt1= vg.findViewById(R.id.pro5_1);
        editText1= vg.findViewById(R.id.pro5_2);
        rbt2=vg.findViewById(R.id.pro5_3);
        rbt3 = vg.findViewById(R.id.pro8_1);
        editText2 = vg.findViewById(R.id.pro8_2);
        rbt4 = vg.findViewById(R.id.pro8_3);


        next_btn.setOnClickListener(bt1);


        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dg = new DatePickerDialog(getContext(),setDate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                dg.getDatePicker().setCalendarViewShown(false);
                dg.show();
            }
        });

        // 프래그먼트에 데이터 세팅
        StartActivity.dtc.setDataToView(vg);

        no_group_rb_1(rbt1,rbt2,editText1); // pro 5독립버튼 처리
        no_group_rb_2(rbt3,rbt4,editText2); //pro 8독립버튼 처리


        return vg;
    }


    public void no_group_rb_1(RadioButton bt1, RadioButton bt2, EditText ed){

        RadioButton rb1 = bt1;
        RadioButton rb2 = bt2;
        EditText edit = ed;

        if(!rb1.isChecked()){
            edit.setEnabled(false);
            edit.setFocusable(false);
            edit.setText("");
            edit.setTextColor(getResources().getColor(R.color.text_gray));
        }


        //Pro5 독립버튼 처리
        rb1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                rb1.setChecked(true);
                edit.setEnabled(true);
                edit.setFocusableInTouchMode(true);
                edit.setFocusable(true);
                edit.setTextColor(getResources().getColor(R.color.text_black));
                rb2.setChecked(false);

            }
        });
        //Pro 5 독립버튼 처리
        rb2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                edit.setEnabled(false);
                edit.setFocusable(false);
                edit.setText("");
                edit.setTextColor(getResources().getColor(R.color.text_gray));
                rb1.setChecked(false);
                rb2.setChecked(true);
            }
        });


    }
    public void no_group_rb_2(RadioButton bt1,RadioButton bt2,EditText ed){

        RadioButton rb1 = bt1;
        RadioButton rb2 = bt2;
        EditText edit = ed;

        if(!rb1.isChecked()){
            edit.setEnabled(false);
            edit.setFocusable(false);
            edit.setText("");
            edit.setTextColor(getResources().getColor(R.color.text_gray));
        }


        //Pro8 독립버튼 처리
        rb1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                rb1.setChecked(true);
                edit.setEnabled(true);
                edit.setFocusableInTouchMode(true);
                edit.setFocusable(true);
                edit.setTextColor(getResources().getColor(R.color.text_black));
                rb2.setChecked(false);

            }
        });
        //Pro 5 독립버튼 처리
        rb2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                edit.setEnabled(false);
                edit.setFocusable(false);
                edit.setText("");
                edit.setTextColor(getResources().getColor(R.color.text_gray));
                rb1.setChecked(false);
                rb2.setChecked(true);
            }
        });



    }


    public void updateDate(){   //날짜 형식 변환
        String format1= "YYYY년 MM월 dd일";
        String format2= "YYMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format1, Locale.KOREA);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(format2, Locale.KOREA);
        editDate.setText(simpleDateFormat.format(myCalendar.getTime()));
        pro3_4.setText(simpleDateFormat2.format(myCalendar.getTime()));

    }



}