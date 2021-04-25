package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class FoodData_11 {

    final private LinkedHashMap<String, String> mapped_data;
    private int[] food11_fir = new int[8];
    private int[] food11_fir_once = new int[8];
    private int[] food11_sec = new int[6];
    private int[] food11_sec_once = new int[6];
    private String[] avg_year={"거의 안먹음","월 1회","월 2~3회","주 1~2회","주 3~4회","주 5~6회","일 1회","일 2회","일 3회"};
    private String[][] fir_once={{"&#8531;개","&#8532;개","1개"},{"큰 것 &#189;장","큰 것 한장","큰 것 한장 반"},{"국 &#189;그릇","국 한그릇","국 한그릇 반"},
            {"&#189;컵(100ml)","한컵(200ml)","2컵(400ml)"},{"&#189;개","1개","2개"},
            {"&#189;개","1개","2개"},{"&#189;개","1개","2개"},{"&#189;컵(100ml)","1컵(100ml)","2컵(400ml)"}};
    private String[][] sec_once={{"&#189;잔","1잔","2잔"},{"1찻술,2찻술,3찻술"},{"1찻술,2찻술,3찻술"},
            {"&#189;잔","1잔","2잔"},{"&#189;컵(100ml)","한컵(200ml)","2컵이상(400ml)"},
            {"&#189;잔","1잔","2잔"}};


    public FoodData_11() {
        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i<food11_fir.length;i++){
            food11_fir[i]=-1;
            food11_fir_once[i]=-1;
        }
        for(int i=0;i<food11_sec.length;i++){
            food11_sec[i]=-1;
            food11_sec_once[i]=-1;
        }


    }
    public LinkedHashMap<String, String> getData() {

        return mapped_data;
    }
    public void saveData(Context nowcontext) {
        //어묵 두유
        for(int RowID=0;RowID<8;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_1_text_name_"+(RowID+1)));
            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_1_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    food11_fir[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_1_sec_radio_avg11_1" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    food11_fir_once[RowID] =ColID;
                }

            }
            if(food11_fir[RowID]==0){
                mapped_data.put(getString(food_name),food11_fir[RowID]==-1?"":avg_year[food11_fir[RowID]]);
            }
            else {
                if(food11_fir[RowID]!=-1) {
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", food11_fir[RowID]==-1?"":avg_year[food11_fir[RowID]]);

                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", food11_fir_once[RowID]==-1?"":fir_once[RowID][food11_fir_once[RowID]]);
                }
            }
        }

        //커피 기타음료
        for(int RowID=0;RowID<6;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_2_text_name_"+(RowID+1)));
            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_2_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    food11_sec[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food11_2_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    food11_sec_once[RowID] =ColID;
                }

            }
            if(food11_sec[RowID]==0){
                mapped_data.put(getString(food_name),food11_sec[RowID]==-1?"":avg_year[food11_sec[RowID]]);
            }
            else {
                if(food11_fir[RowID]!=-1) {
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", food11_sec[RowID]==-1?"":avg_year[food11_sec[RowID]]);

                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", food11_sec_once[RowID]==-1?"":sec_once[RowID][food11_sec_once[RowID]]);
                }
            }
        }




    }
    public void setDataToView(ViewGroup vg) {
        for(int RowID=0;RowID<8;RowID++){
            if(food11_fir[RowID]!=-1){
                if(food11_fir[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food11_1_fir_radio"+(RowID+1)+"_"+(food11_fir[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food11_1_fir_radio"+(RowID+1)+"_"+(food11_fir[RowID]+1)))).setChecked(true);
                    if(food11_fir_once[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food11_1_sec_radio_avg11_1"+(RowID+1)+"_"+(food11_fir_once[RowID]+1)))).setChecked(true);
                }


            }
        }

        for(int RowID=0;RowID<6;RowID++){
            if(food11_sec[RowID]!=-1){
                if(food11_sec[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food11_2_fir_radio"+(RowID+1)+"_"+(food11_sec[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food11_2_fir_radio"+(RowID+1)+"_"+(food11_sec[RowID]+1)))).setChecked(true);
                    if(food11_sec[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food11_2_sec_radio_avg"+(RowID+1)+"_"+(food11_sec_once[RowID]+1)))).setChecked(true);
                }


            }
        }



    }
    public boolean check(){
        for(int RowID=0;RowID<8;RowID++){
            if(food11_fir[RowID]==-1){
                return false;
            }
            if(food11_fir[RowID]!=0&&food11_fir[RowID]!=-1){
                if(food11_fir_once[RowID]==-1)
                    return false;
            }



        }
        for(int RowID=0;RowID<6;RowID++){
            if(food11_sec[RowID]==-1){
                return false;
            }
            if(food11_sec[RowID]!=0&&food11_sec[RowID]!=-1){
                if(food11_sec_once[RowID]==-1)
                    return false;
            }



        }


        return true;
    }
    private String getString(EditText view) {

        return view.getText().toString();
    }


    private String getString(TextView view) {

        return view.getText().toString();
    }

    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", vg.getContext().getPackageName());
        return getID;
    }
}
