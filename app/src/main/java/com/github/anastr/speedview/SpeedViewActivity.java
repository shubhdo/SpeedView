package com.github.anastr.speedview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.anastr.speedviewlib.SpeedView;

public class SpeedViewActivity extends AppCompatActivity {

    SpeedView speedView;
    SeekBar seekBar;
    Button ok;
    TextView textSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_view);

        speedView = (SpeedView) findViewById(R.id.speedView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ok = (Button) findViewById(R.id.ok);
        textSpeed = (TextView) findViewById(R.id.textSpeed);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speedView.speedTo(seekBar.getProgress());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format("%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void openControlActivity(View view) {
        Intent intent = new Intent(SpeedViewActivity.this, ControlActivity.class);
        startActivity(intent);
    }
}
