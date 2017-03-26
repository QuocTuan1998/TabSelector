package com.example.quoctuan.tabselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtA,txtB;
    Button btnCong;

    ListView lvHistory;
    ArrayList<String> dsCong;
    ArrayAdapter<String> adapterCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhepCong();
            }
        });
    }

    private void xuLyPhepCong() {

        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        String s=a+"+"+b+"="+(a+b);
        Toast.makeText(MainActivity.this,s, Toast.LENGTH_SHORT).show();

        dsCong.add(s);
        adapterCong.notifyDataSetChanged();
        txtA.setText("");
        txtB.setText("");


    }

    private void addControls() {

        TabHost tabHost= (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab1");
        tab1.setIndicator("1.Phép Cộng");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("Tab2");
        tab2.setIndicator("2.Lịch Sử");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);

        btnCong= (Button) findViewById(R.id.btnCong);

        lvHistory= (ListView) findViewById(R.id.lvHistory);

        dsCong=new ArrayList<String>();
        adapterCong=new ArrayAdapter<String>(MainActivity.this,
                                            android.R.layout.simple_list_item_1,
                                            dsCong);
        lvHistory.setAdapter(adapterCong);


    }
}
