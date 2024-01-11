package com.example.dentalcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class AboutUsActivity extends AppCompatActivity {

    private  String[][] aboutus_details =
            {
                    {"Dental care practitioners are professionals who specialise in providing dental" +
                            " care services to patients, including diagnosing and treating " +
                            "various dental problems, performing dental procedures such as fillings," +
                            " extractions, and cleanings, and educating patients about oral " +
                            "hygiene and preventative dental care.These professionals are essential " +
                            "to maintaining good oral health and preventing dental problems, such as cavities, " +
                            "gum disease, and tooth loss.These professionals are essential to maintaining good oral " +
                            "health and preventing dental problems, such as cavities, gum disease, and tooth loss. ",""},
            };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        lst = findViewById(R.id.editTestTestMulitLine);
        btnBack = findViewById(R.id.buttonLTBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUsActivity.this, HomeActivity.class));
            }
        });
        list =new ArrayList();
        for(int i=0;i<aboutus_details.length;i++){
            item= new HashMap<String,String>();
            item.put("line1", aboutus_details[i][0]);
            item.put("line2", aboutus_details[i][1]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.about_page,
                new String[]{"line1","line2"},
                new int[]{R.id.line_a});
        ListView lst = findViewById(R.id.editTestTestMulitLine);
        lst.setAdapter(sa);

    }
}