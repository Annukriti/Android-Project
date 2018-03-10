package com.example.annu.mycms;

/**
 * Created by annu on 27/12/17.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class category extends AppCompatActivity {
    public final  static String EXTRA_MESSAGE = "com.example.annu.mycms.category";
    Button social,nationals,intenational,privates;
    String EmailHolder;
    TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();
        String messagess = intent.getStringExtra(androidgpstracking.EXTRA_MESSAGE);
        // String messages = intent.getStringExtra(Main3Activity.EXTRA_MESSAGE);

        Email = (TextView)findViewById(R.id.textView1);
        //LogOUT = (Button)findViewById(R.id.button1);


        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra("user");

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(messagess);
        // textView.setText(messages);
        social = (Button) findViewById(R.id.social);
        nationals = (Button) findViewById(R.id.national);
        intenational = (Button) findViewById(R.id.international);
        privates = (Button) findViewById(R.id.privates);
        social.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View view)
                                      {
                                          Intent intent = new Intent(category.this, social_cat_com.class);
                                          intent.putExtra("user", EmailHolder);
                                          startActivity(intent);
                                      }

                                  }
        );
        nationals.setOnClickListener(new View.OnClickListener()
                                     {
                                         @Override
                                         public void onClick(View view)
                                         {
                                             Intent intent = new Intent(category.this,social_cat_com.class);
                                             intent.putExtra("user", EmailHolder);
                                             startActivity(intent);
                                         }

                                     }
        );
        intenational.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {
                                                Intent intent = new Intent(category.this, social_cat_com.class);
                                                intent.putExtra("user", EmailHolder);
                                                startActivity(intent);
                                            }

                                        }
        );
        privates.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            Intent intent = new Intent(category.this, social_cat_com.class);
                                            intent.putExtra("user", EmailHolder);
                                            startActivity(intent);
                                        }

                                    }
        );
    }

}