package edu.uw.intentdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "**Main**";
    public static final String EXTRA_MESSAGE = "edu.uw.intentdemo.message";
    private static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View launchButton = findViewById(R.id.btnLaunch);
        launchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Launch button pressed");
                // Metaphor is that we are sending letters to another activity

                // Parameters: context (can't say this b/c we are inside listener), SecondActivity class
                //             ^^where we are sending from                          ^^where we are sending to
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "Hiya --MainActivity"); // putting a "present" in with the letter
                startActivity(intent); // effectively a "start" letter

            }
        });

    }

    public void callNumber(View v) {
        Log.v(TAG, "Call button pressed");
        // create an intent with an action
        // we don't know what application will pick up the action, we are just saying
        // "hey, somebody who can call phone numbers, can you please call someone for me?"
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:206-949-2376"));
        startActivity(intent);
    }

    public void takePicture(View v) {
        Log.v(TAG, "Camera button pressed");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // hey someone who can capture an image, do so
        if (intent.resolveActivity(getPackageManager()) != null) // make sure there is something that can actually take picture
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // second parameter is to keep track of the requests that have been made
    }

    public void sendMessage(View v) {
        Log.v(TAG, "Message button pressed");


    }

    // gets called whenenver a result comes back
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                                                    // make sure response is okay
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bmp = (Bitmap) extras.get("data"); // bitmap is stored in data key of the bundle
            ImageView image = (ImageView) findViewById(R.id.imgThumbnail);
            image.setImageBitmap(bmp);
        }
    }
}
