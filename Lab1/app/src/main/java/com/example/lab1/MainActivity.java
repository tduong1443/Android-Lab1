package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText txtHoVaTen, txtSDT;
    private RadioButton btnNam, btnNu;
    private Spinner lst;
    private Button btnClick;
    private ListView list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoVaTen = findViewById(R.id.txtHoTen);
        txtSDT = findViewById(R.id.txtSDT);
        btnNam = findViewById(R.id.rdbNam);
        btnNu = findViewById(R.id.rdbNu);
        btnClick = findViewById(R.id.btnAdd);
        lst = findViewById(R.id.lstQue);
        list = findViewById(R.id.lstDS);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_que, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lst.setAdapter(adapter);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(arrayAdapter);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hoVaTen = txtHoVaTen.getText().toString();
                String sdt = txtSDT.getText().toString();
                String gioiTinh = btnNam.isChecked() ? "Nam" : "Nữ";
                String queQuan = lst.getSelectedItem().toString();

                String item = hoVaTen + "-" + gioiTinh + "-" + sdt + "-" + queQuan;

                arrayAdapter.add(item);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNu.setChecked(false);
            }
        });

        btnNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNam.setChecked(false);
            }
        });
    }
}
