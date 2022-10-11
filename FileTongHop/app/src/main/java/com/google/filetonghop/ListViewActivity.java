package com.google.filetonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    Boolean kt=false;
    int j=0;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listview;
        ArrayList<ThietBi> arrayList;
        button=(Button) findViewById(R.id.thembtn);
        com.google.filetonghop.Adapter adapter;



        listview = findViewById(R.id.listviewthietbi);
        arrayList = new ArrayList<>() ;
        arrayList.add ( new ThietBi( "Samsung Galaxy A22" ,"Ram 6GB/128GB " ,"4.190.000", R.drawable.img_samsunggalaxy22 ) ) ;
        arrayList.add ( new ThietBi( "Iphone11 Promax" , "Ram 6G/64GB " ,"10.000.000", R.drawable.img_ip11promax) ) ;
        arrayList.add ( new ThietBi( "Samsung Galaxy S22 Ultra" , "Ram 8GB/256GB" , "15.000.000",R.drawable.img_ssgalaxys22 ) ) ;
        arrayList.add ( new ThietBi( "Iphone13 Promax" , "Ram12GB/128GB ","25.490.000 ",R.drawable.img_ip13promax) ) ;
        arrayList.add ( new ThietBi( "Galaxy Zflip 3 5G" , "Ram 256GB" ,"28.500.000", R.drawable.ssgalaxy_zflip3 ) ) ;
        arrayList.add ( new ThietBi( "Asus Zfone 3 Ze520KI" , "Ram 64GB" ,"12.515.000", R.drawable.img_asus_zfone3 ) ) ;

        adapter = new com.google.filetonghop.Adapter( ListViewActivity.this,R.layout.layout_thietbi,arrayList) ;
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(ListViewActivity.this, DetailActivity.class);
                if (kt!=true)
                    startActivity(intent);
                kt=false;

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add ( new ThietBi( "Samsung Galaxy A22" ,"Ram 6GB/128GB " ,"4.190.000", R.drawable.img_samsunggalaxy22 ) ) ;
            adapter.notifyDataSetChanged();

            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent ,View view ,int position , long id) {
                kt= true;
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListViewActivity.this);
                dialog.setTitle("Xac nhan");
                dialog.setMessage("Ban co dong y xoa khong");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    }}


