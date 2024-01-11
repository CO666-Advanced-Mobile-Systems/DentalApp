package com.example.dentalcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class TreatmentDetailsActivity extends AppCompatActivity {

    private String[][] treatments = {
            {"Treatment 1 : Examination and Diagnosis", "", "", "", "£75.00"},
            {"Treatment 2 : Filling", "", "", "", "£90.00"},
            {"Treatment 3 : Extraction", "", "", "", "£140.00"},
            {"Treatment 4 : Root Canal", "", "", "", "£285.00"},
            {"Treatment 5 : Periodontal Care", "", "", "", "£50.00"}
    };
    private String[] treatments_details = {
            "Examination and Diagnosis\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment",
            "Filling\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment",
            "Extraction\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment",
            "Root Canal\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment",
            "Periodontal Care\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment\n" +
                    "Detail Treatment",
    };
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;
    //private Button buttonBack;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_details);

        btnGoToCart = findViewById(R.id.buttonLTGoTocart);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.editTestTestMulitLine);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TreatmentDetailsActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<treatments.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", treatments[i][0]);
            item.put("line2", treatments[i][1]);
            item.put("line3", treatments[i][2]);
            item.put("line4", treatments[i][3]);
            item.put("line5", "Fees :" + treatments[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent( TreatmentDetailsActivity.this, TreatmentDetailsInfoActivity.class);
                it.putExtra("text1", treatments[i][0]);
                it.putExtra("text2", treatments_details[i]);
                it.putExtra("text3", treatments[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(TreatmentDetailsActivity.this, CartLabActivty.class));
            }
        });
    }

}