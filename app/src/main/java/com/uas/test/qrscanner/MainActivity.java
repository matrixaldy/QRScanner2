package com.uas.test.qrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static EditText editText;
    public static final String CODE = "Unique";
    TextView textViewResult;
    Button scan_btn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scan,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.scans:
                Intent start =new Intent(MainActivity.this, ScanCodeActivity.class);
                startActivity(start);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textViewResult = (TextView)findViewById(R.id.text_view_result);
        scan_btn = (Button)findViewById(R.id.ok_btn);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void result(View v) {
        Intent i = new Intent(this, ResultActivity.class);
        String UniqueID = editText.getText().toString();
        i.putExtra(CODE, UniqueID);
        startActivity(i);
    }
}
