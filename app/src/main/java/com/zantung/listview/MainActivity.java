package com.zantung.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThemMH, btnCapNhatMH, btnXoaMH;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = findViewById(R.id.DsMonHoc);
        btnThemMH = findViewById(R.id.btn_Them);
        btnCapNhatMH= findViewById(R.id.btn_CapNhat);
        btnXoaMH = findViewById(R.id.btn_Xoa);
        edtMonHoc = findViewById(R.id.editTextMonHoc);

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Gà rán");
        arrayCourse.add("Phô mai que");
        arrayCourse.add("Khoai tây chiên");
        arrayCourse.add("Cơm cuộn");
        arrayCourse.add("Canh rong biển");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvMonHoc.setAdapter(adapter);

        btnThemMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = edtMonHoc.getText().toString();
                arrayCourse.add(monHoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnCapNhatMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnXoaMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.remove(vitri);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity1.class);
                startActivity(intent);
                return false;
            }
        });
    }
}