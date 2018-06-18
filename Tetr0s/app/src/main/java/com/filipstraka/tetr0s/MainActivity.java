package com.filipstraka.tetr0s;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.filipstraka.tetr0s.Tetrengine.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        setContentView(new Tetrengine(this, vibrator));
    }
}
