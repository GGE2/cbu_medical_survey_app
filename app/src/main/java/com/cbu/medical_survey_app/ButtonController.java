package com.cbu.medical_survey_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cbu.medical_survey_app.activities.StartActivity;
import com.cbu.medical_survey_app.activities.PopupActivity;
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
import com.cbu.medical_survey_app.fragments.FoodFragment_1;
import com.cbu.medical_survey_app.fragments.WarningFragment;
import com.cbu.medical_survey_app.fragments.WarningFragment2;

public class ButtonController {

    // ButtonController가 만들어진 Context
    final private Context nowContext;
    private TextView title;
    private ImageView title_img;

    public ButtonController(Context context) {
        nowContext = context;
        title = (TextView)((Activity)context).findViewById(R.id.top_title);
        title_img = (ImageView)((Activity)context).findViewById(R.id.title_img);
    }

    // 버튼이 눌렸을 때 동작들(datas에 저장하거나, 제출)
    public void surveyComplete () {

        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 데이터 엑셀에 저장
            StartActivity.dtc.saveExcel(nowContext);

            // 설문 완료 시 앱 재시작
            Intent intent = new Intent(nowContext, StartActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void jobNext() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 직업 -> 최종 제출 페이지
            title.setText(R.string.last_title);
            title_img.setImageResource(0);

            makeFrag(new LastFragment(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void jobPrev() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 일단 직업 -> 수면
            title.setText(R.string.sleep_title);
            title_img.setImageResource(R.drawable.img_sleep_top);

            makeFrag(new SleepFragment(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void smokePrev() {
        // 흡연 -> 일반

    }

    public void smokeNext() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 흡연 -> 수면
            title.setText(R.string.sleep_title);
            title_img.setImageResource(R.drawable.img_sleep_top);

            makeFrag(new SleepFragment(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void sleepPrev() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 수면 -> 흡연
            title.setText(R.string.smoke_title);
            title_img.setImageResource(R.drawable.img_smoke_top);

            makeFrag(new SmokeFragment(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

//    public void sleepNext() {
//        if(StartActivity.dtc.saveData(nowContext)){
//            // 유효성 검사 통과
//
//            // 수면 -> 음식
//            title.setText(R.string.food_title);
//            title_img.setImageResource(R.drawable.img_food_top);
//
//            FragmentManager fm = ((FragmentActivity)nowContext).getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//            fragmentTransaction.replace(R.id.survey_warning, new WarningFragment(nowContext));      // 이후 지워줘야 함
//            fragmentTransaction.replace(R.id.survey_content, new FoodFragment_1(nowContext));
//
//            fragmentTransaction.commit();
//
////            makeFrag(new JobFragment(nowContext));
//        }
//        else{
//            // 유효성 검사 실패 -> 경고창
//            openPopup();
//        }
//    }
public void sleepNext() {
    if(StartActivity.dtc.saveData(nowContext)){
        // 유효성 검사 통과

        // 수면 -> 음식
        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        FragmentManager fm = ((FragmentActivity)nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        //fragmentTransaction.replace(R.id.survey_warning, new WarningFragment(nowContext));      // 이후 지워줘야 함
        fragmentTransaction.replace(R.id.survey_content, new FoodFragment_7(nowContext));

        fragmentTransaction.commit();

//            makeFrag(new JobFragment(nowContext));
    }
    else{
        // 유효성 검사 실패 -> 경고창
        openPopup();
    }
}

public void food7_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.sleep_title);
        title_img.setImageResource(R.drawable.img_sleep_top);

        makeFrag(new SleepFragment(nowContext));


}
    public void food7_next(){
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            title.setText(R.string.food_title);
            title_img.setImageResource(R.drawable.img_food_top);

            makeFrag(new FoodFragment_8(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }

    }
    public void food8_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        makeFrag(new FoodFragment_7(nowContext));


    }
    public void food8_next(){
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            title.setText(R.string.food_title);
            title_img.setImageResource(R.drawable.img_food_top);

            makeFrag(new FoodFragment_9(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }

    }
    public void food9_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        makeFrag(new FoodFragment_8(nowContext));


    }
    public void food9_next(){
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            title.setText(R.string.food_title);
            title_img.setImageResource(R.drawable.img_food_top);

            makeFrag(new FoodFragment_10(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }

    }
    public void food10_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        makeFrag(new FoodFragment_9(nowContext));


    }
    public void food10_next(){
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            title.setText(R.string.food_title);
            title_img.setImageResource(R.drawable.img_food_top);

            makeFrag(new FoodFragment_11(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }

    }
    public void food11_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        makeFrag(new FoodFragment_10(nowContext));


    }
    public void food11_next(){
        if(StartActivity.dtc.saveData(nowContext)){
            FragmentManager fm = ((FragmentActivity)nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.survey_warning, new WarningFragment2(nowContext));      // 이후 지워줘야 함
            fragmentTransaction.replace(R.id.survey_content, new FoodFragment_12(nowContext));

            fragmentTransaction.commit();
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }

    }
    public void food12_prev(){
        StartActivity.dtc.saveData(nowContext);
        // 유효성 검사 통과

        title.setText(R.string.food_title);
        title_img.setImageResource(R.drawable.img_food_top);

        FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.survey_warning, new Fragment());
        fragmentTransaction.replace(R.id.survey_content, new FoodFragment_11(nowContext));

        fragmentTransaction.commit();


    }


    public void food1_Next() {
        // 음식1 -> 음식2

    }

    public void food1_Prev() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 음식 -> 수면
            title.setText(R.string.sleep_title);
            title_img.setImageResource(R.drawable.img_sleep_top);

            makeFrag(new SleepFragment(nowContext));
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void normalComplete () {
        // 현재 뷰의 데이터들을 저장

        if(StartActivity.dtc.saveData(nowContext)) {
            StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_2(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else{
            openPopup();
        }

    }
    public void normal2_pre () {
        // 현재 뷰의 데이터들을 저장
            StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_1(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }

    public void normal2_next () {
        // 현재 뷰의 데이터들을 저장

        if(StartActivity.dtc.saveData(nowContext)) {
            Fragment fragment = new NormalFragment_3(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else
            openPopup();

    }
    public void normal3_pre () {
        // 현재 뷰의 데이터들을 저장
             StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_2(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();


//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }
    public void normal3_next () {
        // 현재 뷰의 데이터들을 저장

        if(StartActivity.dtc.saveData(nowContext)) {
            Fragment fragment = new NormalFragment_4(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else
            openPopup();


//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }
    public void normal4_pre () {
        // 현재 뷰의 데이터들을 저장
        StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_3(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }
    public void normal4_next () {
        // 현재 뷰의 데이터들을 저장
        if(StartActivity.dtc.saveData(nowContext)) {
            title.setText(R.string.smoke_title);
            title_img.setImageResource(R.drawable.img_smoke_top);
            Fragment fragment = new SmokeFragment(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else
            openPopup();

//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }



    private void openPopup() {
        Intent intent = new Intent(nowContext, PopupActivity.class);
        ((Activity)nowContext).startActivityForResult(intent, 1);
    }

    private void makeFrag(Fragment fragment) {
        FragmentManager fm = ((FragmentActivity)nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.survey_content, fragment);
//        Fragment replaceFrag = fm.findFragmentByTag("now_fragment");
//
//        fragmentTransaction.replace(replaceFrag.getId(), fragment);

        fragmentTransaction.commit();
    }
}
