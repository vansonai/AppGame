package com.example.differentcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.differentcolor.adapter.OmauAdapter;
import com.example.differentcolor.object.DinhNghia;
import com.example.differentcolor.object.OMau;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DinhNghia dinhNghia = new DinhNghia();
    ArrayList<OMau> arrOMau = new ArrayList<>();
    GridView gdvListOMau;
    OmauAdapter adapter;

    TextView txtLever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        anhxa();
        setup();
        setClick();
    }

    private void init() {
        taoMau();

        adapter = new OmauAdapter(this,0,arrOMau);
    }

    private void anhxa(){
        gdvListOMau = findViewById(R.id.gdvListOMau);
        txtLever = findViewById(R.id.txtLever);
    }

    private void setup(){
        gdvListOMau.setNumColumns(dinhNghia.soCot);
        gdvListOMau.setAdapter(adapter);
        txtLever.setText("" + dinhNghia.leverl);
    }

    private void setClick(){
        gdvListOMau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkMau(arrOMau.get(position));
            }
        });
    }

    private void checkMau(OMau o){
        if (o.maMau.equals(dinhNghia.mauIt)){
            dinhNghia.leverl++;
            taoMau();
            upDate();
        }else{
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        }
    }


    private void taoMau(){
        dinhNghia.setLeverl();
        dinhNghia.layMauNgauNhien();
        arrOMau.clear();
        while(arrOMau.size() < dinhNghia.soO){
            arrOMau.add(new OMau(dinhNghia.mauNhieu));
        }
        Random r = new Random();
        arrOMau.get(r.nextInt(arrOMau.size())).maMau = dinhNghia.mauIt;
    }
    private void upDate(){
        adapter.upDate(arrOMau);
        gdvListOMau.setNumColumns(dinhNghia.soCot);
        txtLever.setText("" + dinhNghia.leverl);

    }
}