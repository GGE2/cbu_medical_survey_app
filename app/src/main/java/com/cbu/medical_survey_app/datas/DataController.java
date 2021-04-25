package com.cbu.medical_survey_app.datas;

import android.content.Context;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.FoodFragment_10;
import com.cbu.medical_survey_app.fragments.FoodFragment_11;
import com.cbu.medical_survey_app.fragments.FoodFragment_12;
import com.cbu.medical_survey_app.fragments.FoodFragment_7;
import com.cbu.medical_survey_app.fragments.FoodFragment_8;
import com.cbu.medical_survey_app.fragments.FoodFragment_9;
import com.cbu.medical_survey_app.fragments.JobFragment;
import com.cbu.medical_survey_app.fragments.LastFragment;
import com.cbu.medical_survey_app.fragments.NormalFragment_1;
import com.cbu.medical_survey_app.fragments.NormalFragment_2;
import com.cbu.medical_survey_app.fragments.NormalFragment_3;
import com.cbu.medical_survey_app.fragments.NormalFragment_4;
import com.cbu.medical_survey_app.fragments.SleepFragment;
import com.cbu.medical_survey_app.fragments.SmokeFragment;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class DataController {

    // 설문 시작 시 이름, 주소
    final private String origin_name;
    final private String origin_address;

    final private NormalData_1 normal_data1;
    final private NormalData_2 normal_data2;
    final private NormalData_3 normal_data3;
    final private NormalData_4 normal_data4;
    final private LastData last_data;
    final private JobData job_data;
    final private SmokeData smoke_data;
    final private SleepData sleep_data;
    final private FoodData_7 food_data7;
    final private FoodData_8 food_data8;
    final private FoodData_9 food_data9;
    final private FoodData_10 food_data10;
    final private FoodData_11 food_data11;
    final private FoodData_12 food_data12;

    public DataController(String name, String address) {
        origin_name = name;
        origin_address = address;
        normal_data1 = new NormalData_1();
        normal_data2 = new NormalData_2();
        normal_data3 = new NormalData_3();
        normal_data4 = new NormalData_4();
        smoke_data = new SmokeData();
        sleep_data = new SleepData();
        job_data = new JobData();
        last_data = new LastData();
        food_data7 = new FoodData_7();
        food_data8 = new FoodData_8();
        food_data9 = new FoodData_9();
        food_data10 = new FoodData_10();
        food_data11 = new FoodData_11();
        food_data12 = new FoodData_12();
    }

    // survey_content에 연결된 프래그먼트에 따라 저장할 데이터 분기
    public boolean saveData(Context context) {
        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);
        if(nowFragment instanceof NormalFragment_1){
            System.out.println("일반 사항1 Frag");
            normal_data1.saveData(context);
            //return normal_data1.check();
        }
        else if(nowFragment instanceof NormalFragment_2){
            System.out.println("일반 사항2 Frag");
            normal_data2.saveData(context);
            //return normal_data2.check();
        }
        else if(nowFragment instanceof NormalFragment_3){
            System.out.println("일반 사항3 Frag");
            normal_data3.saveData(context);
            //return normal_data3.check();
        }
        else if(nowFragment instanceof NormalFragment_4){
            System.out.println("일반 사항4 Frag");
            normal_data4.saveData(context);
            //return normal_data4.check();
        }
        else if(nowFragment instanceof SmokeFragment){
            System.out.println("흡연 및 음주 Frag");
            smoke_data.saveData(context);
            //return smoke_data.check();
        }
        else if(nowFragment instanceof SleepFragment){
            System.out.println("수면 육체 활동사항 Frag");
            sleep_data.saveData(context);
            //return sleep_data.check();

        }
        else if(nowFragment instanceof JobFragment){
            System.out.println("직업사항 Frag");
            job_data.saveData(context);
            //return job_data.check();

        }

        else if(nowFragment instanceof LastFragment){
            System.out.println("설문 완료 Frag");
            last_data.saveData(context);
            //return last_data.check();
        }
        else if(nowFragment instanceof FoodFragment_7){
            System.out.println("식품 사항7 Frag:");
            food_data7.saveData(context);
            //return food_data7.check();
        }
        else if(nowFragment instanceof FoodFragment_8){
            System.out.println("식품 사항8 Frag:");
            food_data8.saveData(context);
            //return food_data8.check();
        }
        else if(nowFragment instanceof FoodFragment_9){
            System.out.println("식품 사항9 Frag:");
            food_data9.saveData(context);
            //return food_data9.check();
        }
        else if(nowFragment instanceof FoodFragment_10){
            System.out.println("식품 사항10 Frag:");
            food_data10.saveData(context);
            //return food_data10.check();
        }
        else if(nowFragment instanceof FoodFragment_11){
            System.out.println("식품 사항11 Frag:");
            food_data11.saveData(context);
            //return food_data11.check();
        }
        else if(nowFragment instanceof FoodFragment_12){
            System.out.println("식품 사항12 Frag:");
            food_data12.saveData(context);
            //return food_data12.check();
        }





        else {
            System.out.println("아님");
        }

//        if(openAlert) {
//            System.out.println("경고창 띄우는 로직");
//        }
//        else{
//            System.out.println("다음 페이지 가는 로직");
//        }

        return true;
    }

//    public HashMap<String, String> getData(Context context) {
//        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);
//
//        if(nowFragment instanceof Last_Fragment){
//            System.out.println("맞음");
//            return last_data.getData();
//        }
//        else {
//            System.out.println("아님");
//            return null;
//        }
//    }

    public void setDataToView(ViewGroup vg) {

        switch (vg.getId()) {

            case R.id.normal_frag_1:{
                normal_data1.setDataToView(vg);
                break;
            }
            case R.id.normalfrag_2:{
                normal_data2.setDataToView(vg);
                break;
            }
            case R.id.normalfrag_3:{
                normal_data3.setDataToView(vg);
                break;
            }
            case R.id.normalfrag_4:{
                normal_data4.setDataToView(vg);
                break;
            }
            case R.id.smoke_frag: {
                smoke_data.setDataToView(vg);
                break;
            }
            case R.id.sleep_frag:{
                sleep_data.setDataToView(vg);
                break;
            }
            case R.id.food_frag_7:{
                food_data7.setDataToView(vg);
                break;
            }
            case R.id.food_frag_8:{
                food_data8.setDataToView(vg);
                break;

            }
            case R.id.food_frag_9:{
                food_data9.setDataToView(vg);
                break;

            }
            case R.id.food_frag_10:{
                food_data10.setDataToView(vg);
                break;

            }
            case R.id.food_frag_11:{
                food_data11.setDataToView(vg);
                break;

            }
            case R.id.food_frag_12:{
                food_data12.setDataToView(vg);
                break;

            }
            case R.id.job_frag: {
                job_data.setDataToView(vg);
                break;
            }
            case R.id.last_frag: {
                last_data.setDataToView(vg);
                break;
            }

        }

    }

    public void saveExcel(Context context) {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);
        Cell cell;

        int idx = 0;

        for (Map.Entry<String, String> entry: job_data.getData().entrySet()) {
            cell = row.createCell(idx++);
            cell.setCellValue(entry.getKey());
            System.out.println(entry.getKey());
        }

        File xlsFile = new File(context.getExternalFilesDir(null), "text.xls");

        try{
            FileOutputStream os = new FileOutputStream(xlsFile);
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(xlsFile.getAbsolutePath() + "에 저장됨");
    }
}
