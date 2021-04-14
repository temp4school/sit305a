package com.example.sit305_task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    EditText numberSelector;
    Spinner spinner;
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;

    public void Change(String state) {
        String something = (String)spinner.getSelectedItem();
        String something2 = String.valueOf(numberSelector.getText());
        if (!state.equals(something)) {
            something = "Error";
        }
        Integer number;
        try {
            number = Integer.parseInt(something2);
        }
        catch(Exception e) {
            number = 0;
        }

        float num = Integer.parseInt(number.toString());

        switch (something) {
            case "Metre":
                textView1.setText(String.format("%.2f", num*100));
                textView2.setText(String.format("%.2f", num*3.281));
                textView3.setText(String.format("%.2f", num*39.37));
                textView4.setText("Centimetre");
                textView5.setText("Foot");
                textView6.setText("Inch");
                break;

            case "Celsius":
                textView1.setText(String.format("%.2f", (num*9/5)+32));
                textView2.setText(String.format("%.2f", num+273.15));
                textView3.setText("");
                textView4.setText("Fahrenheit");
                textView5.setText("Kelvin");
                textView6.setText("");
                break;

            case "Kilograms":
                textView1.setText(String.format("%.2f", num*1000));
                textView2.setText(String.format("%.2f", num*35.275));
                textView3.setText(String.format("%.2f", num*2.205));
                textView4.setText("Gram");
                textView5.setText("Ounce(Oz)");
                textView6.setText("Pound(lb)");
                break;
            case "Error":
                textView1.setText("Error");
                textView2.setText("Error");
                textView3.setText("Error");
                textView4.setText("Error");
                textView5.setText("Error");
                textView6.setText("Error");
        }
    }

    View.OnClickListener imgButtonHandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            Change("Metre");
        }
    };

    View.OnClickListener imgButtonHandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            Change("Celsius");
        }
    };

    View.OnClickListener imgButtonHandler3 = new View.OnClickListener() {
        public void onClick(View v) {
            Change("Kilograms");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView6 = (TextView)findViewById(R.id.textView6);

        btn1 = (ImageButton)findViewById(R.id.distanceBtn);
        btn2 = (ImageButton)findViewById(R.id.tempBtn);
        btn3 = (ImageButton)findViewById(R.id.weightBtn);

        btn1.setOnClickListener(imgButtonHandler1);
        btn2.setOnClickListener(imgButtonHandler2);
        btn3.setOnClickListener(imgButtonHandler3);

        numberSelector = (EditText)findViewById(R.id.numberSelector);

        // Updates when anything is changed.
        //numberSelector.addTextChangedListener(new TextWatcher() {
        //    @Override
        //    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        //
        //    @Override
        //    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //        Change();
        //    }
        //
        //    @Override
        //    public void afterTextChanged(Editable s) {}
        //});

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Change();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }
}