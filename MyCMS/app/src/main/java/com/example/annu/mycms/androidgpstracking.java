package com.example.annu.mycms;

/**
 * Created by annu on 28/12/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class androidgpstracking  extends Activity
{
    public final  static String EXTRA_MESSAGE = "com.example.annu.mycms.androidgpstracking";
    private static Button next;
    GPSTracker gps;
    String EmailHolder;
    TextView Email;
Firebase firebase;
public static final String Firebase_Server_URL =  "https://mycms-7ac06.firebaseio.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidgpstracking);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
       /* String messages = intent.getStringExtra(Main3Activity.EXTRA_MESSAGE);*/

        /* textView.setText(messages);*/

        Email = (TextView)findViewById(R.id.textView1);
        //LogOUT = (Button)findViewById(R.id.button1);


        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra("user");

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        Firebase.setAndroidContext(androidgpstracking.this);
        Button btnShowLocation;
        firebase = new Firebase(Firebase_Server_URL);

        // GPSTracker class

        btnShowLocation = (Button) findViewById(R.id.button19);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

                                               @Override
                                               public void onClick(View arg0) {
                                                   // create class object
                                                   gps = new GPSTracker(androidgpstracking.this);

                                                   // check if GPS enabled
                                                   if (gps.canGetLocation()) {

                                                       double latitude = gps.getLatitude();
                                                       double longitude = gps.getLongitude();
                                                       // \n is for new line
                                                     //  ComplaintDetails location = new ComplaintDetails();

                                                       // Calling function to Get data from EditText and store into string variables.
                                                      // GetDataFromEditText();

                                                       // Adding student name into student class object.
                                                     //  location.Lati(latitude);
                                                      //  location.getLati();
                                                       // Adding student number into student class object.
                                                       //location.Longi(longitude);
                                                        //location.getLongi();

                                                       // Passing student phone number and name into firebase object to add into database.
                                                       //firebase.child("ComplaintDetails").setValue(location);
                                                       Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();


                                                   } else {
                                                       // can't get location
                                                       // GPS or Network is not enabled
                                                       // Ask user to enable GPS/network in settings
                                                       gps.showSettingsAlert();
                                                   }

                                               }
                                           }




        );

    }
public void nextButton(View view)
    {
        next = (Button) findViewById(R.id.button3);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(androidgpstracking.this, category.class);

                intent.putExtra("user", EmailHolder);

                startActivity(intent);
            }
        });

    }
}