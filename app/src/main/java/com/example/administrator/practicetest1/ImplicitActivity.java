package com.example.administrator.practicetest1;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitActivity extends AppCompatActivity {
EditText editText, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicet);
        editText= (EditText) findViewById(R.id.editText2);
        editText2= (EditText) findViewById(R.id.editText3);

    }
    public void findFairbanks(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:64.8436,147.7231"));
        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);

    }
    public void sendMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] = {"lilmxl1000@gmail.com", "lilmxl1000@yahoo.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, ""+editText.getText().toString());
        //intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Email");
        startActivity(chooser);
    }

    public void sendPic(View view) {


        //EditText editText = (EditText)findViewById(R.id.editText);
        String str = editText2.getText().toString();
        Intent intent2 = new Intent(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TEXT, str);
        Intent chooser = Intent.createChooser(intent2, "Share Text");
        startActivity(chooser);
    }


}
