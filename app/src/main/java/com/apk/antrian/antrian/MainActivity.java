package com.apk.antrian.antrian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PrefManager pref;
    public static int nomor;
    private List<Person> list;
    private TextView no, jum;

    private AntrianAdapter antrianAdapter;
    private LinearLayoutManager layout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = App.getInstance().getPref();
        list = new ArrayList<>();
        nomor = getIntent().getIntExtra("nomor", 0);

        antrianAdapter = new AntrianAdapter(list);
        layout = new LinearLayoutManager(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(antrianAdapter);

        jum = (TextView) findViewById(R.id.jumlah);
        no = (TextView) findViewById(R.id.nomorakhir);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("User");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("User");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("main");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Main");
        tabHost.addTab(tabSpec);
        Button klik2 = (Button) findViewById(R.id.tambah);
        klik2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button klik = (Button) findViewById(R.id.keluar);
        klik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(list.size() == 0)
                    Toast.makeText(MainActivity.this, "Antrian Kosong", Toast.LENGTH_SHORT).show();
                else {
                    list.remove(0);
                    jum.setText(String.valueOf(list.size()));
                    antrianAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "KELUAR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                Person person = new Person();
                person.setNama(pref.getNama());
                person.setAlamat(pref.getAlamat());
                person.setTanggal(pref.getTanggal());
                person.setId(pref.getId());

                list.add(person);
                no.setText(String.valueOf(list.get(list.size()-1).getId()));
                jum.setText(String.valueOf(list.size()));
                antrianAdapter.notifyDataSetChanged();
            }
            if(resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
}