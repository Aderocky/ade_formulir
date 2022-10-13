package com.if31.formulirlomba_programming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class confirm_activity extends AppCompatActivity {
    DatePickerDialog DATEPICKERDIALOG;
    TextView tvnama, tvjk, tvnowhatsapp, tvalamat,tvtanggal ;
    Button btntanggal , btnkonfirmasi;

    String nama , jk, nowhatsapp , alamat , choosendate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvnowhatsapp = findViewById(R.id.tv_nowa);
        tvalamat = findViewById(R.id.tv_alamat);
        tvtanggal = findViewById(R.id.tv_tanggal);

        btntanggal = findViewById(R.id.btntanggal);
        btnkonfirmasi = findViewById(R.id.btnkonfirmasi);

        //ambil intent yang di kirim main activity
        Intent terima = getIntent();
        nama =terima.getStringExtra("varNama");
        jk =terima.getStringExtra("varJenisKelamin");
        nowhatsapp =terima.getStringExtra("varNoWhatsapp");
        alamat =terima.getStringExtra("varalamat");

        tvnama.setText(nama);
        tvjk.setText(jk);
        tvnowhatsapp.setText(nowhatsapp);
        tvalamat.setText(alamat);

        btntanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar newcalender = Calendar.getInstance();
                DATEPICKERDIALOG = new DatePickerDialog(confirm_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month+1);
                        String tanggal = Integer.toString(dayofmonth);
                        choosendate = tanggal + "/" + bulan + "/"  + tahun;
                        tvtanggal.setText(choosendate);
                    }
                }, newcalender.get(Calendar.YEAR), newcalender.get(Calendar.MONTH), newcalender.get(Calendar.DAY_OF_MONTH));
                DATEPICKERDIALOG.show();
            }
        });

        btnkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog  = new AlertDialog.Builder(confirm_activity.this);
                        dialog.setTitle("Perhatian");
                        dialog.setMessage("Apakah data Anda sudah benar ?");
                //button postif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(confirm_activity.this,
                                "Terima kasih, pendaftaran anda telah berhasil"
                                , Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(confirm_activity.this,
                                        "pendaftaran anda tidak berhasil"
                                        , Toast.LENGTH_SHORT).show();
                            }
                        });
                        //tampilkan dialog
                        dialog.show();
                    }
                });




    }
}