package com.if31.formulirlomba_programming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
private EditText etnama, etnowahatsapp, etalamat, etpasword, etpin;
private RadioGroup rgjeniskelamin;
private RadioButton rbJeniskelamin;
private Button btnDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etnowahatsapp = findViewById(R.id.et_nomorwa);
        etalamat = findViewById(R.id.et_alamat);
        etpasword = findViewById(R.id.et_password);
        etpin = findViewById(R.id.et_pin);
        rgjeniskelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etnama.getText().toString();
                String nowhatsapp = etnowahatsapp.getText().toString();
                String alamat = etalamat.getText().toString();
                String password = etpasword.getText().toString();
                String pin = etpin.getText().toString();

                int jeniskelamin = rgjeniskelamin.getCheckedRadioButtonId();
                rbJeniskelamin = findViewById(jeniskelamin);
                String jnskelamin = rbJeniskelamin.getText().toString();

                if (nama.trim().equals("")) {
                    etnama.setError("Nama tidak boleh kosong");
                } else if (nowhatsapp.trim().equals("")) {
                    etnowahatsapp.setError("no whatsapp tidak boleh kosong");
                } else if (alamat.trim().equals("")) {
                    etalamat.setError("Alamat tidak boleh kosong");
                } else if (password.trim().equals("")) {
                    etpasword.setError("password tidak boleh kosong");
                } else if (pin.trim().equals("")) {
                    etpin.setError("pin tidak boleh kosong");
                } else {
                    Intent intent = new Intent(MainActivity.this, confirm_activity.class);
                    intent.putExtra("varNama" , nama);
                    intent.putExtra("varNoWhatsapp" , nowhatsapp);
                    intent.putExtra("varalamat" , alamat);
                    intent.putExtra("varJenisKelamin" , jnskelamin);
                    startActivity(intent);
                }
            }


        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etnowahatsapp.setText("");
        etalamat.setText("");
        etpasword.setText("");
        etpin.setText("");
    }
}