package com.example.inf01043_tp2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.inf01043_tp2.databinding.ActivityMainTarefa3Binding;

public class MainActivityTarefa3 extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainTarefa3Binding binding;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    TextView coordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainTarefa3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_activity_tarefa3);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        coordinate = (TextView) findViewById(R.id.textview_cordinates);
        First3Fragment myFragment = (First3Fragment)getSupportFragmentManager().findFragmentByTag("First3Fragment");
        if (myFragment != null && myFragment.isVisible()) {
            int a = 1;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_activity_tarefa3);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = sensorEvent.values[0];
            float sensorY = sensorEvent.values[1];
            float sensorZ = sensorEvent.values[2];

            coordinate.setText(String.valueOf(sensorX) + " " + String.valueOf(sensorY) + " " + String.valueOf(sensorZ));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}