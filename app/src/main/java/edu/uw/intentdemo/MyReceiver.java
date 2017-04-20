package edu.uw.intentdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by iguest on 4/20/17.
 */

public class MyReceiver extends BroadcastReceiver {

    public static final String TAG = "Receiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, intent.toString());
        if (intent.getAction() == Intent.ACTION_BATTERY_LOW) {
            Toast.makeText(context, "Plug in your phone", Toast.LENGTH_SHORT);
        }

    }
}
