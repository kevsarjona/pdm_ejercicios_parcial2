package com.example.pdm_ejercicios_parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WidgetsActvity extends AppCompatActivity {

    Button myButton;
    SeekBar seekBar;
    TextView textView;
    EditText editText;
    CheckBox checkBox;
    Switch aSwitch;
    RadioGroup radioGroup;
    RatingBar ratingBar;
    ProgressBar progressBar;
    ToggleButton toggleButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_actvity);

        myButton = findViewById(R.id.btn_buton);
        seekBar = findViewById(R.id.seek_bar);
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        checkBox = findViewById(R.id.checkbox);
        aSwitch = findViewById(R.id.swtch);
        radioGroup = findViewById(R.id.radio_group);
        ratingBar = findViewById(R.id.rating_bar);
        progressBar = findViewById(R.id.progress_bar);
        toggleButton = findViewById(R.id.toggle_button);

        listenerButton();
        listenerTextView();
        listenerEditText();
        listenerCheckbox();
        listenerSwitch();
        listenerRadioGroup();
        listenerRatingBar();
        listenerToggleButton();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("El valor es:  " + i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void listenerButton(){
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("onClick myButton");
                message("onClick myButton");

            }
        });

        myButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public  boolean onLongClick(View view){
                textView.setText("onLongClick myButton");
                message("onLongClick myButton");
                return false;
            }

        });
    }

    private void listenerTextView(){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("beforeTextView" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("changedTextView" + charSequence);
                /*String mayusculas = charSequence.toString().toUpperCase();
                String currentValue = textView.getText().toString().toUpperCase();
                if(!mayusculas != currentValue) {
                    textView.setText(mayusculas);
                }*/

            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextView");


            }
        });
    }

    private void listenerEditText(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("BeforeTextChanged" +  charSequence + " " + i + " " + i1 + " " + i2 );
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("onTextChanged" +  charSequence + " " + i + " " + i1 + " " + i2);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextChanged");
            }
        });
    }

    private void listenerCheckbox(){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckedChanged " + b);

            }
        });
    }

    private void listenerSwitch() {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckedChanged " + b);
            }
        });
    }

    private void listenerRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.option1:
                        message("opcion 1");
                        break;

                    case R.id.option2:
                        message("opcion 2");
                        break;
                }

            }
        });
    }

    private void listenerRatingBar(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                message("onRatingChanged " +  v + " " + b);
            }
        });
    }

    private void listenerProgressBar(){

    }

    private void listenerToggleButton(){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckedChanged " + b);
            }
        });
    }

    private void message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}