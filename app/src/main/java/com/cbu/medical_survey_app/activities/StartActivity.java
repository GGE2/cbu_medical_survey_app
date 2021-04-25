package com.cbu.medical_survey_app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.datas.DataController;

public class StartActivity extends AppCompatActivity {

    Button btn_main_1;
    public static DataController dtc;
    EditText main_input_address,main_input_name;
    ViewGroup viewGroup;


    //화면전환시 xml 변경
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.main_page_portrait);

        }
        else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.main_page_landscape);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //oreintation 에 따라 layout.xml 동적으로 적용
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.main_page_portrait);
        }
        else{
            setContentView(R.layout.main_page_landscape);
        }


        btn_main_1 = (Button)findViewById(R.id.btn_main_1);
        main_input_name = (EditText)findViewById((R.id.main_input_name));
        main_input_address = (EditText)findViewById((R.id.main_input_address));



        //화면 전환시 데이터유지
        if(savedInstanceState!=null){

            String nData = savedInstanceState.getString("name_Data");
            String aData = savedInstanceState.getString("address_Data");

            main_input_name.setText(nData);
            main_input_address.setText(aData);

        }



        dtc = new DataController(main_input_name.getText().toString(), main_input_address.getText().toString());


        btn_main_1.setOnClickListener(new View.OnClickListener(){

            String user_name = main_input_name.getText().toString();
            String user_address = main_input_address.toString();
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StartActivity.this, SubActivity.class);
                startActivity(intent);
//                if(checkText()) {
//                    startActivity(intent);
//                }
//                else{
//                    openPopup();
//                }



            }
        });



    }
    //onDestory() 함수 호출시 데이터 저장
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String saveName = main_input_name.getText().toString();
        String saveAddress = main_input_address.getText().toString();

        outState.putString("name_Data",saveName);
        outState.putString("address_Data",saveAddress);
    }

    //화면 밖 클릭시 키보드 종료
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View v = getCurrentFocus();

        if(v != null && (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_MOVE) && v instanceof EditText && !v.getClass().getName().startsWith("android.webkit.")){
            int[] scrcoords = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + v.getLeft() - scrcoords[0];
            float y = event.getRawY() + v.getTop() - scrcoords[1];

            if(x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(event);
    }


    //name과 address 입력값 확인
    private boolean checkText(){
        String address_check="";
        String name_check="";

        address_check = main_input_address.getText().toString();
        name_check = main_input_address.getText().toString();

        if(name_check.equals("") || address_check.equals("")) {
            return false;
        }
        else
            return true;

    }
    private void openPopup() {
        Intent intent = new Intent(StartActivity.this, StartPopupActivity.class);
        ((Activity)StartActivity.this).startActivityForResult(intent, 1);
    }
}