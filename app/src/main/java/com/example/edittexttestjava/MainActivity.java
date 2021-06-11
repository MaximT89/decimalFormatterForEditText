package com.example.edittexttestjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class MainActivity extends AppCompatActivity {

    EditText creditCardText;

    TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString();
            updateUi(str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creditCardText = findViewById(R.id.card);
        creditCardText.addTextChangedListener(tw);
    }

    private void updateUi(String s) {

        String str = s.replace(" ", "");
        int i = Integer.parseInt(str);
        String str1 = DecimalFormatter.getDecimalFormat(i);

        creditCardText.removeTextChangedListener(tw);
        creditCardText.setText(str1);
        creditCardText.setSelection(str1.length());
        creditCardText.addTextChangedListener(tw);
    }
}