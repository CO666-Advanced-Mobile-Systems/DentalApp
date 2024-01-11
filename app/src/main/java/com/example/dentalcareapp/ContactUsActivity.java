package com.example.dentalcareapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContactUsActivity extends AppCompatActivity {

    private static final int[] ICONS = {R.drawable.ic_phone, R.drawable.ic_email, R.drawable.ic_address, R.drawable.ic_youtube};

    private static final String[] CONTACT_TYPES = {"Phone", "Email", "Address", "YouTube"};

    private static final String[][] CONTACT_DETAILS = {
            {"01296 337373"},
            {"contact@healthcare.com"},
            {"27 Cambridge Street\nAylesbury, HP20 1RG"},
            {"https://https://www.youtube.com/channel/UC8Fyi5UrZemfOQQw6nZqd6Q"}
    };
    private ListView listViewContactUs;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        listViewContactUs = findViewById(R.id.editTestTestMulitLine);
        buttonBack = findViewById(R.id.buttonLTBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUsActivity.this, HomeActivity.class));
            }
        });

        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < CONTACT_TYPES.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icon", ICONS[i]);
            map.put("type", CONTACT_TYPES[i]);
            map.put("detail", CONTACT_DETAILS[i][0]);
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.contactus_page_icon,
                new String[]{"icon", "type", "detail"},
                new int[]{R.id.iv_icon, R.id.tv_type, R.id.tv_detail});
        listViewContactUs.setAdapter(adapter);

        listViewContactUs.setOnItemClickListener((parent, view, position, id) -> {
            String detail = CONTACT_DETAILS[position][0];
            switch (CONTACT_TYPES[position]) {
                case "Phone":
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + detail));
                    startActivity(callIntent);
                    break;
                case "Email":
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + detail));
                    startActivity(Intent.createChooser(emailIntent, "Send email"));
                    break;
                case "Address":
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + detail));
                    startActivity(mapIntent);
                    break;
                case "YouTube":
                    Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detail));
                    startActivity(youtubeIntent);
                    break;
            }
        });
    }

}