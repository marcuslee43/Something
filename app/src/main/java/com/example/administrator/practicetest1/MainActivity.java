package com.example.administrator.practicetest1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void startWebsite(View view) {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(editText.getText().toString());

    }

    public void previous(View view) {
        webView.goBack();

    }

    public void next(View view) {
       
        webView.goForward();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {


            //noinspection SimplifiableIfStatement
            case R.id.Gallery: {
                Intent intent = new Intent(this,GallyActivity.class);
                startActivity(intent);

                break;
            }

            case R.id.Seek: {
                Intent intent = new Intent(this,SeekActivity.class);
                startActivity(intent);
               break;
            }
            case R.id.Implicet: {
                Intent intent= new Intent(this,ImplicitActivity.class);
                startActivity(intent);
               break;
            }
            case R.id.Media: {
                Intent intent = new Intent(this, MediaActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.Context: {
                Intent intent = new Intent(this, ContextActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.Toast: {

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                LayoutInflater inflater = getLayoutInflater();
                //inflate view for alertdialog since we are using multiple views inside a viewgroup (root = Layout top-level) (linear, relative, framelayout etc..)
                View view = inflater.inflate(R.layout.toast_veiw, (ViewGroup) findViewById(R.id.toastView));
                final AlertDialog alertDialog = alert.create();
                alertDialog.setView(view);
                alert.setTitle("Where would you like toast");
                Button button1 = (Button) view.findViewById(R.id.button4);
                Button button2 = (Button) view.findViewById(R.id.button5);
                Button button3 = (Button) view.findViewById(R.id.button6);
                Button button4 = (Button) view.findViewById(R.id.button7);

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG);
                        toast.setGravity(1, -400, -600);
                        toast.show();
                        alertDialog.cancel();

                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG);
                        toast.setGravity(1, 400, -600);
                        toast.show();
                        alertDialog.cancel();
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG);
                        toast.setGravity(1, -400, 600);
                        toast.show();
                        alertDialog.cancel();
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG);
                        toast.setGravity(1, 400, 600);
                        toast.show();
                        alertDialog.cancel();

                    }
                });

                //alert.setView(view);
                alertDialog.show();
                break;


            }
        }

        return super.onOptionsItemSelected(item);
    }
}
