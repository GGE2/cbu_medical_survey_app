package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;

import org.w3c.dom.Text;

public class WarningFragment2 extends Fragment {

    private ButtonListener btl;

    public WarningFragment2() {
    }

    public WarningFragment2(Context context) {
        btl = new ButtonListener(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.warning_frag2, container, false);

        TextView red_text = vg.findViewById(R.id.red_text);

        SpannableString content = new SpannableString(red_text.getText().toString());

        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

        red_text.setText(content);

        return vg;
    }
}
