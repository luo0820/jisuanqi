package com.example.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class huansuan extends AppCompatActivity {
    Button c,x,one,two,three,four,five,six,seven,eight,ninth,zero,dian;
    EditText text1,text2;
    Spinner s1,s2;
    String str="";
    String st1="",st2="",ht2;

    double hlv;
    private OkHttpClient o1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huansuan);

        kjian();
        c.setOnClickListener(this::onclick);
        x.setOnClickListener(this::onclick);
        one.setOnClickListener(this::onclick);
        two.setOnClickListener(this::onclick);
        three.setOnClickListener(this::onclick);
        four.setOnClickListener(this::onclick);
        five.setOnClickListener(this::onclick);
        six.setOnClickListener(this::onclick);
        seven.setOnClickListener(this::onclick);
        eight.setOnClickListener(this::onclick);
        ninth.setOnClickListener(this::onclick);
        zero.setOnClickListener(this::onclick);
        dian.setOnClickListener(this::onclick);

        text1.setOnClickListener(this::onclick);
        text2.setOnClickListener(this::onclick);

       s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String[]  s=getResources().getStringArray(R.array.huilv);
               Toast.makeText(huansuan.this,"你选择的是："+s[i],Toast.LENGTH_LONG).show();
              String[] ss1=s[i].split(" ");
               st1=ss1[1];
           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
       });
       s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String[]  s=getResources().getStringArray(R.array.huilv);
               Toast.makeText(huansuan.this,"兑换的是："+s[i],Toast.LENGTH_LONG).show();
               st2=s[i];
               String[] ss1=s[i].split(" ");
               st2=ss1[1];
               Log.v("TAG","输入："+st1+"\n"+"输出："+st2);
               if(st1.equals(st2)){
                   hlv=1.0;
               }else{
                   huoqu(st1,st2);
           }}
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
       });

    }

    private void huoqu(String s1,String s2) {

        o1=new OkHttpClient();
        new Thread(){
            public  void  run(){
                Request r1=new Request.Builder().url("https://api.jisuapi.com/exchange/convert?appkey=1a696c100a1d7314&from="+s1+"&to="+s2+"&amount=1").build();
                Call c1= o1.newCall(r1);
                try {

                    Response  r2=c1.execute();
                    String res=r2.body().string();
                    String[]  sres=res.split("\"");
//                    for (int i=0;i<sres.length;i++){
//                        Log.v("TAG","分割:"+sres[i]+"\n");
//                    }
                    res=sres[sres.length-8];
                    Log.v("TAG","比率:"+sres[sres.length-4]+"\n");
                    Log.v("TAG","时间:"+res+"\n");

                    hlv=Double.valueOf(sres[sres.length-4]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }.start();


    }

    private void kjian() {
        c=findViewById(R.id.clear);
        x=findViewById(R.id.del);
        one=findViewById(R.id.one1);
        two=findViewById(R.id.two1);
        three=findViewById(R.id.three1);
        four=findViewById(R.id.four1);
        five=findViewById(R.id.five1);
        six=findViewById(R.id.six1);
        seven=findViewById(R.id.seven1);
        eight=findViewById(R.id.eight1);
        ninth=findViewById(R.id.ninth1);
        zero=findViewById(R.id.zero1);
        dian=findViewById(R.id.dian1);

        text1=findViewById(R.id.edit1);
        text2=findViewById(R.id.edit2);

        s1=findViewById(R.id.spinner1);
        s2=findViewById(R.id.spinner2);
    }
    private void onclick(View v) {
        switch (v.getId()){
            case R.id.clear:
                str="";
                text1.setText("0");
                text2.setText("0");
                break;
            case R.id.del:
                str= tuige(str);
                text1.setText(str);
                break;
            case R.id.one1:
            case R.id.two1:
            case R.id.three1:
            case R.id.four1:
            case R.id.five1:
            case R.id.six1:
            case R.id.seven1:
            case R.id.eight1:
            case R.id.ninth1:
            case R.id.zero1:
            case R.id.dian1:
                if(str.equals("0")&&str.length()==1&&v.getId()!=R.id.dian1){
                    str="";
                }
                str+=((Button)v).getText();
                text1.setText(str);
                double re=Double.valueOf(str);
                double t2=re*hlv;
                ht2=String.valueOf(t2);
                text2.setText(ht2);
                break;

        }


    }
    private String tuige(String str) {
        if(str.length()>1){
            if(str.substring(str.length()-1,str.length()).equals(" ")){
                str=str.substring(0,str.length()-2);
            }else{
                str=str.substring(0,str.length()-1);
            }}else{
            str="0";
        }
        // Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return str;
    }

}