//NIM   : 10121738
//Nama  : Rifqi Sirojul Muzhoffar
//Kelas : IF-9
//Tanggal Pengerjaan : 24/04/2023

package com.example.a10121738latihan3;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DoneActivity extends AppCompatActivity{
    @BindView(R.id.txtDoneTitle)
    TextView txtNama;
    @BindString(R.string.activation_beres)
    String beres;
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @BindString(R.string.activation_setiap)
    String setiap;
    @BindString(R.string.activation_buat)
    String buat;

    public static final String ID_EXTRA_MSG_EXIT = "com.example.a10121738latihan3.MSG_EXIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);
        bindExtra();
    }

    private void bindExtra(){
        Intent intent = getIntent();
        String name = intent.getStringExtra(BiodataActivity.ID_EXTRA_MSG);
        txtNama.setText(beres+" "+ name +" "+sudahBisa+" "+ name +" "+setiap+" "+ name +" "+buat);
    }

    @OnClick(R.id.btnDoneNext)
    public void selesai(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ID_EXTRA_MSG_EXIT, true);
        startActivity(intent);
    }
}
