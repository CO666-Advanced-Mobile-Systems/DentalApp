package com.example.dentalcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details =
            {
                    {"Doctor Name :Sudath Nawagamuwage","Hospital Address: Aylesbury","Exp : 5yrs", "Mobile No:07592898", "£150.00"},
                    {"Doctor Name :Niveith Nawagamuwage","Hospital Address: Aylesbury","Exp : 5yrs", "Mobile No:07592898", "£150.00"},
                    {"Doctor Name :tania Nawagamuwage","Hospital Address: Aylesbury","Exp : 5yrs", "Mobile No:07592898", "£150.00"},
                    {"Doctor Name :saveyth Nawagamuwage","Hospital Address: Aylesbury","Exp : 5yrs", "Mobile No:07592898", "£150.00"},
                    {"Doctor Name :Kiveith Nawagamuwage","Hospital Address: Aylesbury","Exp : 5yrs", "Mobile No:07592898", "£150.00"},
            };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.LIstViewLT);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, HomeActivity.class));
            }
        });
        list =new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item= new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Fees :"+ doctor_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
            );
        ListView lst = findViewById(R.id.editTestTestMulitLine);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               Intent it = new Intent( DoctorDetailsActivity.this, BookAppointmentActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);

            }
        });

    }
}