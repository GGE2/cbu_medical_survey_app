package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class FoodData_12 {

    final private LinkedHashMap<String, String> mapped_data;
    private int[] food12_fir = new int[12];
    private int[] food12_month = new int[12];
    private int[] food12_fir_once = new int[12];
    private String[] avg_year={"거의 안먹음","월 1회","월 2~3회","주 1~2회","주 3~4회","주 5~6회","일 1회","일 2회","일 3회"};
    private String[] avg_month={"한 계절","두 계절","세 계절","사 계절"};

    private String[][] food12_once={{"중 5개","중 10개","중 15개"}, {"중 1쪽","중 2쪽","중 4쪽"}, {"중 &#189;쪽","중 1쪽","중 2쪽"},
            {"중 &#188;개/중 &#189;개","중 &#189;개/중 1개","중 1개/중 2개"}, {"중 &#189;개","1개","2개"},
            {"&#189;개","1개","2개"} ,{"&#189;개","1개","2개"},
            {"중 &#188;개","중 &#8531;개","중 &#189;개"} ,{"&#188;개/&#189;컵(100ml)","&#189;개/1컵(200ml)","1개/2컵(400ml)"} ,{"&#189;개/&#189;컵(100ml)","1개/1컵(200ml)","2컵/2개(400ml)"},
            {"&#188;송이/&#189;컵(100ml)","&#189;송이/1컵(200ml)","1송이/2컵(400ml)"},{"&#189;개/10개/&#189;컵(100ml)","1개/20개/1컵(200ml)","2개/30개/2컵(400ml)"}};


    public FoodData_12() {
        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i<food12_fir.length;i++){
            food12_fir[i]=-1;
            food12_month[i]=-1;
            food12_fir_once[i]=-1;

        }

    }


    public LinkedHashMap<String, String> getData() {

        return mapped_data;
    }
    public void saveData(Context nowcontext) {
        //과일
        for(int RowID=0;RowID<12;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food12_text_name_"+(RowID+1)));

            for(int ColID=0;ColID<4;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food12_radio_"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    food12_month[RowID] = ColID;
                }

            }

            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food12_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    food12_fir[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food12_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    food12_fir_once[RowID] =ColID;
                }

            }
            if(food12_fir[RowID]==0){
                mapped_data.put(getString(food_name),food12_fir[RowID]==-1?"":avg_year[food12_fir[RowID]]);
                mapped_data.put(getString(food_name),food12_month[RowID]==-1?"섭취 안함":"섭취 안함");
            }
            else {
                if(food12_fir[RowID]!=-1) {
                    mapped_data.put(getString(food_name)+ "섭취 개월 : ",food12_month[RowID]==-1?"":avg_month[food12_month[RowID]]);
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", food12_fir[RowID]==-1?"":avg_year[food12_fir[RowID]]);
                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", food12_fir_once[RowID]==-1?"":food12_once[RowID][food12_fir_once[RowID]]);
                }
            }
        }



    }
    public void setDataToView(ViewGroup vg) {
        for(int RowID=0;RowID<12;RowID++){
            if(food12_month[RowID]!=-1){
                ((RadioButton)vg.findViewById(getResId(vg,"food12_radio_"+(RowID+1)+"_"+(food12_month[RowID]+1)))).setChecked(true);
            }
            if(food12_fir[RowID]!=-1){
                if(food12_fir[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food12_fir_radio"+(RowID+1)+"_"+(food12_fir[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food12_fir_radio"+(RowID+1)+"_"+(food12_fir[RowID]+1)))).setChecked(true);
                    if(food12_fir_once[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food12_sec_radio_avg"+(RowID+1)+"_"+(food12_fir_once[RowID]+1)))).setChecked(true);
                }


            }

        }


    }
    public boolean check(){
        for(int RowID=0;RowID<12;RowID++){
            if(food12_fir[RowID]==-1){
                return false;
            }
            if(food12_fir[RowID]!=0&&food12_fir[RowID]!=-1){
                if(food12_fir_once[RowID]==-1)
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
