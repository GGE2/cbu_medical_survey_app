package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class FoodData_7 {


    final private LinkedHashMap<String, String> mapped_data;

    private int[] boodang_year = new int[8];
    private int[] boodang_once= new int[8];
    private String[] avg_year={"거의 안먹음","월 1회","월 2~3회","주 1~2회","주 3~4회","주 5~6회","일 1회","일 2회","일 3회"};
    private String[][] avg_once={{"사진 11-1","사진 11-2","사진 11-3"},{"사진 11-1","사진 11-2","사진 11-3"},{"사진 12-1","사진 12-2","사진 12-3"}
            ,{"사진 12-1","사진 12-2","사진 12-3"},{"사진 12-1","사진 12-2","사진 12-3"},{"1개","2개","3개"},{"사진 12-1","사진 12-2","사진 12-3"}
            ,{"죽 반그릇,반팩","죽 한그릇,한팩","죽 한그릇 반, 한팩 반"}};

    public FoodData_7() {
        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i< boodang_year.length;i++){
            boodang_year[i] = -1;
            boodang_once[i] = -1;
        }

        }



    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }
    public void saveData(Context nowcontext){

        for(int RowID=0;RowID<8;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food7_text_name_"+(RowID+1)));
            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food7_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    boodang_year[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food7_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    boodang_once[RowID] =ColID;
                }

            }
            if(boodang_year[RowID]==0){
                mapped_data.put(getString(food_name),boodang_year[RowID]==-1?"":avg_year[boodang_year[RowID]]);
            }
            else {
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", boodang_year[RowID]==-1?"":avg_year[boodang_year[RowID]]);

                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", boodang_once[RowID]==-1?"":avg_once[RowID][boodang_once[RowID]]);


            }
        }


    }
    public void setDataToView(ViewGroup vg){
        for(int RowID=0;RowID<8;RowID++){
            if(boodang_year[RowID]!=-1){
                if(boodang_year[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food7_fir_radio"+(RowID+1)+"_"+(boodang_year[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food7_fir_radio"+(RowID+1)+"_"+(boodang_year[RowID]+1)))).setChecked(true);
                    if(boodang_once[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food7_sec_radio_avg"+(RowID+1)+"_"+(boodang_once[RowID]+1)))).setChecked(true);
                }


            }
        }
    }
    public boolean check(){


        for(int RowID=0;RowID<8;RowID++){
            if(boodang_year[RowID]==-1){
                return false;
            }
            if(boodang_year[RowID]!=0&&boodang_year[RowID]!=-1){
                if(boodang_once[RowID]==-1)
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
