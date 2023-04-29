//NIM   : 10121738
//Nama  : Rifqi Sirojul Muzhoffar
//Kelas : IF-9
//Tanggal Pengerjaan : 24/04/2023

package com.example.a10121738latihan3;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BiodataActivity extends AppCompatActivity{

    @BindView(R.id.edtBiodataName)
    EditText edtNama;
    @BindString(R.string.check_code_warning_empty_title_name)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc_name)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;
    //Id unik untuk putekstra (melempar nilai ke activity lain)
    public static final String ID_EXTRA_MSG = "com.example.a10121738latihan3.MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnBiodataNext)
    void selanjutnya() {

        String nameBiodata = edtNama.getText().toString();

        if (isStringEmpty(nameBiodata)) {
            showWarningMessage();
        } else {
            Intent intent = new Intent(this, DoneActivity.class);
            //Melempar isi nama biodata ke kelas DoneActivity
            intent.putExtra(ID_EXTRA_MSG, nameBiodata);
            startActivity(intent);
        }

    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }
    public void showWarningMessage(){
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = dialog.findViewById(R.id.btnWarningDialogOk);
        textTitle.setText(emptyTitle);
        textDesc.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}
