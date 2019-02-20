package com.example.week2day2homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText etMake, etModel, etYear, etTitleStatus, etColor, etEngine, etTransmission;
    Intent passedIntent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etYear = findViewById(R.id.etYear);
        etTitleStatus = findViewById(R.id.etTitleStatus);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngine);
        etTransmission = findViewById(R.id.etTransmission);


        sharedPreferences = getSharedPreferences("shared_pref",MODE_PRIVATE);

        etMake.setText(sharedPreferences.getString("make",""));
        etModel.setText(sharedPreferences.getString("model",""));

        passedIntent = getIntent();
    }

    public void onClick(View view) {
        String make = etMake.getText().toString();
        String model = etModel.getText().toString();
        String year = etYear.getText().toString();
        String titleStatus = etTitleStatus.getText().toString();
        String color =  etColor.getText().toString();
        String engine = etEngine.getText().toString();
        String transmission = etTransmission.getText().toString();
        if (!make.isEmpty() &&
            !model.isEmpty() &&
            !year.isEmpty() &&
            !titleStatus.isEmpty() &&
            !color.isEmpty() &&
            !engine.isEmpty() &&
            !transmission.isEmpty()){
            Bundle bundle = new Bundle();
            Car car = new Car(make,model,year,titleStatus,color,engine,transmission);
            bundle.putSerializable("car",car);

            passedIntent.putExtras(bundle);

            setResult(100,passedIntent);
            finish();
        }
    }
}
