package com.example.administrator.practicetest1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class ContextActivity extends AppCompatActivity {
ImageView imageView, imageView2, imageView3, imageView4;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView2= (ImageView) findViewById(R.id.imageView2);
        imageView3= (ImageView) findViewById(R.id.imageView3);
        imageView4= (ImageView) findViewById(R.id.imageView4);

        registerForContextMenu(imageView);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);
        registerForContextMenu(imageView4);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()){
            case R.id.imageView:{
                getMenuInflater().inflate(R.menu.photo_share,menu);
                number=4;
                break;
            }
            case R.id.imageView2:{
                getMenuInflater().inflate(R.menu.photo_share,menu);
                number=5;
                break;
            }
            case R.id.imageView3:{
                getMenuInflater().inflate(R.menu.photo_share,menu);
                number=6;
                break;
            }
            case R.id.imageView4:{
                getMenuInflater().inflate(R.menu.photo_share,menu);
                number=7;
                break;
            }

        }
        menu.setHeaderTitle("Pick One");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.Share:{

                Intent intent = new Intent(Intent.ACTION_SEND);
                Uri imageUri;
                intent.setType("image/*");
                imageUri = Uri.parse("android.resource://" + getPackageName()
                        + "/drawable/show"+number);
                //intent.putExtra(intent.EXTRA_TEXT,textToShare);
                /*Uri uri = Uri
                        .parse("android.resource://com.package.xname/drawable/"
                                );*/
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                Intent chooser=Intent.createChooser(intent,"Send Photo");
                startActivity(chooser);
                break;
            }
            case R.id.Hide:{
                if(number==4)
                    imageView.setVisibility(View.INVISIBLE);
                if(number==5)
                    imageView2.setVisibility(View.INVISIBLE);
                if(number==6)
                    imageView3.setVisibility(View.INVISIBLE);
                if(number==7)
                    imageView4.setVisibility(View.INVISIBLE);


                break;
            }


        }

        return super.onContextItemSelected(item);


    }
}
