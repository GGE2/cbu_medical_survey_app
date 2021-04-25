package com.cbu.medical_survey_app;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.fragment.app.FragmentActivity;

public class ButtonListener implements Button.OnClickListener {

    final private ScrollView scrollView;
    final private ButtonController btc;

    public ButtonListener(Context context) {
        scrollView = ((FragmentActivity)context).findViewById(R.id.main_scroll);
        btc = new ButtonController(context);
    }

    // 버튼 리스너들 각 버튼에 controller를 연결시킴
    @Override
    public void onClick(View view) {

        scrollView.fullScroll(ScrollView.FOCUS_UP);

        switch (view.getId()) {
            case R.id.normal1_next_btn_1 :
                btc.normalComplete();
                break;
            case R.id.bt_normal2_prev:
                btc.normal2_pre();
                break;
            case R.id.bt_normal2_next:
                btc.normal2_next();
                break;
            case R.id.bt_normal3_prev:
                btc.normal3_pre();
                break;
            case R.id.bt_normal3_next:
                btc.normal3_next();
                break;
            case R.id.bt_normal4_prev:
                btc.normal4_pre();
                break;
            case R.id.bt_normal4_next:
                btc.normal4_next();
                break;
            case R.id.bt_smoke_prev:
                btc.smokePrev();
                break;
            case R.id.bt_smoke_next:
                btc.smokeNext();
                break;
            case R.id.bt_sleep_prev:
                btc.sleepPrev();
                break;
            case R.id.bt_sleep_next:
                btc.sleepNext();
                break;
            case R.id.bt_food7_prev:
                btc.food7_prev();
                break;
            case R.id.bt_food7_next:
                btc.food7_next();
                break;
            case R.id.bt_food8_prev:
                btc.food8_prev();
                break;
            case R.id.bt_food8_next:
                btc.food8_next();
                break;
            case R.id.bt_food9_prev:
                btc.food9_prev();
                break;
            case R.id.bt_food9_next:
                btc.food9_next();
                break;
            case R.id.bt_food10_prev:
                btc.food10_prev();
                break;
            case R.id.bt_food10_next:
                btc.food10_next();
                break;
            case R.id.bt_food11_prev:
                btc.food11_prev();
                break;
            case R.id.bt_food11_next:
                btc.food11_next();
                break;
            case R.id.bt_food12_prev:
                btc.food12_prev();
                break;
            case R.id.bt_job_prev:
                btc.jobPrev();
                break;
            case R.id.bt_job_next:
                btc.jobNext();
                break;

            default:
                break;
        }
    }
}
