package com.example.annu.mycms;

/**
 * Created by annu on 28/12/17.
 */
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class status extends AppCompatActivity {
    CheckBox brcheckbox;
    public TextView outputText;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


        brcheckbox = (CheckBox) findViewById(R.id.brcheckbox);
        b = (Button) findViewById(R.id.button4);


        brcheckbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (brcheckbox.isChecked()) {
                    // Switch On Broadcast Receiver
                    PackageManager pm = status.this.getPackageManager();
                    ComponentName componentName = new ComponentName(
                            status.this, BroadcastManager.class);
                    pm.setComponentEnabledSetting(componentName,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);




                } else {
                    // Switch Off Broadcast Receiver
                    PackageManager pm = status.this.getPackageManager();
                    ComponentName componentName = new ComponentName(
                            status.this, BroadcastManager.class);
                    pm.setComponentEnabledSetting(componentName,
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP);


                }
            }
        });
        Button a;
        a = (Button) findViewById(R.id.button18);

        a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent inten1t = new Intent(status.this, MainActivity.class);
                //String message = .getText().toString();
                startActivity(inten1t);
            }


        });
    }


}