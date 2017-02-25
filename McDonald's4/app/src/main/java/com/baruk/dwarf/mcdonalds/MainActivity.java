package com.baruk.dwarf.mcdonalds;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    Button m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.call);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0472545235"));
                startActivity(callIntent);
            }
        });

        Button mEmail = (Button) findViewById(R.id.action_send_email);
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","pasha@gmail.com",null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Welcome to ...");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Here body of email goes...");
                startActivity(Intent.createChooser(emailIntent,"Send email..."));
            }
        });

        m = (Button) findViewById(R.id.map);

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=макдональдс+черкаси");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


    }
}
