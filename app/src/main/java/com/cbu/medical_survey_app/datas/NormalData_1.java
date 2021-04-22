package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import com.cbu.medical_survey_app.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class NormalData_1 {
    final private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    private String user_sex="";
    private String user_married_status="";
    private String user_birth="";
    private String user_czs="";
    private String user_mom_age="";
    private String user_id_front="";
    private String user_id_back="";
    private String user_height="";
    private String user_weight="";
    private String user_period_address="";
    private String user_weight_20th="";
    private String user_weight_30th="";
    private String user_weight_best="";
    private String user_final_education="";
    private String user_household_member="";
    private String user_salary = "";
    private int user_sex_id=-1;
    private int user_married_status_id=-1;
    private int user_final_education_id=-1;
    private int pro5_ID=-1;
    private int pro8_ID=-1;




    final private LinkedHashMap<String, String> mapped_data;

    public NormalData_1() {
        mapped_data = new LinkedHashMap<String, String>();
    }

    private String getString(EditText view) {
        return view.getText().toString();
    }

    private String getString(TextView view) {
        return view.getText().toString();
    }

    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }

    public void saveData(Context nowContext) {
        user_sex_id = ((RadioGroup) ((Activity) nowContext).findViewById(R.id.pro1)).getCheckedRadioButtonId();
        user_married_status_id=((RadioGroup) ((Activity) nowContext).findViewById(R.id.pro2)).getCheckedRadioButtonId();
        user_final_education_id = ((RadioGroup) ((Activity) nowContext).findViewById(R.id.pro7)).getCheckedRadioButtonId();



        RadioButton pro5_1 = ((Activity)nowContext).findViewById(R.id.pro5_1);
        RadioButton pro5_3 = ((Activity)nowContext).findViewById(R.id.pro5_3);
        RadioButton pro8_1 = ((Activity)nowContext).findViewById(R.id.pro8_1);
        RadioButton pro8_3 = ((Activity)nowContext).findViewById(R.id.pro8_3);


        if(user_sex_id!=-1)
            user_sex = getString((RadioButton)( ((Activity) nowContext).findViewById(user_sex_id)));
        if(user_married_status_id!=-1)
            user_married_status = getString((RadioButton) ((Activity) nowContext).findViewById(user_married_status_id));
        if(user_final_education_id!=-1)
            user_final_education = getString((RadioButton)((Activity)nowContext).findViewById(user_final_education_id));

        user_birth = getString((TextView)((Activity)nowContext).findViewById(R.id.pro3_1));
        user_czs = getString(((Activity)nowContext).findViewById(R.id.pro3_2));
        user_mom_age=getString((EditText)((Activity)nowContext).findViewById(R.id.pro3_3));
        user_id_front=getString((EditText)((Activity)nowContext).findViewById(R.id.pro3_4));
        user_id_back=getString((EditText)((Activity)nowContext).findViewById(R.id.pro3_5));
        user_height=getString((EditText)((Activity)nowContext).findViewById(R.id.pro4_1));
        user_weight=getString((EditText)((Activity)nowContext).findViewById(R.id.pro4_2));
        user_weight_20th=getString((EditText)((Activity)nowContext).findViewById(R.id.pro6_1));
        user_weight_30th=getString((EditText)((Activity)nowContext).findViewById(R.id.pro6_2));
        user_weight_best=getString((EditText)((Activity)nowContext).findViewById(R.id.pro6_3));
        user_salary=getString((EditText)((Activity)nowContext).findViewById(R.id.pro9_1));
        if(pro5_1.isChecked()) {
            user_period_address = getString((EditText) ((Activity) nowContext).findViewById(R.id.pro5_2));
            pro5_ID = R.id.pro5_1;
        }
        if(pro5_3.isChecked()) {
            user_period_address="";
            pro5_ID = R.id.pro5_3;
        }
        if(pro8_1.isChecked()) {
            user_household_member = getString((EditText) ((Activity) nowContext).findViewById(R.id.pro8_2));
            pro8_ID = R.id.pro8_1;
        }
        if(pro8_3.isChecked()) {
            user_household_member = "";
            pro8_ID = R.id.pro8_3;
        }
        mapped_data.put("사용자 성별",user_sex);
        mapped_data.put("사용자 결혼상태",user_married_status);
        //mapped_data.put("사용자 생년월일",user_birth);
        mapped_data.put("사용자 띠",user_czs+"띠");
        mapped_data.put("사용자 부모나이(사용자를 낳았을 때)",user_mom_age);
        mapped_data.put("사용자 주민번호 앞자리",user_id_front);
        mapped_data.put("사용자 주민번호 뒷자리",user_id_back);
        mapped_data.put("사용자 키",user_height+"cm");
        mapped_data.put("사용자 몸무게",user_weight+"kg");
        mapped_data.put("사용자 현재 사는 지역 기간",pro5_ID==R.id.pro5_3?"모르겠다":user_period_address+"년");
        mapped_data.put("사용자 20~25살 몸무게",user_weight_20th+"kg");
        mapped_data.put("사용자 35~40살 모무게",user_weight_30th+"kg");
        mapped_data.put("사용자 최고 몸무게",user_weight_best+"kg");
        mapped_data.put("사용자 최종학력",user_final_education);
        mapped_data.put("사용자 가족구성원 수",pro8_ID==R.id.pro8_3?"모르겠다":user_household_member+"명");
        mapped_data.put("사용자 가족 할당 총 수입",user_salary+"만원");

    }

    public void setDataToView(ViewGroup vg) {
        if(user_sex_id!=-1){
            ((RadioButton)vg.findViewById(user_sex_id)).setChecked(true);
        }
        if(user_married_status_id!=-1){
            ((RadioButton)vg.findViewById(user_married_status_id)).setChecked(true);
        }
        if(user_final_education_id!=-1){
            ((RadioButton) vg.findViewById(user_final_education_id)).setChecked(true);
        }
        if(!(user_id_front.equals(""))) {
            ((TextView) vg.findViewById(R.id.pro3_1)).setText(user_birth);
        }
        ((EditText)vg.findViewById(R.id.pro3_2)).setText(user_czs);
        ((EditText)vg.findViewById(R.id.pro3_3)).setText(user_mom_age);
        ((EditText)vg.findViewById(R.id.pro3_4)).setText(user_id_front);
        ((EditText)vg.findViewById(R.id.pro3_5)).setText(user_id_back);
        ((EditText)vg.findViewById(R.id.pro4_1)).setText(user_height);
        ((EditText)vg.findViewById(R.id.pro4_2)).setText(user_weight);
        if(pro5_ID!=-1) {
            ((RadioButton) vg.findViewById(pro5_ID)).setChecked(true);
            ((EditText) vg.findViewById(R.id.pro5_2)).setText(user_period_address);

        }
        ((EditText)vg.findViewById(R.id.pro6_1)).setText(user_weight_20th);
        ((EditText)vg.findViewById(R.id.pro6_2)).setText(user_weight_30th);
        ((EditText)vg.findViewById(R.id.pro6_3)).setText(user_weight_best);
        if(pro8_ID!=-1) {
            ((EditText) vg.findViewById(R.id.pro8_2)).setText(user_household_member);
            ((RadioButton) vg.findViewById(pro8_ID)).setChecked(true);
        }

        ((EditText)vg.findViewById(R.id.pro9_1)).setText(user_salary);


    }
    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", vg.getContext().getPackageName());
        return getID;
    }
    public boolean check() {
        //성별 ,결혼상태 , 최종학력 미기입
        if(user_sex_id==-1||user_married_status_id==-1||user_final_education_id==-1) {
            return false;
        }
        //생년월일 , 띠 , 출생시 어머니 나이 , 주민등록번호, 키 , 몸무게 , 20대 몸무게,40대 몸무게, 최고 몸무게, 가족 전체 수입 미기입
        if(user_birth.equals("")||user_czs.equals("")||user_mom_age.equals("")||user_id_front.equals("")||
                user_id_back.equals("")||user_height.equals("")||user_weight.equals("")||user_weight_20th.equals("")||user_weight_30th.equals("")||user_weight_best.equals("")||user_salary.equals("")) {
            return false;
        }
        //사시는 지역 기간 미기입
        if(pro5_ID==-1) {
            return false;
        }
        //살고있는 식구 미기입
        if(pro8_ID==-1)
            return false;
        return true;
    }
}