package edu.uw.intentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "**Second**";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //action bar "back"
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the intent that was used to start this activity, then get the bundle from it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView tv = (TextView)findViewById(R.id.txtSecond);
            tv.setText(extras.getString(MainActivity.EXTRA_MESSAGE));
        }
    }
}
