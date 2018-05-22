package com.serenegiant.usbcameratest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by xubingbing on 2018/3/15.
 */

public class HomeActivity extends Activity implements View.OnClickListener {

    private Button mSize1, mSize2, mSize3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mSize1 = (Button) findViewById(R.id.size1);
        mSize2 = (Button) findViewById(R.id.size2);
        mSize3 = (Button) findViewById(R.id.size3);

        mSize1.setOnClickListener(this);
        mSize2.setOnClickListener(this);
        mSize3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (v.getId()){
            case R.id.size1:
                intent.putExtra("w",640);
                intent.putExtra("h",480);
                break;
            case R.id.size2:
                intent.putExtra("w",1280);
                intent.putExtra("h",720);
                break;
            case R.id.size3:
                intent.putExtra("w",1920);
                intent.putExtra("h",1080);
                break;
        }
        startActivity(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                finish();

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
