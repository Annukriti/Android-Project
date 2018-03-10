package com.example.annu.mycms;

/**
 * Created by annu on 28/12/17.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Config;
import com.firebase.client.Firebase;

public class social_cat_com extends AppCompatActivity
{
    public final  static String EXTRA_MESSAGE = "com.example.annu.mycms.MainActivity";
    private static EditText title;
    private static EditText description;
    private static EditText description1;
    private static EditText description2;
    private static EditText fir;
    private static Button submit;
    String EmailHolder;
    TextView Email;
    Firebase firebase;
    public static final String Firebase_Server_URL =  "https://mycms-7ac06.firebaseio.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_cat_com);
        Intent intent = getIntent();
        String message = intent.getStringExtra(category.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        Email = (TextView)findViewById(R.id.textView1);
        //LogOUT = (Button)findViewById(R.id.button1);


        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra("user");

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);


        Firebase.setAndroidContext(social_cat_com.this);
        Button btnShowLocation;
        firebase = new Firebase(Firebase_Server_URL);
        add_to_firebase();
    }
    public void add_to_firebase()
    {

        title = (EditText) findViewById(R.id.editText7);
         description = (EditText) findViewById(R.id.editText13);
        //description2 = (EditText) findViewById(R.id.editText14);
        //final String description = description1.getText().toString() + description2.getText().toString();
        fir=(EditText) findViewById(R.id.editText15);
        submit = (Button) findViewById(R.id.button13);
       // Intent in = getIntent();
       // final String tv1= in.getExtras().getString("user");


        submit.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override

                                     public void onClick(View view)
                                     {

                                         if (TextUtils.isEmpty(title.getText().toString())) {
                                             Toast.makeText(getApplicationContext(), "Enter Title!", Toast.LENGTH_SHORT).show();
                                             return;
                                         }

                                        if (TextUtils.isEmpty(description.getText().toString())) {
                                             Toast.makeText(getApplicationContext(), "Enter Description!", Toast.LENGTH_SHORT).show();
                                             return;
                                         }

                                         if (TextUtils.isEmpty(fir.getText().toString())) {
                                             Toast.makeText(getApplicationContext(), "Enter Fir!", Toast.LENGTH_SHORT).show();
                                             return;
                                         }


                                         Firebase newsPush = new Firebase(Firebase_Server_URL);
                                         final ComplaintDetails location = new ComplaintDetails();




                                        // ComplaintDetails location = new ComplaintDetails();
                                    location.setEmail(Email.getText().toString());
                                      location.getEmail();
                                         location.Title(title.getText().toString());
                                         location.getTitle();
                                         location.Description(description.getText().toString());
                                         location.getDescription();
                                         location.Fir(fir.getText().toString());
                                         location.getFir();
                                         newsPush.push().setValue(location);
                                         //firebase.child("ComplaintDetails").setValue(location);
                                         Toast.makeText(social_cat_com.this, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
                                         Intent intent = new Intent(social_cat_com.this,proceed.class);
                                         startActivity(intent);
                                        /*  if (title.getText().toString().equals("")&& description.equals("soc")&&fir.getText().toString().equals("soc"))
                                         {
                                             Toast.makeText(social_cat_com.this, "you are correct", Toast.LENGTH_SHORT).show();
                                             Intent intent = new Intent(social_cat_com.this,proceed.class);
                                             String message = title.getText().toString();
                                             intent.putExtra(EXTRA_MESSAGE, message);
                                             startActivity(intent);
                                         }
                                         else
                                         {
                                             Toast.makeText(social_cat_com.this, "ur username/password incorrect try again!", Toast.LENGTH_SHORT).show();
                                         } */
                                     }

                                 }



        );
    }
}
