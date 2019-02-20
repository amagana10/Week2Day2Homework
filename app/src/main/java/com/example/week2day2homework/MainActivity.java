package com.example.week2day2homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvMake, tvModel, tvYear, tvTitleStatus, tvColor, tvEngine, tvTransmission;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModel);
        tvYear = findViewById(R.id.tvYear);
        tvTitleStatus = findViewById(R.id.tvTitleStatus);
        tvColor = findViewById(R.id.tvColor);
        tvEngine = findViewById(R.id.tvEngine);
        tvTransmission = findViewById(R.id.tvTransmission);

        sharedPreferences = getSharedPreferences("shared_pref",MODE_PRIVATE);

    }

    public void onStartForResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){
            Bundle bundle = data.getExtras();

            Car car= (Car) bundle.getSerializable("car");

            tvMake.setText(car.getMake());
            tvModel.setText(car.getModel());
            tvYear.setText(car.getYear());
            tvTitleStatus.setText(car.getTitleStatus());
            tvColor.setText(car.getColor());
            tvEngine.setText(car.getEngine());
            tvTransmission.setText(car.getTransmission());

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("make",car.getMake());
            editor.putString("model",car.getModel());
            editor.apply();

            Log.d("TAG", "onActivityResult: "+sharedPreferences.getString("make",""));
            Log.d("TAG", "onActivityResult: "+sharedPreferences.getString("model",""));

        }

    }
}
