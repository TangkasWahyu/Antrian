package com.apk.antrian.antrian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {
    EditText name, tanggal,alamat;
    TextView id;
    public static int nomor;
    private PrefManager pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_activity);

        name = (EditText) findViewById(R.id.nama);
        tanggal = (EditText) findViewById(R.id.tgl);
        alamat = (EditText) findViewById(R.id.alamat);
        pref = App.getInstance().getPref();

        Button klik = (Button) findViewById(R.id.daftar);
        klik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nomor++;
                pref.setNama(name.getText().toString());
                pref.setTanggal(tanggal.getText().toString());
                pref.setAlamat(alamat.getText().toString());
                pref.setId(nomor);
                Toast.makeText(DaftarActivity.this, "Nomor Antrian : " + nomor, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DaftarActivity.this, MainActivity.class);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
